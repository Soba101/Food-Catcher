package com.mygdx.game.States;
import com.badlogic.gdx.Gdx;
// import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
// import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.mygdx.game.Managers.SimulationManager;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

public class MenuState extends State {
    private Texture background;
    private Rectangle doorBounds;
    private Rectangle settingBounds;
//     private ShapeRenderer shapeRenderer; // for border drawing
    private Stage stage; // Declare the stage variable here

    public MenuState(SimulationManager sm) {
        super(sm); // Pass the SpriteBatch to the superclass
        background = new Texture("backgrounds/menu.png");
        // Initialize the bounds of the door. Adjust the values to match your door's position and size.
        doorBounds = new Rectangle(955, 200, 50, 100);
        settingBounds = new Rectangle(580, 255, 100, 75);
  //       shapeRenderer = new ShapeRenderer();
        stage = new Stage(); // Make sure stage is initialized here
    }
    
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            // Get the touch coordinates
            Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            touchPos = new Vector3(touchPos.x, Gdx.graphics.getHeight() - touchPos.y, 0); // Flip the y-coordinate

            // Check if the touch is within the door bounds
            if (doorBounds.contains(touchPos.x, touchPos.y)) {
                sm.set(new InstructState(sm)); // Go to PlayState
            } else if (settingBounds.contains(touchPos.x, touchPos.y)) {
                sm.set(new SettingState(sm)); // Go to SettingState
            }
        }
    }

    @Override
    public void update() { handleInput(); }
    
    @Override
    public void render(SpriteBatch sb) {
         ScreenUtils.clear(0, 0, 0.2f, 1);
         sb.begin();
         sb.draw(background, 0, 0);
         sb.end();
//         // Render the red border around the door bounds using ShapeRenderer
//         shapeRenderer.begin(ShapeType.Line);
//         shapeRenderer.setColor(Color.RED); // Set the color to red
//         shapeRenderer.rect(doorBounds.x, doorBounds.y, doorBounds.width, doorBounds.height);
//         shapeRenderer.rect(settingBounds.x, settingBounds.y, settingBounds.width, settingBounds.height);
//         shapeRenderer.end();
//
//         // After the ShapeRenderer, draw the stage which contains UI elements
//         stage.act(Gdx.graphics.getDeltaTime());
//         stage.draw();
    }
    
    @Override
    public void dispose() {
        background.dispose();
        stage.dispose();
         //shapeRenderer.dispose(); // Dispose of the shape renderer
        System.out.println("Menu State Disposed.");
    }
}
