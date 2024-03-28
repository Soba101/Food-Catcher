package com.mygdx.game.Managers;

import java.util.Iterator;
import java.util.List;
import com.mygdx.game.Entity.Entity;
import com.mygdx.game.Entity.Player;
import com.mygdx.game.Movement.PlayerControl;

// Class responsible for managing player controls in the game.
public class PlayerControlManager {
    
    private EntityManager em; // Instance of EntityManager.
    private PlayerControl playerControl; // Instance of PlayerControl to manage player's movements.

    // Constructor for PlayerControlManager.
    public PlayerControlManager(EntityManager em) {
        this.em = em; // Assign the EntityManager.
        playerControl = new PlayerControl(); // Initialize the PlayerControl.
    }
    
    // Method to initialize movement for the player.
//    public void initializeMovement(){
//        List<Entity> entities = em.getEntityList(); // Get the list of entities from EntityManager.
//        
//        // Loop through the entities to find the player.
//        for (Entity entity : entities) {
//            if (entity instanceof Player) {
//                playerControl.movement(entity); // Apply movement logic to the player.
//            }
//        }
//    }
    
    public void initializeMovement() {
        List<Entity> entities = em.getEntityList(); // Get the list of entities from EntityManager.
        Iterator<Entity> iterator = entities.iterator();

        // Loop through the entities to find the player using an iterator.
        while (iterator.hasNext()) {
            Entity entity = iterator.next();
            if (entity instanceof Player) {
                playerControl.movement(entity); // Apply movement logic to the player.
                break; // Assuming there's only one player, we can break after applying movement.
            }
        }
    }

    // Dispose method for cleaning up resources.
    public void dispose() {
        // Dispose of resources used by PlayerControl, if there are any.
        // Currently, this method doesn't have an implementation but can be
        // useful if PlayerControl uses disposable resources in the future.
    }
}
