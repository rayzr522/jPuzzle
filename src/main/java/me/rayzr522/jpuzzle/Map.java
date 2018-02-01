package me.rayzr522.jpuzzle;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Map {
    private static final String MAP_FILE = "/map.txt";

    private String[] data;
    private String[] map;

    private Image grass, stone, stairHori, stairVert, moveable;

    public Map() {
        grass = Utils.loadImage("/sprite/grass.png");
        stairHori = Utils.loadImage("/sprite/stair-hori.png");
        stairVert = Utils.loadImage("/sprite/stair-vert.png");
        moveable = Utils.loadImage("/sprite/moveable.png");
        stone = Utils.loadImage("/sprite/stone.png");

        try {
            loadMap();
        } catch (IOException e) {
            e.printStackTrace();
        }
        reset();

    }

    private void loadMap() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream(MAP_FILE);
        Scanner scanner = new Scanner(inputStream);

        data = new String[16];

        for (int i = 0; i < 16; i++) {
            data[i] = scanner.next();
        }

        scanner.close();
        inputStream.close();
    }

    public void reset() {
        map = data;
    }


    public Image getGrass() {

        return grass;

    }

    public Image getStone() {

        return stone;

    }

    public Image getStairHori() {

        return stairHori;

    }

    public Image getStairVert() {

        return stairVert;

    }

    public Image getMoveable() {

        return moveable;

    }

    public String getMap(int x, int y) {

        String index = map[y].substring(x, x + 1);
        return index;

    }

    public void setMap(int x, int y, String r) {

        String[] MapTemp = new String[16];

        for (int y2 = 0; y2 < 16; y2++) {

            MapTemp[y2] = "";

            for (int x2 = 0; x2 < 16; x2++) {

                if (x2 == x && y2 == y) {

                    MapTemp[y2] = MapTemp[y2] + r;

                } else {

                    MapTemp[y2] = MapTemp[y2] + getMap(x2, y2);

                }
            }

        }

        map = MapTemp;

    }
}
