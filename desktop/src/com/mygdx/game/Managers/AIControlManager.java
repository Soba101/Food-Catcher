package com.mygdx.game.Managers;

import java.util.Iterator;
import java.util.List;
import com.mygdx.game.Entity.Collectibles;
import com.mygdx.game.Entity.Entity;
import com.mygdx.game.Movement.AIControl;

// Class to manage AI (Artificial Intelligence) controls for entities in the game.
public class AIControlManager {
    
    // EntityManager instance to manage various entities in the game.
    private EntityManager em;
    // AIControl instance to handle the AI logic.
    private AIControl aiControl;
    
    // Constructor for AIControlManager.
    public AIControlManager(EntityManager em) {
        this.em = em; // Set the EntityManager.
        aiControl = new AIControl(); // Initialize the AIControl.
    }
    
    // Initializes AI movement for applicable entities.
//    public void initializeMovement(){
//        // Retrieves the list of entities from the EntityManager.
//        List<Entity> entities = em.getEntityList();
//        
//        // Loop through each entity.
//        for (Entity entity : entities) {
//            // Check if the entity is an instance of Collectibles.
//            if (entity instanceof Collectibles) {
//                // Apply AI movement logic to the collectible entity.
//                aiControl.movement(entity);
//            }
//        }
//    }
    
    public void initializeMovement() {
        List<Entity> entities = em.getEntityList(); // Get the list of entities from EntityManager.
        Iterator<Entity> iterator = entities.iterator();

        while (iterator.hasNext()) {
            Entity entity = iterator.next();
            if (entity instanceof Collectibles) {
                aiControl.movement(entity); 
            }
        }
    }

    // Dispose method to clean up resources if necessary.
    public void dispose() {
        // If AIControl holds disposable resources, they should be disposed of here.
        // Currently, there's no explicit resource management, but it's a good practice
        // to include such mechanisms especially if the AIControl class uses resources
        // that need to be disposed of (like textures, sound assets, etc.).
    }

}
