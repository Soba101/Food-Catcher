package com.mygdx.game.Entity; // Package declaration

/**
 * Represents the possible states of the game.
 * This enum is used to keep track of the current state of the game,
 * indicating whether the game is ongoing, won, or lost under specific conditions.
 */
public enum GameState {
    CONTINUE, // Indicates that the game is ongoing and no win/loss condition has been met.
    WIN,      // Represents a state where the player wins the game.
    LOSE_TIME, // Indicates that the player loses the game due to time running out.
    LOSE_MOUSE // Signifies a loss due to collision with the mouse entity.
}
