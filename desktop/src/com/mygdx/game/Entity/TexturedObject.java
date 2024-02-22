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
	private float width;
    private float height;

	
	//default constructor
	public TexturedObject() {
		
	}
	
	public TexturedObject(String path, float x, float y, float width, float height, float speed, boolean isAIControlled) {
	    super(Color.RED, x, y, speed);
	    this.tex = new Texture(Gdx.files.internal(path));
	    this.width = width; // Set the width
	    this.height = height; // Set the height
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
    
    @Override
    public void draw(SpriteBatch batch) {
        batch.begin();
        batch.draw(this.tex, this.getX(), this.getY(), this.width, this.height);
        batch.end();
    }
    
    public void movement() {
    	
    	if(isAIControlled) {
    		
    		moveAIControlled();
    	
    	}else {
    		if(Gdx.input.isKeyPressed(Keys.LEFT)) this.setX(this.getX()-this.getSpeed()*Gdx.graphics.getDeltaTime());
    		if(Gdx.input.isKeyPressed(Keys.RIGHT)) this.setX(this.getX()+this.getSpeed()*Gdx.graphics.getDeltaTime());
    		if(Gdx.input.isKeyPressed(Keys.DOWN)) this.setY(this.getY()-this.getSpeed()*Gdx.graphics.getDeltaTime());
    		if(Gdx.input.isKeyPressed(Keys.UP)) this.setY(this.getY()+this.getSpeed()*Gdx.graphics.getDeltaTime());
    	}
    }
    
    @Override
    public float getWidth() {
        return this.width;
    }

	@Override
	public float getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}
    
}

