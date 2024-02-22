package com.mygdx.game.Entity;

/**
 * The iMovable interface defines movement behaviors for entities in the game.
 * It declares methods for AI-controlled and user-controlled movement.
 * Entities implementing this interface can have different implementations of these movement types.
 */
public interface iMovable {
    /**
     * Method for AI-controlled movement.
     * This method should be implemented to define how an entity moves autonomously.
     */
    public void moveAIControlled();

    /**
     * Method for user-controlled movement.
     * This method should be implemented to define how an entity moves based on user input.
     */
    public void moveUserControlled();
}
