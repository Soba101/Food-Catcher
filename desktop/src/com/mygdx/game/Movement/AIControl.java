package com.mygdx.game.Movement;

import com.mygdx.game.Entity.Entity;

// Class for controlling the movement of AI entities.
public class AIControl {
    
    // Method to handle the movement of an AI entity.
    public void movement(Entity food) {
        // Move the entity vertically upwards based on its speed.
        // Assuming higher Y values correspond to lower positions on the screen.
        food.setY(food.getY() - food.getSpeed());
    }
}
