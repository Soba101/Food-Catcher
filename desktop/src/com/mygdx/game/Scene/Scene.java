package com.mygdx.game.Scene;

/**
 * The Scene class is an abstract base class for different scenes in the game, like menus, game screens, etc.
 * It provides a structure for creating, rendering, and disposing of scenes, and is meant to be extended by specific scene implementations.
 */
public abstract class Scene {
    protected SceneManager sm; // SceneManager instance to manage transitions between scenes

    /**
     * Default constructor for Scene.
     */
    public Scene() {
    }

    /**
     * Constructor for Scene with a SceneManager.
     * @param sm The SceneManager that will manage this scene.
     */
    public Scene(SceneManager sm) {
        this.sm = sm; // Set the scene manager for this scene.
    }
    
    // Other methods such as handleInput and update could be uncommented and used if needed.

    /**
     * Abstract method to create and initialize the scene.
     * This method must be implemented by subclasses to set up the scene-specific elements.
     */
    public abstract void create();

    /**
     * Abstract method to render the scene.
     * Subclasses should implement this method to define how the scene is drawn and rendered.
     */
    public abstract void render();

    /**
     * Abstract method for disposing of the scene's resources.
     * This method should be implemented by subclasses to release resources and perform cleanup.
     */
    public abstract void dispose();
}
