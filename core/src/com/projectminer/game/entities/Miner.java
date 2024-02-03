//class for player's miner
package com.projectminer.game.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Miner extends Entity {
    private Texture texture; // For rendering the miner

    public Miner(float x, float y, float width, float height) {
        super(x, y, width, height);
        this.texture = new Texture("miner.png"); // Assuming you have a miner texture
    }

    @Override
    public void update(float deltaTime) {
        // Update the miner's position and handle input, etc.
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y, width, height);
    }

    // Miner-specific methods
    public void swingCable() {
        // Logic for swinging the mining cable
    }

    public void collectItem(Entity item) {
        // Logic for collecting an item
    }

    // Clean up resources
    public void dispose() {
        texture.dispose();
    }
}
