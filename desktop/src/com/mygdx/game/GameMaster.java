package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Managers.IOManager;
import com.mygdx.game.Managers.SimulationManager;
import com.mygdx.game.States.MenuState;

public class GameMaster extends ApplicationAdapter{
	

	private SimulationManager sm;
	private SpriteBatch batch; 

	
	@Override
	public void create() 
	{	
		batch = new SpriteBatch();
		sm = new SimulationManager();
		ScreenUtils.clear(1, 0, 0, 1);
		sm.push(new MenuState(sm));
		
		IOManager.getInstance().playBackgroundMusic();
		
	}
	
	
	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sm.update(Gdx.graphics.getDeltaTime());
		sm.render(batch);
	}
	
	@Override
	public void dispose () { batch.dispose(); }
}
