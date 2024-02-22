package com.mygdx.game.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.ObjectMap;

/**
 * The IOManager class handles the input/output operations related to audio in the game.
 * It manages the loading, playing, and disposing of sound effects and background music.
 */
public class IOManager{

    private static final ObjectMap<String, Sound> sounds = new ObjectMap<>(); // Map to store sounds with their identifiers.
    private static Music backgroundMusic; // Variable to hold the background music.

    // Static initializer block to load resources when the class is first used.
    static {
        // Loading sounds with their respective file names.
        loadSound("collect", "collect.wav"); // Sound for collecting a droplet.
        loadSound("collision", "collision.wav"); // Sound for colliding with the mouse.

        // Loading background music.
        loadMusic("bgm", "bgm.wav"); // Background music file.
    }

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private IOManager() {
    }

    /**
     * Loads a sound and adds it to the sounds map.
     * 
     * @param key The key to associate with the sound.
     * @param fileName The file name of the sound to load.
     */
    private static void loadSound(String key, String fileName) {
        FileHandle fileHandle = Gdx.files.internal(fileName);
        if (fileHandle.exists()) {
            sounds.put(key, Gdx.audio.newSound(fileHandle));
        } else {
            Gdx.app.error("IOManager", "Sound file not found: " + fileName);
        }
    }

    /**
     * Loads background music from a file.
     * 
     * @param key The key to associate with the music.
     * @param fileName The file name of the music to load.
     */
    private static void loadMusic(String key, String fileName) {
        FileHandle fileHandle = Gdx.files.internal(fileName);
        if (fileHandle.exists()) {
            backgroundMusic = Gdx.audio.newMusic(fileHandle);
            backgroundMusic.setVolume(0.3f); // Setting the volume.
            backgroundMusic.setLooping(true); // Music loops continuously.
        } else {
            Gdx.app.error("IOManager", "Music file not found: " + fileName);
        }
    }

    /**
     * Plays a sound effect based on the provided key.
     * 
     * @param key The key of the sound effect to play.
     * @param volume The volume at which to play the sound.
     */
    public static void playSound(String key, float volume) {
        Sound sound = sounds.get(key);
        if (sound != null) {
            Gdx.app.log("IOManager", "Playing sound: " + key);
            sound.play(volume);
        } else {
            Gdx.app.error("IOManager", "Sound not found: " + key);
        }
    }

    /**
     * Plays the background music if it's not already playing.
     */
    public static void playBackgroundMusic() {
        if (backgroundMusic != null && !backgroundMusic.isPlaying()) {
            backgroundMusic.play();
        }
    }

    /**
     * Stops the background music if it's playing.
     */
    public static void stopBackgroundMusic() {
        if (backgroundMusic != null) {
            backgroundMusic.stop();
        }
    }

    /**
     * Disposes of all loaded sounds and background music to free up resources.
     * This method should be called when the game is closing or no longer needs these resources.
     */
    public static void dispose() {
        // Disposing of all sounds.
        for (Sound sound : sounds.values()) {
            sound.dispose();
        }
        sounds.clear();

        // Disposing of background music if it's not null.
        if (backgroundMusic != null) {
            backgroundMusic.dispose();
        }
    }
}
