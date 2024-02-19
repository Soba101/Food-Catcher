package com.mygdx.game.Entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class Entity implements iMovable{
	private float x;
	private float y;
	private float speed;
	private Color color;
	
	// Default Constructor
    public Entity() {
    	
    }
    
    public Entity(Color color, float x, float y, float speed) {
    	this.color=color;
    	this.x = x;
        this.y = y;
        this.speed = speed;
         // Default speed is 0
    }

	// Getters and Setters
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
    
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    

    public void movement() {
    	
	}
   
    public void draw(SpriteBatch batch) {
    	
    }
    
    public abstract void update();
    
}
