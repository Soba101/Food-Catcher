package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Managers.ScoreManager;
import com.mygdx.game.Managers.SimulationManager;

// State for handling the game over scenario when the player fails.
public class FailState extends State {
    private Texture background;
    private Texture loseImage;
    private Stage stage;
    private BitmapFont font;
    private Label failLabel;
    private Label scoreLabel;

    // Constructor for FailState.
    public FailState(SimulationManager sm, int levelNumber) {
        super(sm);
        background = new Texture("backgrounds/Lose.png");
        loseImage = new Texture("entity/fatboy.png");

        stage = new Stage();
        Gdx.input.setInputProcessor(stage); // Set the input processor to the stage.

        font = new BitmapFont();

        // Set up label styles.
        LabelStyle labelStyle = new LabelStyle();
        labelStyle.font = font;
        labelStyle.fontColor = Color.WHITE;

        // Create "FAIL" label.
        failLabel = new Label("FAIL!", labelStyle);
        failLabel.setFontScale(2.0f);
        failLabel.setSize(Gdx.graphics.getWidth(), 100);
        failLabel.setPosition(0, Gdx.graphics.getHeight() / 2 + 100);
        failLabel.setAlignment(Align.center);
        stage.addActor(failLabel);
        
        // Create score label to display the player's score.
        scoreLabel = new Label("Score: " + ScoreManager.getScore(), labelStyle);
        scoreLabel.setFontScale(1.5f);
        scoreLabel.setSize(Gdx.graphics.getWidth(), 100);
        scoreLabel.setPosition(0, Gdx.graphics.getHeight() / 2 + 50);
        scoreLabel.setAlignment(Align.center);
        stage.addActor(scoreLabel);

        // Create retry button to retry the level.
        TextButtonStyle textButtonStyle = new TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.fontColor = Color.WHITE;

        TextButton retryButton = new TextButton("Retry", textButtonStyle);
        retryButton.setPosition(Gdx.graphics.getWidth() / 2 - 150, Gdx.graphics.getHeight() / 2 - 50);
        retryButton.setSize(300, 60);
        retryButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                sm.set(new PlayState(sm, levelNumber)); // Retry the same level
            }
        });
        stage.addActor(retryButton);

        // Create quit button to exit the game.
        TextButton quitButton = new TextButton("Quit", textButtonStyle);
        quitButton.setPosition(Gdx.graphics.getWidth() / 2 - 150, Gdx.graphics.getHeight() / 2 - 120);
        quitButton.setSize(300, 60);
        quitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });
        stage.addActor(quitButton);
    }

    // Render method to draw the background, images, and buttons.
    @Override
    public void render(SpriteBatch sb) {
        ScreenUtils.clear(0, 0, 0.2f, 1); // Clear the screen with a dark blue color.
        sb.begin();
        sb.draw(background, 0, 0);
        sb.draw(loseImage, 300, 140);
        sb.end();

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f)); // Update the stage.
        stage.draw(); // Draw the stage.
    }

    // Dispose method to clean up resources.
    @Override
    public void dispose() {
        background.dispose();
        loseImage.dispose();
        stage.dispose();
        font.dispose();
    }

    // Update method to handle any necessary updates.
    @Override
    public void update() {
        // Add any update logic if needed
        // For example, updating timers, scores, etc.
    }
}
