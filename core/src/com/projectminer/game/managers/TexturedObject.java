package com.mygdx.game.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


public class TexturedObject extends Entity{
	
	private Texture tex;
	private boolean isAIControlled;

	
	//default constructor
	public TexturedObject() {
		
	}
	
	public TexturedObject(String path, float x,float y, float speed, boolean isAIControlled) {
		super(Color.RED,x,y,speed);
		this.tex = new Texture(Gdx.files.internal(path));
		this.isAIControlled = isAIControlled;
	}

	public Texture getTexture() {
		return tex;
	}
	
	void setTexture(Texture t) {
		tex=t;
	}
	
	public void update() {
	}
    
    @Override
    public void moveAIControlled() {
    	
    }
    
    @Override
    public void moveUserControlled() {
    	
    }
    
    public void draw(SpriteBatch batch) {
		batch.begin();
        batch.draw(this.tex, this.getX(), this.getY());
        batch.end();
    }
    
    public void movement() {
    	
    	if(isAIControlled) {
    	
    	}else {
    		if(Gdx.input.isKeyPressed(Keys.LEFT)) this.setX(this.getX()-this.getSpeed()*Gdx.graphics.getDeltaTime());
    		if(Gdx.input.isKeyPressed(Keys.RIGHT)) this.setX(this.getX()+this.getSpeed()*Gdx.graphics.getDeltaTime());
    	}
    }
    
}

