package com.mygdx.game.Scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.Entity.AIControlManager;
import com.mygdx.game.Entity.Entity;
import com.mygdx.game.Entity.EntityManager;
import com.mygdx.game.Entity.CollisionManager;
import com.mygdx.game.Entity.GameState;

/**
 * GameScene is the central class for managing the main gameplay interface and interactions.
 * It extends the Scene base class, providing specific functionality for the main game screen.
 * This class manages game entities, AI behavior, collision detection, UI elements, and scene transitions.
 */
public class GameScene extends Scene {
    
    private SceneManager sceneManager; // Manages transitions between different scenes in the game.
    private EntityManager entityManager; // Manages all entities in the game scene.
    private AIControlManager aiControlManager; // Controls AI behavior for certain entities.
    private Texture backgroundTexture; // Texture for the game's background.
    private Stage stage; // Stage for managing UI elements within the game scene.
    private Label timerLabel; // UI label to display the remaining game time.
    private float timer = 30.0f; // Countdown timer for the game, starting from 30 seconds.
    private CollisionManager collisionManager; // Manages collision detection between entities.

    /**
     * Constructor for GameScene.
     * @param sceneManager SceneManager to control scene transitions.
     */
    public GameScene(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
        create(); // Initialize scene components.
    }

    /**
     * Initializes components of the game scene.
     * This includes setting up the stage, entities, AI control, collision management, and UI elements.
     */
    @Override
    public void create() {
        // Entity and AI control setup
        entityManager = new EntityManager(); // Manages all game entities.
        aiControlManager = new AIControlManager(); // Controls AI for entities.
        entityManager.addEntity(); // Adds entities to the EntityManager.
        collisionManager = new CollisionManager(entityManager); // Initializes CollisionManager for handling collisions.

        // Stage and UI setup
        stage = new Stage(new ScreenViewport()); // Stage for managing UI components.
        backgroundTexture = new Texture(Gdx.files.internal("gamescreen.png")); // Load background texture.
        Image backgroundImage = new Image(backgroundTexture); // Create an Image actor for the background.
        stage.addActor(backgroundImage); // Add background image to the stage.
        backgroundImage.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()); // Set background image size to fill screen.

        // Timer label setup
        LabelStyle labelStyle = new LabelStyle(new BitmapFont(), com.badlogic.gdx.graphics.Color.WHITE); // Style for the timer label.
        timerLabel = new Label(String.format("%.2f", timer), labelStyle); // Initialize timer label with initial timer value.
        timerLabel.setPosition(Gdx.graphics.getWidth() - timerLabel.getWidth() - 20, Gdx.graphics.getHeight() - timerLabel.getHeight() - 20); // Position timer label.
        stage.addActor(timerLabel); // Add timer label to the stage.

        // AI Control Manager setup with specific entities.
        Entity mouse = entityManager.getEntity("mouse");
        Entity bucket = entityManager.getEntity("bucket");
        aiControlManager = new AIControlManager(bucket, mouse); // Set up AI controls for the mouse and bucket entities.
    }

    /**
     * Renders the game scene in each frame.
     * Includes logic for updating the game timer, rendering UI elements, updating entity states, and checking game end conditions.
     */
    public void render() {
        ScreenUtils.clear(1, 0, 0, 0); // Clear the screen before rendering.

        // Timer update logic.
        if (timer > 0) {
            timer -= Gdx.graphics.getDeltaTime(); // Decrease timer based on elapsed time.
            timerLabel.setText(String.format("%.2f", timer)); // Update timer label text.
        }

        // Stage and entity update and rendering.
        stage.act(Gdx.graphics.getDeltaTime()); // Update stage actors.
        stage.draw(); // Render stage actors.

        // Update and render entities.
        aiControlManager.update(); // Update AI-controlled entities.
        entityManager.update(); // Update all entities.
        entityManager.draw(); // Draw all entities.
        entityManager.movement(); // Update entity movements.

        // Collision and game state checking.
        GameState gameState = collisionManager.checkCollisions(); // Check for collisions between entities.
        if (gameState == GameState.WIN) {
            sceneManager.setScene(new EndScene2(sceneManager)); // Transition to winning end scene.
        } else if (gameState == GameState.LOSE_MOUSE) {
            sceneManager.setScene(new EndScene(sceneManager)); // Transition to losing end scene.
        }

        // Check for game over condition due to timer expiration.
        if (timer <= 0) {
            sceneManager.setScene(new EndScene(sceneManager)); // Transition to losing end scene on timer expiration.
        }
    }

    /**
     * Disposes of resources to prevent memory leaks.
     * This includes textures, stage, and any other disposables used in the scene.
     */
    @Override
    public void dispose() {
        stage.dispose(); // Dispose of the stage and its actors.
        backgroundTexture.dispose(); // Dispose of the background texture.
    }
}
