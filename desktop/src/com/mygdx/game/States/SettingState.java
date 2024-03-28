package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Managers.IOManager;
import com.mygdx.game.Managers.SimulationManager;

public class SettingState extends State {
	 private Texture background;
	    private Texture toggleOnTexture;
	    private Texture toggleOffTexture;
	    private Rectangle toggleBounds;
	    private boolean isMusicOn;

	    private BitmapFont backButtonFont;
	    private String backButtonText = "Back";
	    private float backButtonWidth;
	    private float backButtonHeight;
	    private float backButtonX;
	    private float backButtonY;

    public SettingState(SimulationManager sm) {
        super(sm);
        background = new Texture("backgrounds/settings.png");
        toggleOnTexture = new Texture("entity/toggle-on.png");
        toggleOffTexture = new Texture("entity/toggle-off.png");

        isMusicOn = IOManager.getInstance().isMusicPlaying(); // Assume IOManager has this method

        float toggleX = (Gdx.graphics.getWidth() - toggleOnTexture.getWidth()) / 2;
        float toggleY = (Gdx.graphics.getHeight() - toggleOnTexture.getHeight()) / 2;
        toggleBounds = new Rectangle(toggleX, toggleY, toggleOnTexture.getWidth(), toggleOffTexture.getHeight());

        backButtonFont = new BitmapFont();
        GlyphLayout layout = new GlyphLayout();
        layout.setText(backButtonFont, backButtonText);
        backButtonWidth = layout.width;
        backButtonHeight = layout.height;
        backButtonX = (Gdx.graphics.getWidth() - backButtonWidth) / 2;
        backButtonY = 100 + backButtonHeight; // Adjust the Y position as needed
    }
    

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0);
        Texture activeToggle = isMusicOn ? toggleOnTexture : toggleOffTexture;
        sb.draw(activeToggle, toggleBounds.x, toggleBounds.y);

        backButtonFont.draw(sb, backButtonText, backButtonX, backButtonY);
        sb.end();
    }

    private void handleInput() {
        if (Gdx.input.justTouched()) {
            Vector3 touchPoint = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            touchPoint.y = Gdx.graphics.getHeight() - touchPoint.y; // Flip y-coordinate

            if (toggleBounds.contains(touchPoint.x, touchPoint.y)) {
                isMusicOn = !isMusicOn;
                if (isMusicOn) {
                    IOManager.getInstance().playBackgroundMusic();
                } else {
                    IOManager.getInstance().stopBackgroundMusic();
                }
            }

            Rectangle backButtonBounds = new Rectangle(backButtonX, backButtonY - backButtonHeight,
                    backButtonWidth, backButtonHeight);
            if (backButtonBounds.contains(touchPoint.x, touchPoint.y)) {
                sm.set(new MenuState(sm));
            }
        }
    }

    @Override
    public void update() {
        handleInput();
    }

    @Override
    public void dispose() {
        background.dispose();
        toggleOnTexture.dispose();
        toggleOffTexture.dispose();
        backButtonFont.dispose();
        System.out.println("Setting State Disposed.");
    }
}
