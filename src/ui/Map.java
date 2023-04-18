package ui;

import blocks.*;

import java.util.Random;

public class Map {
    private final Block[][] map;
    private final int size = 8;
    private final Furnace furnace;

    public Map() {
        map = new Block[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = new AirBlock();
            }
        }

        generateTerrain();

        this.furnace = new Furnace();
    }

    public Block getBlock(int i, int j) {
        return map[i][j];
    }

    private void generateTerrain() {
        Random random = new Random();

        int terrainLevel = size / 4;
        for (int j = 0; j < size; j++) {
            for (int k = 0; k < terrainLevel; k++) {
                insertAt(new SandBlock(), 0, j);
            }
        }

        int mineralsLevel = size * 3/4;
        for (int i = mineralsLevel; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (random.nextBoolean()) {
                    map[i][j] = new RawIronBlock();
                }
            }
        }

        int waterLevel = size / 4;
        for (int j = 0; j < size; j++) {
            for (int k = 0; k < waterLevel; k++) {
                insertAt(new WaterBlock(), 0, j);
            }
        }
    }

    public void moveIntoFurnace(int i, int j) {
        if (checkBounds(i, j)
                && map[i][j] instanceof SmeltableBlock
                && furnace.isInputEmpty()
                && furnace.isOutputEmpty()) {
            furnace.setInput((SmeltableBlock) map[i][j]);
            map[i][j] = new AirBlock();
            updateColumnGravity(j);
            furnace.smelt();
        }
    }

    public void placeFromFurnace(int i, int j) {
        if (!furnace.isOutputEmpty() && map[i][j].fallsThrough()) {
            Block output = furnace.getOutput();
            insertAt(output, i ,j);
            furnace.clearOutput();
        }
    }

    public boolean isFurnaceOutputEmpty() {
        return furnace.isOutputEmpty();
    }

    public void displayOnOut() {
        for (Block[] row : map) {
            for (Block block : row) {
                System.out.print(block.display() + "  ");
            }
            System.out.println();
        }
    }

    public void insertAt(Block block, int i, int j) {
        if (checkBounds(i, j)) {
            if (map[i][j].fallsThrough()) {
                map[i][j] = block;
            }

            if (block.fallsWithGravity()) {
                updateBlockGravity(i, j);
            }
        }
    }

    private void updateColumnGravity(int j) {
        int i = size - 1;
        while (i >= 0) {
            updateBlockGravity(i, j);
            i--;
        }
    }

    private void updateBlockGravity(int i, int j) {
        while (i < size - 1) {
            if (map[i+1][j].fallsThrough() && map[i][j].fallsWithGravity()) {
                swap(i, j);
            }
            i++;
        }
    }

    private void swap(int i, int j) {
        if (i >= 0 && j >= 0 && i < size - 1 && j < size) {
            Block tmp = map[i][j];
            map[i][j] = map[i+1][j];
            map[i+1][j] = tmp;
        }
    }

    private boolean checkBounds(int i, int j) {
        return i >= 0 && i < size && j >= 0 && j < size;
    }
}
