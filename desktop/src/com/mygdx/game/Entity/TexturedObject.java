package com.mygdx.game.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * TexturedObject extends the Entity class, representing an entity with a texture.
 * It can be controlled by the user or AI and has properties like texture, size, and movement behavior.
 */
public class TexturedObject extends Entity {
    
    private Texture tex; // The texture of the object.
    private boolean isAIControlled; // Flag to determine if the object is controlled by AI.
    private float width; // Width of the object.
    private float height; // Height of the object.
    private PlayerControlManager controlManager; // The control manager for user-controlled movement.

    // Default constructor
    public TexturedObject() {
    }

    /**
     * Constructor - Initializes a textured object with specified texture, position, dimensions, speed, and control type.
     *
     * @param path The file path of the texture.
     * @param x The x-coordinate of the object's initial position.
     * @param y The y-coordinate of the object's initial position.
     * @param width The width of the object.
     * @param height The height of the object.
     * @param speed The speed of the object.
     * @param isAIControlled True if the object is controlled by AI, false otherwise.
     */
    public TexturedObject(String path, float x, float y, float width, float height, float speed, boolean isAIControlled) {
        super(Color.RED, x, y, speed); // Calls the constructor of the Entity class.
        this.tex = new Texture(Gdx.files.internal(path)); // Sets the texture from the provided file path.
        this.width = width; // Sets the width of the object.
        this.height = height; // Sets the height of the object.
        this.isAIControlled = isAIControlled; // Sets the control type of the object.
        this.controlManager = new PlayerControlManager(this); // Sets the control manager for user-controlled movement.
    }

    // Getter for the texture.
    public Texture getTexture() {
        return tex;
    }

    // Setter for the texture.
    void setTexture(Texture t) {
        tex = t;
    }

    // Update method to be implemented for specific behaviors.
    public void update() {
    }

    // Method for AI-controlled movement, to be implemented in subclasses.
    @Override
    public void moveAIControlled() {
    }

    // Method for user-controlled movement.
    @Override
    public void moveUserControlled() {
        controlManager.handleInput(); // Handles player input.
    }

    /**
     * Draws the object using the provided SpriteBatch.
     * 
     * @param batch The SpriteBatch used for drawing.
     */
    @Override
    public void draw(SpriteBatch batch) {
        batch.begin();
        batch.draw(this.tex, this.getX(), this.getY(), this.width, this.height);
        batch.end();
    }

    /**
     * Handles the movement logic, determining whether to use AI or user-controlled movement.
     */
    public void movement() {
        if (isAIControlled) {
            moveAIControlled();
        } else {
            // Movement logic for user-controlled movement using keyboard inputs.
            moveUserControlled();


        //    if (Gdx.input.isKeyPressed(Keys.LEFT)) this.setX(this.getX() - this.getSpeed() * Gdx.graphics.getDeltaTime());
        //    if (Gdx.input.isKeyPressed(Keys.RIGHT)) this.setX(this.getX() + this.getSpeed() * Gdx.graphics.getDeltaTime());
        //    if (Gdx.input.isKeyPressed(Keys.DOWN)) this.setY(this.getY() - this.getSpeed() * Gdx.graphics.getDeltaTime());
        //    if (Gdx.input.isKeyPressed(Keys.UP)) this.setY(this.getY() + this.getSpeed() * Gdx.graphics.getDeltaTime());
        }
    }

    // Getter for the width of the object.
    @Override
    public float getWidth() {
        return this.width;
    }

    // Getter for the height of the object.
    @Override
    public float getHeight() {
        return this.height;
    }
}
