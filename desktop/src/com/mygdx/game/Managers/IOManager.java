package com.mygdx.game.Managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.ObjectMap;

// Class for managing audio (music and sound effects) in the game.
public class IOManager {

    private static final IOManager instance = new IOManager(); // Singleton instance.
    private static final ObjectMap<String, Sound> sounds = new ObjectMap<>(); // Map for sound effects.
    private static Music backgroundMusic; // Music object for background music.

    static {
        // Static initializer to load sounds and music when the class is first used.
        instance.loadSound("collect", "bgm/collect.wav"); // Load collect sound effect.
        instance.loadSound("wrong-buzzer", "bgm/wrong-buzzer.mp3"); // Load wrong buzzer sound effect.
        instance.loadMusic("bgm", "bgm/bgm.mp3"); // Load background music.
    }

    private IOManager() {
        // Private constructor to enforce Singleton pattern.
    }

    // Static method to get the singleton instance.
    public static IOManager getInstance() {
        return instance;
    }

    // Method to load a sound effect.
    private void loadSound(String key, String fileName) {
        FileHandle fileHandle = Gdx.files.internal(fileName);
        if (fileHandle.exists()) {
            sounds.put(key, Gdx.audio.newSound(fileHandle)); // Load and store the sound.
        } else {
            Gdx.app.error("IOManager", "Sound file not found: " + fileName); // Log error if file not found.
        }
    }

    // Method to load background music.
    private void loadMusic(String key, String fileName) {
        FileHandle fileHandle = Gdx.files.internal(fileName);
        if (fileHandle.exists()) {
            backgroundMusic = Gdx.audio.newMusic(fileHandle); // Load the music.
            backgroundMusic.setVolume(1.0f); // Set the music volume.
            backgroundMusic.setLooping(true); // Enable looping.
        } else {
            Gdx.app.error("IOManager", "Music file not found: " + fileName); // Log error if file not found.
        }
    }

    // Method to play a sound effect.
    public void playSound(String key, float volume) {
        Sound sound = sounds.get(key);
        if (sound != null) {
            sound.play(volume); // Play the sound effect.
        } else {
            Gdx.app.error("IOManager", "Sound not found: " + key); // Log error if sound not found.
        }
    }

    // Method to play background music.
    public void playBackgroundMusic() {
        if (backgroundMusic != null && !backgroundMusic.isPlaying()) {
            backgroundMusic.play(); // Play the music if it's not already playing.
        }
    }

    // Method to stop background music.
    public void stopBackgroundMusic() {
        if (backgroundMusic != null) {
            backgroundMusic.stop(); // Stop the music.
        }
    }

    // Method to check if music is playing.
    public boolean isMusicPlaying() {
        return backgroundMusic != null && backgroundMusic.isPlaying();
    }

    // Method to dispose of all audio resources.
    public void dispose() {
        for (Sound sound : sounds.values()) {
            sound.dispose(); // Dispose each sound effect.
        }
        sounds.clear();

        if (backgroundMusic != null) {
            backgroundMusic.dispose(); // Dispose the background music.
        }
    }
}
