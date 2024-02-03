//Class for gold nugget
package com.projectminer.game.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;

public class GoldNugget extends Entity {
    private Texture texture;
    private int value; // Value of the gold nugget

    public GoldNugget(float x, float y, float width, float height, int value) {
        super(x, y, width, height);
        this.texture = new Texture("gold_nugget.png"); // Assuming you have a gold nugget texture
        this.value = value;
    }

    @Override
    public void update(float deltaTime) {
        // Specific update logic for the GoldNugget
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y, width, height);
    }

    public int getValue() {
        return value;
    }

    public void dispose() {
        texture.dispose();
    }
}
