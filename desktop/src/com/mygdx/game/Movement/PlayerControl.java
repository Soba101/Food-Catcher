package com.mygdx.game.Movement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.mygdx.game.Entity.Entity;

// Class for controlling the movement of the player entity.
public class PlayerControl {
    
    // Method to handle player movement.
    public void movement(Entity player) {
        float deltaTime = Gdx.graphics.getDeltaTime(); // Time elapsed since the last frame.
        float speed = player.getSpeed(); // The speed of the player entity.

        // Updating player's X position if LEFT or RIGHT key is pressed.
        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            // Move the player left, ensuring it doesn't go beyond the left edge of the screen.
            player.setX(Math.max(player.getX() - speed * deltaTime, 0));
        }
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            float maxX = Gdx.graphics.getWidth() - player.getTexture().getWidth();
            // Move the player right, ensuring it doesn't go beyond the right edge of the screen.
            player.setX(Math.min(player.getX() + speed * deltaTime, maxX));
        }
    }
}
