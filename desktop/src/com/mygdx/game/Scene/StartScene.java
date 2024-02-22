package com.mygdx.game.Scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 * StartScene represents the start screen of the game.
 * It extends the Scene class, displaying the initial game screen and handling the transition to the main game.
 */
public class StartScene extends Scene {
    
    private SceneManager sceneManager; // Manager to handle scene transitions.
    private Texture backgroundTexture; // Texture for the background of the start screen.
    private Stage stage; // Stage to manage UI elements and input events.

    /**
     * Constructor for StartScene.
     * @param sceneManager SceneManager to control scene transitions.
     */
    public StartScene(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
        backgroundTexture = new Texture(Gdx.files.internal("startscreen.png"));
        // Commented out the create method to avoid immediate initialization.
        // create();
    }

    /**
     * Initializes the start scene components.
     * Sets up the background, stage, and input handling for the start screen.
     */
    @Override
    public void create() {
        stage = new Stage(new ScreenViewport()); // Initialize stage with a viewport.
        backgroundTexture = new Texture(Gdx.files.internal("startscreen.png")); // Load background texture.
        
        Image backgroundImage = new Image(backgroundTexture); // Create image actor for background.
        backgroundImage.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()); // Set size of background to fill screen.
       
        stage.addActor(backgroundImage); // Add background image to stage.

        Gdx.input.setInputProcessor(stage); // Set input processor to stage to handle touch events.

        // Add click listener to stage for handling touch events.
        stage.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Screen Clicked"); // Console output for debugging.
                sceneManager.setScene(new GameScene(sceneManager)); // Transition to the GameScene on click.
            }
        });
    }

    /**
     * Renders the start scene.
     * Clears the screen and draws the stage with its actors.
     */
    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear the screen.
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f)); // Update the stage actors.
        stage.draw(); // Draw the stage and its actors.
    }

    /**
     * Disposes of the resources used in the scene.
     * Cleans up the background texture.
     */
    @Override
    public void dispose() {
        backgroundTexture.dispose(); // Dispose of the background texture.
    }
}
