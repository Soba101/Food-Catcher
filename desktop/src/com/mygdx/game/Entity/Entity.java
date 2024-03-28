package com.mygdx.game.Entity;

import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

// Abstract class defining a basic game entity.
public abstract class Entity implements Disposable {
    
    // Texture for the entity.
    protected Texture texture;
    // X and Y coordinates of the entity.
    protected float x;
    protected float y;
    // Speed of the entity.
    protected float speed;
    // Height and width of the entity.
    protected float height;
    protected float width;

    // Default constructor.
    public Entity() {
        // Empty constructor for default initialization.
    }
    
    // Overloaded constructor to initialize an entity with specific attributes.
    public Entity(String texture, float x, float y, float speed, float height, float width) {
        this.texture = new Texture(Gdx.files.internal(texture)); // Load the texture.
        this.x = x; // Set the initial X position.
        this.y = y; // Set the initial Y position.
        this.speed = speed; // Set the speed.
        this.height = height; // Set the height.
        this.width = width; // Set the width.
    }

    // Setters and getters for texture, x, y, speed, height, and width.
    // These methods allow for modifying and accessing the entity's properties.
	public void setTexture(Texture texture) {
    	this.texture = texture;
    }
	
	public Texture getTexture() {
    	return texture; 
    }
	
	public void setX(float x) {
    	this.x = x;
    }
	
	public float getX() {
    	return x; 
    }
	
	public void setY(float y) {
    	this.y = y;
    }
	
	public float getY() {
    	return y;
    }
	
	public void setSpeed(float speed) {
    	this.speed = speed;
    }
	
	public float getSpeed() {
    	return speed;
    }
	
	public void setHeight(float height) {
    	this.height = height;
    }
	
	public float getHeight() {
    	return height;
    }
	
	public void setWidth(float width) {
    	this.width = width;

    }
	
	public float getWidth() {
    	return width;
    }
	
	// Returns a Rectangle that represents the entity's bounding box.
    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
    
    // Abstract method to draw the entity. Must be implemented in subclasses.
    public abstract void draw(SpriteBatch batch);
    
    // Abstract method to update the entity. Must be implemented in subclasses.
    public abstract void update();

    // Dispose method to clean up resources. Implements Disposable interface.
    public void dispose() {
        if (texture != null) {
            texture.dispose(); // Dispose of the texture if it's not null.
        }
    }

}
