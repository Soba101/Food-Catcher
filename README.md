# Project Miner - Java/LibGDX Edition

## Introduction
"Project Miner" is a Java/LibGDX implementation of the classic Gold Miner game. This project aims to recreate the enjoyable and challenging aspects of the original game, leveraging the robust features of Java and the LibGDX framework to enhance gameplay experience and graphics.

## Project Structure
The project is organized into several key classes, each serving a specific function in the game's overall architecture:

- **`iMovable`**: Interface defining movement-related methods.
- **`IOManager`**: Handles input and output operations.
- **`SceneManager`**: Manages various scenes within the game, like start, game, and end scenes.
- **`Entity`**: Represents entities within the game.
- **`AIControlManager`**: Manages AI behavior and interactions.
- **`PlayerControlManager`**: Handles player controls and interactions.
- **`TexturedObject`**: Deals with textured objects in the game environment.
- **`MyGdxGame`**: The main class that initializes and runs the game loop.
- **`CollisionManager`**: Manages collision detection and responses.
- **`DesktopLauncher`**: Entry point for launching the game on desktop platforms.
- **`GameScene`**: Represents the main gameplay scene.
- **`StartScene`, `EndScene`, `EndScene2`**: Manage different stages of the game, like beginning and ending.
- **`GameState`**: Manages the state of the game.
- **`GameMaster`**: Central control for game logic and flow.
- **`Scene`**: Base class for different scenes in the game.
- **`EntityManager`**: Handles the entities within the game's scenes.

## Features
- **Classic Gold Miner Gameplay**: Engage in the time-tested gameplay of collecting gold and gems while avoiding obstacles.
- **Enhanced Graphics**: Experience the classic game with improved graphics powered by LibGDX.
- **Cross-Platform Play**: Play on various platforms, thanks to the flexibility of LibGDX.
- **Dynamic Scenes and Entities**: Navigate through different game scenes and interact with various game entities.

## How to Play
- **Objective**: Gather as much gold and precious minerals as possible within a time limit.
- **Controls**: Use arrow keys to control the bucet and collect treasures.
- **Progress through Levels**: Encounter increasing difficulty and varied layouts in multiple levels.

## Installation
To install and run "Project Miner," follow these steps:

1. Clone the repository: `git clone [repository-url]`.
2. Navigate to the project directory: `cd Project-Miner`.
3. Build the project using your Java IDE or build tools.
4. Run the game, typically through the `DesktopLauncher` class.

## Technologies
- **Java**: Primary programming language for game logic and mechanics.
- **LibGDX**: Used for graphical rendering, input handling, and cross-platform support.

## Contribution
Contributions to "Project Miner" are welcome. Follow these steps to contribute:

1. Fork the repository.
2. Create a new feature branch: `git checkout -b feature/your_feature_name`.
3. Commit your changes and push to the branch.
4. Create a new Pull Request.
