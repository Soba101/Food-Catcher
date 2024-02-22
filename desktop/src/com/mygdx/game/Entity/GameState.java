package com.mygdx.game.Entity; // Adjust the package as needed

public enum GameState {
    CONTINUE, // Game continues, no win/loss condition met
    WIN,      // Player wins the game
    LOSE_TIME, // Player loses due to time running out
    LOSE_MOUSE // Player loses due to collision with the mouse
}
