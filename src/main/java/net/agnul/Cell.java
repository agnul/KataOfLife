package net.agnul;

import java.util.Arrays;

public class Cell {

    private GameOfLife game;

    private int x;

    private int y;

    private boolean alive = false;

    public Cell(GameOfLife game, int x, int y, boolean alive) {

        this.game = game;
        this.x = x;
        this.y = y;
        this.alive = alive;

    }

    public boolean willLive() {

        return alive && count() > 3;

    }

    public boolean willBeBorn() {

        int neighboursAlive = count();

        return (! alive) && neighboursAlive == 3;

    }

    public int count() {

        Cell[] neighbours = game.getNeighbours(this.x, this.y);

        return (int) Arrays.stream(neighbours)
                .filter(Cell::isAlive)
                .count();

    }

    public boolean isAlive() {

        return alive;

    }

}
