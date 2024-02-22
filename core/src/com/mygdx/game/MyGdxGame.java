package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/**
 * The main class of the game.
 * This class extends ApplicationAdapter and handles the creation, rendering, and disposal of game assets.
 */
public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	/**
	 * Called when the application is first created.
	 * Initializes the SpriteBatch and loads the image "badlogic.jpg".
	 */
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	/**
	 * Renders the game screen.
	 */
	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	/**
	 * Disposes of any resources used by the game.
	 */
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
