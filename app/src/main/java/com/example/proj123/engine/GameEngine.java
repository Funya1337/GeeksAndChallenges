package com.example.proj123.engine;

import com.example.proj123.classes.Coordinate;
import com.example.proj123.enums.TileType;

import java.util.ArrayList;
import java.util.List;

public class GameEngine {
    public static final int GameWidth = 28;
    public static final int GameHeight = 42;

    private List<Coordinate> walls = new ArrayList<>();

    public GameEngine()
    {

    }

    public void initGame()
    {
        AddWalls();
    }

    public TileType[][] getMap()
    {
        TileType[][] map = new TileType[GameWidth][GameHeight];
        for (int x = 0; x < GameWidth; x++)
        {
            for (int y = 0; y < GameHeight; y++)
            {
                map[x][y] = TileType.Nothing;
            }
        }
        for (Coordinate wall: walls)
        {
            map[wall.getX()][wall.getY()] = TileType.Wall;
        }
        return map;
    }

    public void AddWalls()
    {
        // Top and bottom walls
        for (int x = 0; x < GameWidth; x++)
        {
            walls.add(new Coordinate(x, 0));
            walls.add(new Coordinate(x, GameHeight - 1));
        }

        // Left and Right walls
        for (int y = 0; y < GameHeight; y++)
        {
            walls.add(new Coordinate(0, y));
            walls.add(new Coordinate(GameWidth - 1, y));
        }
    }
}

