//base class for all entities
package com.projectminer.game.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * The base class for all entities in the game. It holds common properties like position,
 * size, and velocity, and defines common methods that can be overridden by subclasses.
 */
public abstract class Entity {
    // Position of the entity
    protected Vector2 position;

    // Size of the entity (could be width and height if non-square)
    protected Vector2 size;

    // Velocity of the entity for movement
    protected Vector2 velocity;

    // The current state of the entity (alive, dead, active, inactive, etc.)
    protected EntityState state;

    // Constructor
    public Entity(float x, float y, float width, float height) {
        this.position = new Vector2(x, y);
        this.size = new Vector2(width, height);
        this.velocity = new Vector2(0, 0);
        this.state = EntityState.ACTIVE; // Assume all entities start as active
    }

    // Update method to be called every frame
    public abstract void update(float deltaTime);

    // Render method to draw the entity
    public abstract void render(SpriteBatch batch);

    // Dispose method for cleaning up resources
    public abstract void dispose();

    // Other common methods like getters and setters can be added here
    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getSize() {
        return size;
    }

    public void setSize(Vector2 size) {
        this.size = size;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public EntityState getState() {
        return state;
    }

    public void setState(EntityState state) {
        this.state = state;
    }

    // Enum for entity states
    public enum EntityState {
        ACTIVE,
        INACTIVE,
        DESTROYED
    }
}
