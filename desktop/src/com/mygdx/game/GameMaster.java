package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.mygdx.game.Scene.SceneManager;
import com.mygdx.game.Scene.StartScene;
import com.mygdx.game.Entity.IOManager;

public class GameMaster extends ApplicationAdapter{
	
	public static final int width = 1080;
	public static final int height = 720;
	private SceneManager sceneManager;


	@Override
	public void create() {
		sceneManager = new SceneManager();
	    sceneManager.setScene(new StartScene(sceneManager)); // Initialize and set the StartScene as the current scene
	    IOManager.playBackgroundMusic(); // Start playing the background music using IOManager
        
	}
	
	@Override
	public void render() {
		sceneManager.render();
	}
	
	@Override
	public void dispose() {
	    sceneManager.dispose(); // Dispose resources managed by SceneManager
	    IOManager.dispose(); // Dispose resources managed by IOManager
    }
}
