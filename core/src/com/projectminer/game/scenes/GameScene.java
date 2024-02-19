//Class for the main game scene

package com.mygdx.game.Scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.Entity.EntityManager;

public class GameScene extends Scene{
	
	private SceneManager sceneManager;
	private EntityManager entityManager;
	//private SpriteBatch batch;
    private Texture backgroundTexture;
    private Stage stage; // Use Stage for UI components
    private Label timerLabel;
    private float timer;



	public GameScene(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
        create();
    }

	@Override
	public void create() {
		//batch = new SpriteBatch();
		
		entityManager = new EntityManager();
		entityManager.addEntity();		
		
		// Initialize the stage with a viewport
        stage = new Stage(new ScreenViewport());

        // Load the background texture and create an Image actor
        backgroundTexture = new Texture(Gdx.files.internal("gamescreen.png"));
        Image backgroundImage = new Image(backgroundTexture);

        // Add the background image actor to the stage
        stage.addActor(backgroundImage);

        // Optional: set the size of the background image to fill the screen
        backgroundImage.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        
        timer = 10.0f; // For example, start with a 30 seconds timer

        // Initialize the label to display the timer
        LabelStyle labelStyle = new LabelStyle(new BitmapFont(), com.badlogic.gdx.graphics.Color.WHITE);
        timerLabel = new Label(String.format("%.2f", timer), labelStyle);

        // Position the label in the top right corner
        timerLabel.setPosition(Gdx.graphics.getWidth() - timerLabel.getWidth() - 20, Gdx.graphics.getHeight() - timerLabel.getHeight() - 20);
        stage.addActor(timerLabel);
	}

	@Override
	public void render() {
    	ScreenUtils.clear(1, 0, 0, 0);
    	
    	// Update the timer
        if (timer > 0) {
            timer -= Gdx.graphics.getDeltaTime();
            timerLabel.setText(String.format("%.2f", timer));
        } else {
            // Go to EndScene
            sceneManager.setScene(new EndScene(sceneManager));
        }
    	
    	// Update and draw the stage
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
        
    	entityManager.update();
		entityManager.draw();
		entityManager.movement();
		
	}

	@Override
	public void dispose() {
		//batch.dispose();
		stage.dispose();
        backgroundTexture.dispose();
		
	}
	
	
	
}
