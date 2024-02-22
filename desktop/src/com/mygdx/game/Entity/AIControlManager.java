package com.mygdx.game.Entity;

import com.badlogic.gdx.Gdx;

/**
 * The AIControlManager class is responsible for controlling the movement of
 * AI-controlled entities.
 * It calculates the direction vector from the AI entity to the target entity
 * and updates the AI entity's position accordingly.
 */
public class AIControlManager {

    private Entity target; // The entity to follow
    private Entity aiEntity; // List of AI-controlled entities

    /**
     * Constructs a new AIControlManager object.
     */
    public AIControlManager() {

    }

    /**
     * Constructs a new AIControlManager object with the specified target and
     * AI-controlled entities.
     * 
     * @param target   The entity to follow
     * @param aiEntity The list of AI-controlled entities
     */
    public AIControlManager(Entity target, Entity aiEntity) {
        this.target = target;
        this.aiEntity = aiEntity; // Ensure this list only contains AI-controlled entities
        // this.speed = speed;
    }

    /**
     * Updates the AI-controlled entities' positions based on the target entity's
     * position.
     */
    public void update() {
        float targetX = target.getX();
        float targetY = target.getY();

        // Calculate the direction vector from aiEntity to target
        float directionX = targetX - aiEntity.getX();
        float directionY = targetY - aiEntity.getY();

        // Normalize the direction vector
        float length = (float) Math.sqrt(directionX * directionX + directionY * directionY);
        if (length != 0) { // Prevent division by zero
            directionX /= length;
            directionY /= length;
        }

        // Update the AI entity's position to move towards the target
        aiEntity.setX(aiEntity.getX() + directionX * aiEntity.getSpeed() * Gdx.graphics.getDeltaTime());
        aiEntity.setY(aiEntity.getY() + directionY * aiEntity.getSpeed() * Gdx.graphics.getDeltaTime());
    }

}
