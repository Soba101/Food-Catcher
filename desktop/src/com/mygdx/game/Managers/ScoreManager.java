package com.mygdx.game.Managers;

// Class for managing the game's score.
public class ScoreManager {
    private static float score = 0; // Static variable to hold the current score.

    // Static method to add points to the score.
    public static void addPoints(float points) {
        score += points; // Increment the score by the given points.
    }

    // Static method to get the current score.
    public static float getScore() {
        return score; // Return the current score.
    }

    // Static method to reset the score to 0.
    public static void resetScore() {
        score = 0; // Reset the score to 0.
    }
}
