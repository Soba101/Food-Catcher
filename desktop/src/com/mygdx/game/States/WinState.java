package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Managers.ScoreManager;
import com.mygdx.game.Managers.SimulationManager;

public class WinState extends State {
    private Texture background;
    private Stage stage;
    private BitmapFont font;
    private Label passLabel;
    private Label scoreLabel;
    private Texture winImage; // Texture for the image at the bottom
    
    public WinState(SimulationManager sm, int levelNumber) {
        super(sm);
        background = new Texture("backgrounds/win.png");
        winImage = new Texture("entity/happyboy.png"); // Load the image

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        font = new BitmapFont();

        LabelStyle labelStyle = new LabelStyle();
        labelStyle.font = font;
        labelStyle.fontColor = Color.WHITE;

        passLabel = new Label("YOU HAVE COMPLETED THE GAME, CONGRATULATIONS!", labelStyle);
        passLabel.setFontScale(2.0f);
        passLabel.setSize(Gdx.graphics.getWidth(), 100);
        passLabel.setPosition(0, Gdx.graphics.getHeight() / 2 + 100);
        passLabel.setAlignment(Align.center);
        stage.addActor(passLabel);
        
        // Create and position the score label
        scoreLabel = new Label("Score: " + ScoreManager.getScore(), labelStyle);
        scoreLabel.setFontScale(1.5f); // Adjust the font scale as needed
        scoreLabel.setSize(Gdx.graphics.getWidth(), 100);
        scoreLabel.setPosition(0, Gdx.graphics.getHeight() / 2 + 50);
        scoreLabel.setAlignment(Align.center);
        stage.addActor(scoreLabel);

        TextButtonStyle textButtonStyle = new TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.fontColor = Color.WHITE;

        // Play Again button
        TextButton continueButton = new TextButton("Play Again", textButtonStyle);
        continueButton.setPosition(Gdx.graphics.getWidth() / 2 - 150, Gdx.graphics.getHeight() / 2 - 50);
        continueButton.setSize(300, 60);
        continueButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
            	System.out.println("Player choose play again, transitioning to PlayState");
                sm.set(new PlayState(sm, 1)); // Start the new level
            }
        });
        stage.addActor(continueButton);

        TextButton quitButton = new TextButton("Quit", textButtonStyle);
        quitButton.setPosition(Gdx.graphics.getWidth() / 2 - 150, Gdx.graphics.getHeight() / 2 - 120);
        quitButton.setSize(300, 60);
        quitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });
        stage.addActor(quitButton);
    }

    @Override
    public void render(SpriteBatch sb) {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        sb.begin();
        sb.draw(background, 0, 0); // Draw the background

        // Draw the bottom image at the bottom of the screen
        sb.draw(winImage, 300, 140); // The position (0, 0) is the bottom-left corner

        sb.end();

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void dispose() {
        background.dispose();
        winImage.dispose(); // Dispose of the bottom image texture
        stage.dispose();
        font.dispose();
        System.out.println("Win State Disposed.");
    }

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
