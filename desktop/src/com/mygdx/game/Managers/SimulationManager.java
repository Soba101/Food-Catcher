package com.mygdx.game.Managers;

import java.util.Stack;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.States.State;

// Class for managing game states.
public class SimulationManager {
    private Stack<State> states; // Stack to maintain the game states.

    // Constructor for SimulationManager.
    public SimulationManager() {
        states = new Stack<State>(); // Initialize the stack of states.
    }

    // Method to push a new state onto the stack.
    public void push(State state) {
        states.push(state); // Push the given state onto the stack.
    }

    // Method to pop the current state from the stack and dispose it.
    public void pop() {
        states.pop().dispose(); // Pop the top state from the stack and dispose it.
    }

    // Method to set a new state, replacing the current state if it exists.
    public void set(State state) {
        if (!states.isEmpty()) {
            states.pop().dispose(); // Dispose the current state if it exists.
        }
        states.push(state); // Push the new state onto the stack.
    }

    // Method to update the current state.
    public void update(float dt) {
        states.peek().update(); // Update the top state on the stack.
    }

    // Method to render the current state.
    public void render(SpriteBatch sb) {
        states.peek().render(sb); // Render the top state on the stack.
    }
}
