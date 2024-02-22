package com.mygdx.game.Entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * The Entity class represents a generic entity in the game.
 * It provides common properties and methods that can be inherited by specific entity types.
 * This class is abstract, meaning specific entities in the game will extend this class.
 * It implements iMovable, indicating it has movement capabilities.
 */
public abstract class Entity implements iMovable {
    private String tag = ""; // A tag for identifying the entity, default is an empty string.
    private float x;         // The x-coordinate of the entity's position.
    private float y;         // The y-coordinate of the entity's position.
    private float speed;     // The speed at which the entity moves.
    private Color color;     // The color of the entity.

    // Abstract methods getWidth and getHeight must be implemented in subclasses.
    public abstract float getWidth();
    public abstract float getHeight();

    // Default constructor - Creates an entity with default values.
    public Entity() {
    }

    /**
     * Constructor - Initializes an entity with specified color, position, and speed.
     * @param color The color of the entity.
     * @param x The initial x-coordinate of the entity.
     * @param y The initial y-coordinate of the entity.
     * @param speed The speed of the entity.
     */
    public Entity(Color color, float x, float y, float speed) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    // Getters and setters for x, y, speed, and color properties.
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

    /**
     * Placeholder method for entity movement.
     * This method should be overridden in subclasses to define specific movement behavior.
     */
    public void movement() {
    }

    /**
     * Placeholder method for drawing the entity.
     * This method should be overridden in subclasses to define how the entity is drawn.
     * @param batch The SpriteBatch that is used for drawing.
     */
    public void draw(SpriteBatch batch) {
    }

    // Abstract method update - must be implemented in subclasses to define entity's update logic.
    public abstract void update();

    /**
     * Sets the tag of the entity.
     * @param tag A string representing the tag for the entity.
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * Checks if the entity has a specific tag.
     * @param tag The tag to check against the entity's tag.
     * @return true if the entity has the specified tag, false otherwise.
     */
    public boolean hasTag(String tag) {
        return this.tag.equals(tag);
    }
}
