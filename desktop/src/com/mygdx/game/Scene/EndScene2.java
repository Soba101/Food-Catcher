package com.mygdx.game.Scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class EndScene2 extends Scene {
    
    private Texture backgroundTexture;
    private Stage stage;

    public EndScene2(SceneManager sceneManager) {
        create();
    }

    @Override
    public void create() {
        stage = new Stage(new ScreenViewport());
        backgroundTexture = new Texture(Gdx.files.internal("winscreen.png"));
        
        Image backgroundImage = new Image(backgroundTexture);
        stage.addActor(backgroundImage);

        backgroundImage.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear the screen
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw(); // Draw the stage and its actors
    }

    @Override
    public void dispose() {
        backgroundTexture.dispose(); // Dispose of the background texture
    }
}
