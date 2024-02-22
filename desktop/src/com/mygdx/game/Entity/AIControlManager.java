package com.mygdx.game.Entity;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.List;

public class AIControlManager {
	
	private Entity target; // The entity to follow
    private Entity aiEntity; // List of AI-controlled entities

    public AIControlManager() {
    	
    }
    
    public AIControlManager(Entity target, Entity aiEntity) {
        this.target = target;
        this.aiEntity = aiEntity; // Ensure this list only contains AI-controlled entities
        //this.speed = speed;
    }

    public void update() {
    	float targetX = target.getX();
        float targetY = target.getY();
        
     // Calculate the direction vector from aiEntity to target
        float directionX = targetX - aiEntity.getX();
        float directionY = targetY - aiEntity.getY();

        // Normalize the direction vector
        float length = (float) Math.sqrt(directionX * directionX + directionY * directionY);
        if (length != 0) { // Prevent division by zero
            directionX /= length;
            directionY /= length;
        }

        // Update the AI entity's position to move towards the target
        aiEntity.setX(aiEntity.getX() + directionX * aiEntity.getSpeed()*Gdx.graphics.getDeltaTime());
        aiEntity.setY(aiEntity.getY() + directionY * aiEntity.getSpeed()*Gdx.graphics.getDeltaTime());
    }
    
}
