package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.Managers.SimulationManager;

// State for displaying instructions to the player.
public class InstructState extends State {
    private Texture background;
    private BitmapFont headerFont;
    private BitmapFont instructionFont;
    private Stage stage;
    private TextButton playButton;
    private TextButton backButton;

    private String headerText = "How to Play?";
    private String[] instructions = {
            "1. Use arrow keys to move.",
            "2. Collect healthy food to score points.",
            "3. Avoid unhealthy food to stay alive.",
            "4. Reach the end to win."
    };

    // Constructor for InstructState.
    public InstructState(SimulationManager sm) {
        super(sm);
        background = new Texture("backgrounds/instruct.png");
        headerFont = new BitmapFont();
        instructionFont = new BitmapFont();
        stage = new Stage();
        Gdx.input.setInputProcessor(stage); // Set the input processor to the stage.

        // Set up fonts and text styles.
        headerFont.setColor(Color.WHITE);
        headerFont.getData().setScale(2);
        instructionFont.setColor(Color.YELLOW);
        instructionFont.getData().setScale(1.5f);

        // Set up button styles.
        TextButtonStyle textButtonStyle = new TextButtonStyle();
        textButtonStyle.font = instructionFont;
        textButtonStyle.fontColor = Color.WHITE;

        // Create play button.
        playButton = new TextButton("Play", textButtonStyle);
        playButton.setPosition(Gdx.graphics.getWidth() / 2 - 100, 200);
        playButton.setSize(200, 50);
        playButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                sm.set(new PlayState(sm, 1)); // Switch to PlayState when play button is clicked.
            }
        });

        // Create back button.
        backButton = new TextButton("Back", textButtonStyle);
        backButton.setPosition(Gdx.graphics.getWidth() / 2 - 100, 100);
        backButton.setSize(200, 50);
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                sm.set(new MenuState(sm)); // Switch to MenuState when back button is clicked.
            }
        });

        // Add buttons to the stage.
        stage.addActor(playButton);
        stage.addActor(backButton);
    }

    // Render method to draw instructions and buttons.
    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        // Draw header text.
        GlyphLayout headerLayout = new GlyphLayout(headerFont, headerText);
        headerFont.draw(sb, headerLayout, (Gdx.graphics.getWidth() - headerLayout.width) / 2, Gdx.graphics.getHeight() - 100);

        // Draw instructions.
        float instructY = Gdx.graphics.getHeight() - 150;
        for (String line : instructions) {
            GlyphLayout instructionLayout = new GlyphLayout(instructionFont, line);
            instructionFont.draw(sb, instructionLayout, (Gdx.graphics.getWidth() - instructionLayout.width) / 2, instructY);
            instructY -= instructionLayout.height + 20;
        }

        sb.end();

        // Update and draw the stage.
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    // Update method.
    @Override
    public void update() {
        // Handle any inputs that aren't related to UI here if necessary.
        // UI inputs are handled by the stage.
    }

    // Dispose method to clean up resources.
    @Override
    public void dispose() {
        background.dispose();
        headerFont.dispose();
        instructionFont.dispose();
        stage.dispose();
        System.out.println("Instruction State Disposed.");
    }
}
