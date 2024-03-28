package com.mygdx.game.Managers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import com.mygdx.game.Entity.Collectibles;
import com.mygdx.game.Entity.Entity;
import com.mygdx.game.Entity.FoodLibraryInfo;
import com.mygdx.game.Entity.Player;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

// Class responsible for managing all game entities.
public class EntityManager {
    
    private List<Entity> entityList; // List to store all entities.
    private Entity player; // Reference to the player entity.
    private final int number = 100; // Number of collectibles to spawn.
    private Entity[] collectible = new Entity[number]; // Array to store collectible entities.
    private boolean isSpawned = false; // Flag to check if entities have been spawned.

    // Constructor for EntityManager.
    public EntityManager() {
        entityList = new ArrayList<Entity>(); // Initialize the list of entities.
    }
    
    // Method to add an entity to the list.
    public void addEntity(Entity e) {
        entityList.add(e);
    }
    
    // Method to return the list of entities.
    public List<Entity> getEntityList() {
        return entityList;
    }
    
    // Method to draw all entities.
//    public void draw(SpriteBatch batch) {
//        for (Entity entity : entityList) {
//            entity.draw(batch); // Draw each entity using the passed SpriteBatch.
//        }
//        // Note: The caller should manage batch.begin() and batch.end().
//    }
    
    public void draw(SpriteBatch batch) {
        Iterator<Entity> iterator = entityList.iterator();
        while (iterator.hasNext()) {
            Entity entity = iterator.next();
            entity.draw(batch); // Draw each entity using the passed SpriteBatch.
        }
        // Note: The caller should manage batch.begin() and batch.end().
    }
    
    // Method to update all entities.
    public void update() {
        for (Entity entity : entityList) {
            entity.update(); // Update each entity.
        }
    }
    
    // Method to spawn the player and collectibles.
    public void spawn() {
        if (isSpawned) return; // Prevent spawning if already done.

        // Create and add the player entity.
        player = new Player("entity/plate.png", 540, 100, 200, 64, 64);
        addEntity(player);
        
        // Spawn and add collectible entities.
        Random random = new Random();
        for (int i = 0; i < number; i++) {
            int xPos = random.nextInt(1000); // Random X position.
            int yPos = random.nextInt(8000) + 800; // Random Y position.
            int speed = random.nextInt(3)+1; // Random speed.

            // Get random food information for the collectible.
            FoodLibraryInfo foodLibraryInfo = Collectibles.getFoodLibraryInfo();
            
            // Create and add the collectible entity.
            collectible[i] = new Collectibles(foodLibraryInfo.getText(), xPos, yPos, speed, 64, 64, foodLibraryInfo.getPoints());
            addEntity(collectible[i]);
        }
        isSpawned = true; // Set the flag indicating entities have been spawned.
    }

    // Method to dispose of all entities.
    public void dispose() {
        for (Entity entity : entityList) {
            entity.dispose(); // Dispose each entity.
        }
        // Any other resources managed by EntityManager should also be disposed of here.
    }
}
