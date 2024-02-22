package com.mygdx.game.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.ObjectMap;

public class IOManager implements Disposable {

    private static final ObjectMap<String, Sound> sounds = new ObjectMap<>();
    private static Music backgroundMusic;

    // Load resources
    static {
        // Initialize sounds
        loadSound("collect", "collect.wav"); // Sound for collecting a droplet
        loadSound("collision", "collision.wav"); // Sound for colliding with the mouse

        // Initialize background music
        loadMusic("bgm", "bgm.wav"); // Background music file
    }

    private IOManager() {
        // Private constructor to prevent instantiation
    }

    private static void loadSound(String key, String fileName) {
        FileHandle fileHandle = Gdx.files.internal(fileName);
        if (fileHandle.exists()) {
            sounds.put(key, Gdx.audio.newSound(fileHandle));
        } else {
            Gdx.app.error("IOManager", "Sound file not found: " + fileName);
        }
    }

    private static void loadMusic(String key, String fileName) {
        FileHandle fileHandle = Gdx.files.internal(fileName);
        if (fileHandle.exists()) {
            backgroundMusic = Gdx.audio.newMusic(fileHandle);
            backgroundMusic.setVolume(0.3f); // Set to half volume
            backgroundMusic.setLooping(true);
        } else {
            Gdx.app.error("IOManager", "Music file not found: " + fileName);
        }
    }

    public static void playSound(String key, float volume) {
        Sound sound = sounds.get(key);
        if (sound != null) {
            Gdx.app.log("IOManager", "Playing sound: " + key);
            sound.play(volume);
        } else {
            Gdx.app.error("IOManager", "Sound not found: " + key);
        }
    }

    public static void playBackgroundMusic() {
        if (backgroundMusic != null && !backgroundMusic.isPlaying()) {
            backgroundMusic.play();
        }
    }

    public static void stopBackgroundMusic() {
        if (backgroundMusic != null) {
            backgroundMusic.stop();
        }
    }

    public void dispose() {
        // Dispose all sounds
        for (Sound sound : sounds.values()) {
            sound.dispose();
        }
        sounds.clear();

        // Dispose of background music if it's not null
        if (backgroundMusic != null) {
            backgroundMusic.dispose();
        }
    }
}

