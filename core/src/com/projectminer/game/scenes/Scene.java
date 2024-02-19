//Base class or interface for scenes

package com.mygdx.game.Scene;

public abstract class Scene {
	
	// Declare any common attributes here

    // Abstract method for scene creation
    public abstract void create();

    // Abstract method for scene rendering
    public abstract void render();

    // Abstract method for scene disposal/cleanup
    public abstract void dispose();

}
