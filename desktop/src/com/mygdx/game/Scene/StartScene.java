package com.mygdx.game.Scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class StartScene extends Scene{
	
	private SceneManager sceneManager;
	private Texture backgroundTexture;
	private Stage stage;

	public StartScene(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
		backgroundTexture = new Texture(Gdx.files.internal("startscreen.png"));
        //create();
    }

	@Override
	public void create() {
        stage = new Stage(new ScreenViewport());
		backgroundTexture = new Texture(Gdx.files.internal("startscreen.png"));
        
		Image backgroundImage = new Image(backgroundTexture);
        backgroundImage.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
       
     // Add background image to stage
        stage.addActor(backgroundImage);

        // Set input processor to stage to handle input events for actors
        Gdx.input.setInputProcessor(stage);

        // Add a listener to the stage for touch events
        stage.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Transition to the GameScene
                System.out.println("Screen Clicked");
                sceneManager.setScene(new GameScene(sceneManager));
            }
        });
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear the screen
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw(); // Draw the stage and its actors
	}

	@Override
	public void dispose() {
		backgroundTexture.dispose(); // Dispose the background texture when no longer needed
	}

}
