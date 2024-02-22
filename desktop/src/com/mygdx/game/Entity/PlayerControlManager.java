package com.mygdx.game.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

/**
 * The PlayerControlManager class handles the input for player-controlled movements.
 * It updates the position of the player entity based on keyboard input.
 */
public class PlayerControlManager {
    private Entity playerEntity; // Reference to the player entity.

    /**
     * Constructor for PlayerControlManager.
     * @param playerEntity The player entity that this manager will control.
     */
    public PlayerControlManager(Entity playerEntity) {
        this.playerEntity = playerEntity;
    }

    /**
     * Handles keyboard input and updates the player's position accordingly.
     * It reacts to the arrow keys for directional movement.
     */
    public void handleInput() {
        float deltaTime = Gdx.graphics.getDeltaTime(); // Time elapsed since the last frame.
        float speed = playerEntity.getSpeed(); // The speed of the player entity.

        // Updating player's X position if LEFT or RIGHT key is pressed.
        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            playerEntity.setX(playerEntity.getX() - speed * deltaTime);
        }
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            playerEntity.setX(playerEntity.getX() + speed * deltaTime);
        }

        // Updating player's Y position if UP or DOWN key is pressed.
        if (Gdx.input.isKeyPressed(Keys.DOWN)) {
            playerEntity.setY(playerEntity.getY() - speed * deltaTime);
        }
        if (Gdx.input.isKeyPressed(Keys.UP)) {
            playerEntity.setY(playerEntity.getY() + speed * deltaTime);
        }
    }
}
