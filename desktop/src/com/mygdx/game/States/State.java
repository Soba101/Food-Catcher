package com.mygdx.game.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Managers.SimulationManager;

public abstract class State 
{
	protected SimulationManager sm;

	
	protected State(SimulationManager sm)
	{
		this.sm = sm;
	}
	
	public abstract void update();
	public abstract void render(SpriteBatch sb);
	public abstract void dispose();
}