package com.mygdx.game.Entity;

public class CollisionManager {
    private EntityManager entityManager;

    public CollisionManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public GameState checkCollisions() {
        Entity bucket = entityManager.getEntity("bucket");
        Entity mouse = entityManager.getEntity("mouse");
        boolean allDropletsCollected = true; // Start with the assumption that all are collected

        if (bucket == null) {
            return GameState.CONTINUE; // Or consider a CRITICAL_ERROR GameState
        }

        // Check collision with mouse
        if (mouse != null && isCollision(bucket, mouse)) {
        	IOManager.playSound("collision", 0.2f); // Play collision sound effect
            System.out.println("Game Over! Player loses.");
            return GameState.LOSE_MOUSE;
        }

        // Check collision with droplets
        for (Entity entity : entityManager.getAllEntities()) {
            if (entity.hasTag("droplet")) {
                allDropletsCollected = false; // There's still at least one droplet
                if (isCollision(bucket, entity)) {
                	IOManager.playSound("collect", 0.4f); // Play droplet collection sound effect
                    System.out.println("Droplet Collected!");
                    entityManager.removeEntity(entity); // Remove collected droplet
                    break; // Assuming one collection per update
                }
            }
        }

        if (allDropletsCollected) {
            System.out.println("Player wins! All droplets collected.");
            return GameState.WIN;
        }

        return GameState.CONTINUE; // Default case: the game continues
    }


    private boolean isCollision(Entity e1, Entity e2) {
        // Calculate the distance between the centers of the two entities
        float dx = e2.getX() - e1.getX();
        float dy = e2.getY() - e1.getY();
        float distance = (float) Math.sqrt(dx * dx + dy * dy);

        // Assuming each entity has a method getWidth() to get its diameter,
        // and we consider entities to collide when their circular bounds intersect.
        // You might need to adjust this if your entities are not circular or use a different method to define their bounds.
        float radiusSum = (e1.getWidth() / 2) + (e2.getWidth() / 2);

        // Check if the distance between centers is less than the sum of their radii
        return distance < radiusSum;
    }

}


