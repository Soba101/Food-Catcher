package com.mygdx.game.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;

public class EntityManager {
	
	private List<Entity> entityList = new ArrayList<>();
	private SpriteBatch batch;
	private Map<String, Entity> entityMap = new HashMap<>();

	
	public void EntityManager() {
	}

	public void addEntity() {
		batch = new SpriteBatch();
		
		Entity bucket = new TexturedObject("bucket.png", 300, 400, 100, 50, 250, false);
		Entity mouse = new TexturedObject("evil.png", 300, 0, 200, 200, 50, true); // Example sizes
		entityList.add(bucket);
		entityList.add(mouse);
		
		entityMap.put("bucket", bucket);
	    entityMap.put("mouse", mouse);

		
		//entityList.add(new TexturedObject("bucket.png", 300, 400, 200,false));
		//entityList.add(new TexturedObject("badlogic.jpg", 300, 0, 100,true));

		Random random = new Random();
		for (int i = 0; i < 6; i++) {
            int xPos = random.nextInt(600);
            int yPos = random.nextInt(300);
            TexturedObject droplet = new TexturedObject("droplet.png", xPos, yPos, 50, 50, 0, false);
            droplet.setTag("droplet"); // Set tag to identify as droplet
            entityList.add(droplet);
            
        }
	}
	
	public void update() {
		for (Entity entity : entityList){
				entity.update();
			}
		
	}
	
	public void draw() {
		for (Entity entity : entityList){
				entity.draw(batch);
				
			}
		
	}
	
	public void movement() {
		for (Entity entity : entityList){
				entity.movement();
			}
		
	}
	
	public Entity getEntity(String id) {
	    return entityMap.get(id); // This will return the entity if found, or null if not
	}
	
	public List<Entity> getAllEntities() {
	    return new ArrayList<>(entityList); // Return a copy to avoid modification outside
	}


	public void removeEntity(Entity entity) {
	    entityList.remove(entity);
	    // Also remove from the map if necessary
	    entityMap.values().remove(entity);
	}
	
}
