package com.mygdx.game.Entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

// Class representing the player in the game, extending the Entity class.
public class Player extends Entity {
    
    // Default constructor for the Player.
    public Player() {
        // This constructor is empty but can be used for default initialization.
    }
    
    // Overloaded constructor for creating a Player with specific attributes.
    public Player(String texture, float x, float y, float speed, float height, float width) {
        super(texture, x, y, speed, height, width); // Call to the parent (Entity) class constructor.
        // Additional initialization specific to Player can be added here.
    }

    // Overridden draw method for rendering the player.
    @Override
    public void draw(SpriteBatch batch) {
        // Draws the player's texture at its current position.
        batch.draw(getTexture(), getX(), getY(), getTexture().getWidth(), getTexture().getHeight());
    }

    // Overridden update method - to define the player's behavior.
    @Override
    public void update() {
        // Logic for updating the player's state should be implemented here.
        // This could include movement, collision detection, etc.
    }

}
