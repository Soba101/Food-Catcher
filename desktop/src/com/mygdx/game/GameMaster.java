package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.mygdx.game.Scene.SceneManager;
import com.mygdx.game.Scene.StartScene;
import com.mygdx.game.Entity.IOManager;

/**
 * GameMaster is the main class of the game, extending ApplicationAdapter.
 * It sets up and manages the high-level game lifecycle, including scene management and global game settings.
 */
public class GameMaster extends ApplicationAdapter {
    
    public static final int width = 1080; // Static width setting for the game window.
    public static final int height = 720; // Static height setting for the game window.
    private SceneManager sceneManager; // Manager for controlling different scenes in the game.

    /**
     * This method is called when the game is first created.
     * Initializes the SceneManager and sets the initial scene of the game.
     */
    @Override
    public void create() {
        sceneManager = new SceneManager(); // Initialize SceneManager.
        sceneManager.setScene(new StartScene(sceneManager)); // Set the StartScene as the initial scene.

        IOManager.playBackgroundMusic(); // Start playing background music at the beginning of the game.
    }
    
    /**
     * This method is called periodically to render the game.
     * Delegates the rendering process to the SceneManager.
     */
    @Override
    public void render() {
        sceneManager.render(); // Render the current scene managed by SceneManager.
    }
    
    /**
     * This method is called when the game is closing.
     * Disposes resources used in the game to prevent memory leaks.
     */
    @Override
    public void dispose() {
        sceneManager.dispose(); // Dispose resources managed by the SceneManager.
        IOManager.dispose(); // Dispose audio resources managed by the IOManager.
    }
}
