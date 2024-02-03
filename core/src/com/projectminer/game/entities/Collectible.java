//Class for other collectible items
package com.projectminer.game.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;

// This could be a superclass for any special collectibles beyond gold and rocks
public abstract class Collectible extends Entity {
    private Texture texture;

    public Collectible(float x, float y, float width, float height, String texturePath) {
        super(x, y, width, height);
        this.texture = new Texture(texturePath); // Dynamically set the texture path
    }

    @Override
    public void update(float deltaTime) {
        // Common update logic for collectibles
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y, width, height);
    }

    public void dispose() {
        texture.dispose();
    }
}
