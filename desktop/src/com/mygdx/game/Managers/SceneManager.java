package com.mygdx.game.Managers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

// Class for managing scene backgrounds.
public class SceneManager {
    private List<Texture> backgrounds; // List to store background textures.

    // Constructor for SceneManager.
    public SceneManager() {
        backgrounds = new ArrayList<>(); // Initialize the list of backgrounds.
    }

    // Method to load and add a new background.
    public void loadBackground(String backgroundPath) {
        Texture newBackground = new Texture(backgroundPath); // Load the background texture.
        backgrounds.add(newBackground); // Add the new background to the list.
    }

    // Method to render all loaded backgrounds.
    public void renderBackgrounds(SpriteBatch batch) {
        for (Texture background : backgrounds) {
            batch.begin();
            batch.draw(background, 0, 0); // Draw each background.
            batch.end();
        }
    }

    // Method to clear all backgrounds from memory.
    public void clearBackgrounds() {
        for (Texture background : backgrounds) {
            background.dispose(); // Dispose of each background texture.
        }
        backgrounds.clear(); // Clear the list of backgrounds.
    }
    
    // Dispose method to ensure all resources are freed.
    public void dispose() {
        clearBackgrounds(); // Dispose of all backgrounds when the SceneManager is disposed.
    }
}
