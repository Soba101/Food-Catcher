package com.mygdx.game.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class PlayerControlManager {
    private Entity playerEntity;

    public PlayerControlManager(Entity playerEntity) {
        this.playerEntity = playerEntity;
    }

    public void handleInput() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        float speed = playerEntity.getSpeed();

        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            playerEntity.setX(playerEntity.getX() - speed * deltaTime);
        }
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            playerEntity.setX(playerEntity.getX() + speed * deltaTime);
        }
        if (Gdx.input.isKeyPressed(Keys.DOWN)) {
            playerEntity.setY(playerEntity.getY() - speed * deltaTime);
        }
        if (Gdx.input.isKeyPressed(Keys.UP)) {
            playerEntity.setY(playerEntity.getY() + speed * deltaTime);
        }
    }
}
