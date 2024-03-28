package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Managers.AIControlManager;
import com.mygdx.game.Managers.CollisionManager;
import com.mygdx.game.Managers.EntityManager;
import com.mygdx.game.Managers.PlayerControlManager;
import com.mygdx.game.Managers.SceneManager;
import com.mygdx.game.Managers.ScoreManager;
import com.mygdx.game.Managers.SimulationManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class PlayState extends State {
    private EntityManager em;
    private PlayerControlManager pcm;
    private AIControlManager acm;
    private CollisionManager cm;
    private BitmapFont scoreFont;
    private SceneManager sceneManager;
    private float timer;
    private int levelNumber;
    private static final int MAX_LEVELS = 2; // Set to the total number of levels you have
    private static final float LEVEL_TIME = 60; // Time per level
    private int targetScore; // Dynamic target score based on level

    public PlayState(SimulationManager sm, int levelNumber) {
        super(sm);
        this.levelNumber = levelNumber;
        
        em = new EntityManager();
        pcm = new PlayerControlManager(em);
        acm = new AIControlManager(em);
        cm = new CollisionManager(em);
        scoreFont = new BitmapFont();
        sceneManager = new SceneManager();
        ScoreManager.resetScore(); // Reset the score for the new level
        
     // Set the target score for the current level
        this.targetScore = 100 + (levelNumber - 1) * 40; // Starting from 20 and incrementing by 40 each level
        
        timer = LEVEL_TIME; // Set the level timer
        loadLevel();
    }

    private void loadLevel() {
        sceneManager.loadBackground("backgrounds/level" + levelNumber + ".png"); // Load the correct level background
        em.spawn(); // Initialize entities for the level
        // Any other level-specific setup would go here
    }
    
    @Override
    public void update() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        timer -= deltaTime;
        System.out.println("Updating PlayState - Timer: " + timer + ", Score: " + ScoreManager.getScore());

        pcm.initializeMovement();
        acm.initializeMovement();
        cm.checkCollisions();

        if (ScoreManager.getScore() >= this.targetScore) {
            if (levelNumber >= MAX_LEVELS) {
            	System.out.println("PLayer Completed all levels, transitioning to WinState");
                sm.set(new WinState(sm, levelNumber));
            } else {
            	System.out.println("Player hit score target, transitioning to PassState");
                sm.set(new PassState(sm, levelNumber));
            }
        } else if (timer <= 0) {
        	System.out.println("Timer ran out, transitioning to FailState");
            sm.set(new FailState(sm, levelNumber));
        }
        
        //for debugging
        //if (timer <= 0) {
          //  System.out.println("Timer ran out, transitioning to FailState");
        //}
    }


    @Override
    public void render(SpriteBatch sb) {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        sceneManager.renderBackgrounds(sb); // Render the background for the current level
        sb.begin();
        em.draw(sb); // Draw entities

        // Render the level information and score
        float scoreX = 10;
        float scoreY = Gdx.graphics.getHeight() - 10;
        scoreFont.getData().setScale(1.5f); // Scale the font size up by 2x
        scoreFont.draw(sb, "Score: " + ScoreManager.getScore(), scoreX, scoreY);
        float levelTextY = scoreY - 20;
        scoreFont.draw(sb, "Level " + levelNumber, scoreX, levelTextY);
        GlyphLayout layout = new GlyphLayout(scoreFont, "Timer: " + String.format("%.2f", Math.max(timer, 0)));
        float timeX = Gdx.graphics.getWidth() - layout.width - 10;
        scoreFont.draw(sb, "Timer: " + String.format("%.2f", Math.max(timer, 0)), timeX, scoreY);

        sb.end();
    }

    @Override
    public void dispose() {
        scoreFont.dispose();
        em.dispose();
        pcm.dispose();
        acm.dispose();
        cm.dispose();
        sceneManager.dispose();
        System.out.println("Play State Disposed.");
    }
}
