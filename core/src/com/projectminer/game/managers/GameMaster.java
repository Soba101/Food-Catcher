package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.mygdx.game.Scene.SceneManager;
import com.mygdx.game.Scene.StartScene;

public class GameMaster extends ApplicationAdapter{
	
	private SceneManager sceneManager;

	@Override
	public void create() {
		sceneManager = new SceneManager();
        sceneManager.setScene(new StartScene(sceneManager)); // Initialize and set the StartScene as the current scene
        
	}
	
	@Override
	public void render() {
		sceneManager.render();
	}
	
	@Override
    public void dispose() {
        sceneManager.dispose(); // Dispose resources when the game is closed
    }
}
