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

public class PassState extends State {
    private Texture background; // Background texture for the pass state
    private Stage stage; // Stage for UI elements
    private BitmapFont font; // Font for text rendering
    private Label passLabel; // Label indicating pass status
    private Label scoreLabel; // Label displaying the player's score
    private Texture winImage; // Texture for the happy boy image

    public PassState(SimulationManager sm, int levelNumber) {
        super(sm); // Call the superclass constructor

        // Load the background and happy boy image textures
        background = new Texture("backgrounds/level" + levelNumber + ".png");
        winImage = new Texture("entity/happyboy.png");

        stage = new Stage(); // Initialize the stage for UI elements
        Gdx.input.setInputProcessor(stage); // Set the input processor to handle UI events

        font = new BitmapFont(); // Initialize the font for text rendering

        LabelStyle labelStyle = new LabelStyle(); // Style for labels
        labelStyle.font = font; // Set the font for the label style
        labelStyle.fontColor = Color.WHITE; // Set the font color to white

        // Create and configure the pass label
        passLabel = new Label("PASS!", labelStyle); 
        passLabel.setFontScale(2.0f); // Set the font scale
        passLabel.setSize(Gdx.graphics.getWidth(), 100); // Set the size of the label
        passLabel.setPosition(0, Gdx.graphics.getHeight() / 2 + 100); // Set the position of the label
        passLabel.setAlignment(Align.center); // Set the alignment of the label
        stage.addActor(passLabel); // Add the label to the stage

        // Create and configure the score label
        scoreLabel = new Label("Score: " + ScoreManager.getScore(), labelStyle);
        scoreLabel.setFontScale(1.5f); // Set the font scale
        scoreLabel.setSize(Gdx.graphics.getWidth(), 100); // Set the size of the label
        scoreLabel.setPosition(0, Gdx.graphics.getHeight() / 2 + 50); // Set the position of the label
        scoreLabel.setAlignment(Align.center); // Set the alignment of the label
        stage.addActor(scoreLabel); // Add the label to the stage

        TextButtonStyle textButtonStyle = new TextButtonStyle(); // Style for text buttons
        textButtonStyle.font = font; // Set the font for the text button style
        textButtonStyle.fontColor = Color.WHITE; // Set the font color to white

        // Create and configure the continue button
        TextButton continueButton = new TextButton("Continue", textButtonStyle);
        continueButton.setPosition(Gdx.graphics.getWidth() / 2 - 150, Gdx.graphics.getHeight() / 2 - 50);
        continueButton.setSize(300, 60);
        continueButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                sm.set(new PlayState(sm, levelNumber + 1)); // Set the next level to play
            }
        });
        stage.addActor(continueButton); // Add the continue button to the stage

        // Create and configure the quit button
        TextButton quitButton = new TextButton("Quit", textButtonStyle);
        quitButton.setPosition(Gdx.graphics.getWidth() / 2 - 150, Gdx.graphics.getHeight() / 2 - 120);
        quitButton.setSize(300, 60);
        quitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit(); // Exit the game
            }
        });
        stage.addActor(quitButton); // Add the quit button to the stage
    }

    @Override
    public void render(SpriteBatch sb) {
        ScreenUtils.clear(0, 0, 0.2f, 1); // Clear the screen with a dark blue color
        sb.begin();
        sb.draw(background, 0, 0); // Draw the background texture
        sb.draw(winImage, 200, 140); // Draw the happy boy image
        sb.end();

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f)); // Update the stage
        stage.draw(); // Draw the stage
    }

    @Override
    public void dispose() {
        background.dispose(); // Dispose of the background texture
        winImage.dispose(); // Dispose of the happy boy image texture
        stage.dispose(); // Dispose of the stage
        font.dispose(); // Dispose of the font
        System.out.println("Pass State Disposed."); // Print a message indicating the state has been disposed
    }

    @Override
    public void update() {
        // Add any update logic if needed
    }
}

