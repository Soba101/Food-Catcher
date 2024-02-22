package com.mygdx.game.Scene;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.Entity.AIControlManager;
import com.mygdx.game.Entity.Entity;
import com.mygdx.game.Entity.EntityManager;
import com.mygdx.game.Entity.CollisionManager;
import com.mygdx.game.Entity.GameState;



public class GameScene extends Scene{
	
	private SceneManager sceneManager;
	private EntityManager entityManager;
	private AIControlManager aiControlManager;
    private Texture backgroundTexture;
    private Stage stage; // Use Stage for UI components
    private Label timerLabel;
    private float timer = 30.0f;
    private CollisionManager collisionManager;
	EntityManager em;



	public GameScene(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
        create();
    }

	@Override
	public void create() {
		
		entityManager = new EntityManager();
		aiControlManager = new AIControlManager();
		entityManager.addEntity();
		
        // Initialize CollisionManager
        collisionManager = new CollisionManager(entityManager);
		
        stage = new Stage(new ScreenViewport());

        backgroundTexture = new Texture(Gdx.files.internal("gamescreen.png"));
        Image backgroundImage = new Image(backgroundTexture);
        stage.addActor(backgroundImage);
        backgroundImage.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        LabelStyle labelStyle = new LabelStyle(new BitmapFont(), com.badlogic.gdx.graphics.Color.WHITE);
        timerLabel = new Label(String.format("%.2f", timer), labelStyle);

        timerLabel.setPosition(Gdx.graphics.getWidth() - timerLabel.getWidth() - 20, Gdx.graphics.getHeight() - timerLabel.getHeight() - 20);
        stage.addActor(timerLabel);
        
        Entity mouse = entityManager.getEntity("mouse");
	    Entity bucket = entityManager.getEntity("bucket");
	    aiControlManager = new AIControlManager(bucket,mouse);
	}
	

	public void render() {
	    ScreenUtils.clear(1, 0, 0, 0);

	    // Timer decrement and format update
	    if (timer > 0) {
	        timer -= Gdx.graphics.getDeltaTime();
	        timerLabel.setText(String.format("%.2f", timer));
	    }

	    // Update and draw stage elements
	    stage.act(Gdx.graphics.getDeltaTime());
	    stage.draw();

	    // Update entities
	    aiControlManager.update();
	    entityManager.update();
	    entityManager.draw();
	    entityManager.movement();

	    GameState gameState = collisionManager.checkCollisions();

	    if (gameState == GameState.WIN) {
	        sceneManager.setScene(new EndScene2(sceneManager)); // Go to winning scene
	    } else if (gameState == GameState.LOSE_MOUSE) {
	        sceneManager.setScene(new EndScene(sceneManager)); // Go to losing scene
	    }

	    // Handle timer expiration separately, assuming it's tracked in GameScene
	    if (timer <= 0) {
	        sceneManager.setScene(new EndScene(sceneManager)); // Time's up, go to losing scene
	    }
	}

	@Override
	public void dispose() {
		//batch.dispose();
		stage.dispose();
        backgroundTexture.dispose();
		
	}

}
