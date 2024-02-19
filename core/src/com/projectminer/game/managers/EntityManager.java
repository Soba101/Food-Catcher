package com.mygdx.game.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;

public class EntityManager {
	
	private List<Entity> entityList = new ArrayList<>();
	private SpriteBatch batch;
	private ShapeRenderer shape;
	
	public void EntityManager() {
	}

	public void addEntity() {
		batch = new SpriteBatch();		
		
		entityList.add(new TexturedObject("bucket.png", 300, 400, 200,false));
		entityList.add(new TexturedObject("badlogic.jpg", 300, 0, 100,true));

		
		
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
            int xPos = random.nextInt(600);
            int yPos = random.nextInt(300);
            entityList.add(new TexturedObject("droplet.png", xPos,yPos,0,false));
            
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
	

}
