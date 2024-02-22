package com.mygdx.game.Scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 * The EndScene2 class represents a specific end screen of the game, typically used for displaying a win screen.
 * It extends the Scene class and manages the display of this particular end screen.
 */
public class EndScene2 extends Scene {
    
    private Texture backgroundTexture; // Texture for the background image of the end screen.
    private Stage stage; // Stage to hold and manage actors like the background image.

    /**
     * Constructor for EndScene2.
     * @param sceneManager The scene manager that manages this scene.
     */
    public EndScene2(SceneManager sceneManager) {
        create(); // Initialize the scene components.
    }

    /**
     * Initializes the scene's components.
     * Sets up the stage, loads the background texture, and creates and positions the background image.
     * This method specifically sets up the "winscreen" texture.
     */
    @Override
    public void create() {
        stage = new Stage(new ScreenViewport()); // Creating a new stage with a screen viewport.
        backgroundTexture = new Texture(Gdx.files.internal("winscreen.png")); // Loading the win screen texture.

        Image backgroundImage = new Image(backgroundTexture); // Creating an image actor with the win screen texture.
        stage.addActor(backgroundImage); // Adding the background image to the stage.

        // Setting the size of the background image to fill the screen.
        backgroundImage.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    /**
     * Renders the win end scene.
     * Clears the screen and draws the stage and its actors.
     */
    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear the screen to prepare for rendering.
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f)); // Update the stage's actors.
        stage.draw(); // Draw the stage and its actors.
    }

    /**
     * Disposes of the resources used by the scene.
     * Releases the background texture to free up memory.
     */
    @Override
    public void dispose() {
        backgroundTexture.dispose(); // Dispose of the background texture.
    }
}
