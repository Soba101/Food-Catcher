package com.mygdx.game.Managers;

import java.util.Iterator;
import java.util.List;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Entity.Entity;
import com.mygdx.game.Entity.Player;
import com.mygdx.game.Entity.Collectibles;

// Class responsible for managing collisions in the game.
public class CollisionManager {

    private EntityManager em; // Instance of EntityManager to manage game entities.
    // Constructor for CollisionManager.
    public CollisionManager(EntityManager em) {
        this.em = em;
    }
    
    // Method to check for and handle collisions.

	public void checkCollisions() {
	    List<Entity> entities = em.getEntityList();
	    Iterator<Entity> entityIterator = entities.iterator();
	    Entity p = null;

	    // First, find the player entity.
	    while (entityIterator.hasNext()) {
	        Entity entity = entityIterator.next();
	        if (entity instanceof Player) {
	            p = entity;
	            break; // Found the player, no need to continue this loop.
	        }
	    }

	    // If no player is found, no need to check for collisions.
	    if (p == null) return;

	    // Use another iterator for checking collisions to safely remove items.
	    entityIterator = entities.iterator(); // Reset iterator to use it from the beginning again.
	    while (entityIterator.hasNext()) {
	        Entity entity = entityIterator.next();
	        // Ensure not comparing the player with itself and check for collision.
	        if (entity != p && isCollision(p, entity)) {
	            // If the entity is a Collectible, handle the collision.
	            if (entity instanceof Collectibles) {
	                Collectibles collectible = (Collectibles) entity;
	                ScoreManager.addPoints(collectible.getPoints()); // Adjust score
	                if (collectible.getPoints() > 0) {
	                IOManager.getInstance().playSound("collect", 1.0f); 
	                }else{
		            IOManager.getInstance().playSound("wrong-buzzer", 0.5f); 

	                }// Play collection sound
	                entityIterator.remove(); // Remove the collectible from the list safely.
	            }
	        }
	    }
	}
    
    // Helper method to check if two entities are colliding.
    private boolean isCollision(Entity e1, Entity e2) {
        Rectangle rect1 = e1.getBounds();
        Rectangle rect2 = e2.getBounds();

        // Check if the bounding rectangles of the entities overlap.
        return rect1.overlaps(rect2);
    }

    // Dispose method to clean up resources, if necessary.
    public void dispose() {
        // This method would be necessary if there were resources that needed explicit cleanup.
        // If there are no such resources, this method can be omitted.
    }
    
}
