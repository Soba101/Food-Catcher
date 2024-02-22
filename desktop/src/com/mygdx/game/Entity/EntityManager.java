package com.mygdx.game.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * The EntityManager class is responsible for managing all entities in the game.
 * It keeps track of entities, updates their states, and handles their rendering.
 */
public class EntityManager {
    
    private List<Entity> entityList = new ArrayList<>(); // A list to store all entities.
    private SpriteBatch batch; // SpriteBatch used for rendering entities.
    private Map<String, Entity> entityMap = new HashMap<>(); // A map for quick access to entities by a string key.

    /**
     * Constructor for EntityManager. Initializes the manager.
     */
    public EntityManager() {
    }

    /**
     * Adds entities to the game. Initializes the SpriteBatch and creates specific entities.
     * Entities are added to both a list and a map for efficient update, draw, and access operations.
     */
    public void addEntity() {
        batch = new SpriteBatch();

        // Creating specific entities (e.g., bucket and mouse) with properties.
        Entity bucket = new TexturedObject("bucket.png", 300, 400, 100, 50, 250, false);
        Entity mouse = new TexturedObject("evil.png", 300, 0, 200, 200, 50, true); // Example sizes
        entityList.add(bucket);
        entityList.add(mouse);

        // Adding entities to the map with a unique identifier.
        entityMap.put("bucket", bucket);
        entityMap.put("mouse", mouse);

        // Randomly generating and adding 'droplet' entities to the list.
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int xPos = random.nextInt(600);
            int yPos = random.nextInt(300);
            TexturedObject droplet = new TexturedObject("droplet.png", xPos, yPos, 50, 50, 0, false);
            droplet.setTag("droplet"); // Set tag to identify as droplet
            entityList.add(droplet);
        }
    }
    
    /**
     * Updates the state of all entities. This method should be called regularly, e.g., in the game loop.
     */
    public void update() {
        for (Entity entity : entityList) {
            entity.update();
        }
    }
    
    /**
     * Draws all entities. This method should be called every frame to render entities on the screen.
     */
    public void draw() {
        for (Entity entity : entityList) {
            entity.draw(batch);
        }
    }
    
    /**
     * Manages the movement of all entities. This method should be used to update positions or handle movement logic.
     */
    public void movement() {
        for (Entity entity : entityList) {
            entity.movement();
        }
    }
    
    /**
     * Retrieves an entity by its identifier.
     * @param id The identifier of the entity to retrieve.
     * @return The entity if found, or null if not found.
     */
    public Entity getEntity(String id) {
        return entityMap.get(id); // This will return the entity if found, or null if not
    }
    
    /**
     * Gets a list of all entities.
     * @return A new list containing all entities. This prevents external modification of the internal list.
     */
    public List<Entity> getAllEntities() {
        return new ArrayList<>(entityList); // Return a copy to avoid modification outside
    }

    /**
     * Removes an entity from the game.
     * @param entity The entity to be removed.
     */
    public void removeEntity(Entity entity) {
        entityList.remove(entity);
        // Also remove from the map if necessary
        entityMap.values().remove(entity);
    }
    
}
