package com.mygdx.game.Entity;

import java.util.Random;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

// Class for handling collectible items in the game.
public class Collectibles extends Entity {
    
    // Points associated with the collectible item.
    private float points;
    
    // A Random object for generating random values.
    private static Random random = new Random ();
    
    // An array defining various food items and their associated points.
    private static FoodLibraryInfo[] foodLibraryInfoArray = {
        new FoodLibraryInfo("food/carrot.png", 10),
        new FoodLibraryInfo("food/lettuce.png", 20),
        new FoodLibraryInfo("food/fish.png", 30),
        new FoodLibraryInfo("food/meat.png", 40),
        new FoodLibraryInfo("food/egg.png", 30),

        
        new FoodLibraryInfo("food/frenchfries.png", -20),
        new FoodLibraryInfo("food/burger.png", -40),
        new FoodLibraryInfo("food/cheese.png", -10),
        new FoodLibraryInfo("food/drumstick.png", -30),
        new FoodLibraryInfo("food/icecream.png", -50)


    };
    
    // Default constructor.
    public Collectibles() {
        // This constructor is empty but can be used for default initialization.
    }
    
    // Overloaded constructor for creating a Collectible with specific attributes.
    public Collectibles(String texture, float x, float y, float speed, float height, float width, float points) {
        super(texture, x, y, speed, height, width); // Call to the parent (Entity) class constructor.
        this.points = points; // Setting the points for the collectible.
    }
    
    // Setter method for points.
    public void setPoints(float points) {
        this.points = points;
    }
    
    // Getter method for points.
    public float getPoints() {
        return points;
    }

    // Overridden draw method for rendering the collectible.
    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(getTexture(), getX(), getY(), getTexture().getWidth(), getTexture().getHeight());
    }

    // Overridden update method - currently empty.
    @Override
    public void update() {
        // Logic for updating the collectible's state should be implemented here.
    }
    
    // Static method to get a random FoodLibraryInfo object from the array.
    public static FoodLibraryInfo getFoodLibraryInfo() {
        int randomIndex = random.nextInt(foodLibraryInfoArray.length);
        return foodLibraryInfoArray[randomIndex];
    }
    
    // Overridden dispose method to handle resource cleanup.
    @Override
    public void dispose() {
        super.dispose(); // Call to the dispose method of the superclass (Entity).
        // Additional dispose logic specific to Collectibles can be added here.
    }
}
