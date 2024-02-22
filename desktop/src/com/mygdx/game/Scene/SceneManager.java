package com.mygdx.game.Scene;

/**
 * SceneManager is responsible for managing different scenes in the game.
 * It allows for switching between scenes and ensures that each scene is properly initialized and disposed.
 */
public class SceneManager {
    private Scene currentScene; // Holds the currently active scene

    /**
     * Constructor for SceneManager.
     * Initializes the SceneManager with no active scene.
     */
    public SceneManager() {
    }

    /**
     * Sets the current scene of the game.
     * Disposes of the current scene if it exists and initializes the new scene.
     * 
     * @param scene The new scene to be set as the current scene.
     */
    public void setScene(Scene scene) {
        if (currentScene != null) {
            currentScene.dispose(); // Dispose the current scene to free up resources.
        }
        currentScene = scene; // Update the current scene.
        currentScene.create(); // Initialize the new scene.
    }

    /**
     * Renders the current scene.
     * This method delegates the rendering process to the active scene.
     */
    public void render() {
        if (currentScene != null) {
            currentScene.render(); // Delegate the render call to the current scene.
        }
    }

    /**
     * Disposes of the current scene.
     * This method is called to ensure proper cleanup of resources when the scene is no longer needed.
     */
    public void dispose() {
        if (currentScene != null) {
            currentScene.dispose(); // Ensure we clean up resources of the current scene.
        }
    }
}
