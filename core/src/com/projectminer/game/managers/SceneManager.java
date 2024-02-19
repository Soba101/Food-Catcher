package com.mygdx.game.Scene;

public class SceneManager {
	private Scene currentScene;

    public void setScene(Scene scene) {
        if (currentScene != null) {
            currentScene.dispose(); // Dispose the current scene to free up resources
        }
        currentScene = scene;
        currentScene.create(); // Initialize the new scene
    }

    public void render() {
        if (currentScene != null) {
            currentScene.render(); // Delegate the render call to the current scene
        }
    }

    public void dispose() {
        if (currentScene != null) {
            currentScene.dispose(); // Ensure we clean up resources
        }
    }
	
}
