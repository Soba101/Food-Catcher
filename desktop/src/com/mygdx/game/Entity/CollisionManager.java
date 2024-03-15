package com.mygdx.game.Entity;

import com.badlogic.gdx.math.Rectangle;

/**
 * The CollisionManager class is responsible for managing collisions between
 * entities in the game.
 * It checks for collisions between the bucket and other entities, such as the
 * mouse and golds.
 * It also handles the logic for playing sound effects, removing collected
 * golds, and determining the game state.
 */
public class CollisionManager {
    private EntityManager entityManager;

    /**
     * Constructs a CollisionManager object with the specified EntityManager.
     * 
     * @param entityManager the EntityManager to be used for collision management
     */
    public CollisionManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Represents the current state of the game.
     */
    public GameState checkCollisions() {
        Entity bucket = entityManager.getEntity("bucket");
        Entity mouse = entityManager.getEntity("mouse");
        boolean allgoldsCollected = true; // Start with the assumption that all are collected

        if (bucket == null) {
            return GameState.CONTINUE; // Or consider a CRITICAL_ERROR GameState
        }

        // Check collision with mouse
        if (mouse != null && isCollision(bucket, mouse)) {
            IOManager.playSound("collision", 0.2f); // Play collision sound effect
            System.out.println("Game Over! Player loses.");
            return GameState.LOSE_MOUSE;
        }

        // Check collision with golds
        for (Entity entity : entityManager.getAllEntities()) {
            if (entity.hasTag("gold")) {
                allgoldsCollected = false; // There's still at least one gold
                if (isCollision(bucket, entity)) {
                    IOManager.playSound("collect", 0.4f); // Play gold collection sound effect
                    System.out.println("gold Collected!");
                    entityManager.removeEntity(entity); // Remove collected gold
                    break; // Assuming one collection per update
                }
            }
        }

        if (allgoldsCollected) {
            System.out.println("Player wins! All golds collected.");
            return GameState.WIN;
        }

        return GameState.CONTINUE; // Default case: the game continues
    }

    /**
     * Checks if there is a collision between two entities.
     * 
     * @param e1 the first entity
     * @param e2 the second entity
     * @return true if there is a collision, false otherwise
     */
    private boolean isCollision(Entity e1, Entity e2) {
    	Rectangle rect1 = e1.getBounds();
        Rectangle rect2 = e2.getBounds();

        // Use the overlaps method of Rectangle to check for collision
        return rect1.overlaps(rect2);
    }

}
