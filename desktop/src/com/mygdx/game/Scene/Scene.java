package com.mygdx.game.Scene;

public abstract class Scene {
	protected SceneManager sm;
	
	public Scene() {
		
	}
	
	public Scene(SceneManager sm) {
		this.sm = sm;
	}
	
	//public abstract void handleInput();
	//public abstract void update(float dt);

    // Abstract method for scene creation
    public abstract void create();

    // Abstract method for scene rendering
    public abstract void render();

    // Abstract method for scene disposal/cleanup
    public abstract void dispose();

}
