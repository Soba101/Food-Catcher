package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

/**
 * DesktopLauncher is the entry point for launching the game on desktop platforms.
 * It configures and starts a new LWJGL3 application, setting up window properties and initializing the game.
 * Note: On macOS, the application needs to be started with the -XstartOnFirstThread JVM argument.
 */
public class DesktopLauncher {
    public static void main (String[] arg) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration(); // Create configuration object for the application.
        config.setForegroundFPS(60); // Set the target frames per second to 60.
        config.setTitle("ProjectMiner"); // Set the title of the window.
        config.setWindowedMode(GameMaster.width, GameMaster.height); // Set the window mode with dimensions from GameMaster.
        new Lwjgl3Application(new GameMaster(), config); // Create and start the application with the GameMaster and configuration.
    }
}
