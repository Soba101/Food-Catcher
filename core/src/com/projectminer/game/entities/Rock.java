//class for rock
package com.projectminer.game.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;

public class Rock extends Entity {
    private Texture texture;
    private float weight; // Weight of the rock which may affect gameplay

    public Rock(float x, float y, float width, float height, float weight) {
        super(x, y, width, height);
        this.texture = new Texture("rock.png"); // Assuming you have a rock texture
        this.weight = weight;
    }

    @Override
    public void update(float deltaTime) {
        // Specific update logic for the Rock
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y, width, height);
    }

    public float getWeight() {
        return weight;
    }

    public void dispose() {
        texture.dispose();
    }
}
