package net.agnul;

import java.util.Arrays;

public class Cell {

    private GameOfLife game;

    private int r;

    private int c;

    private boolean alive = false;

    public Cell(GameOfLife game, int r, int c, boolean alive) {

        this.game = game;
        this.r = r;
        this.c = c;
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

        Cell[] neighbours = game.getNeighbours(this.r, this.c);

        return (int) Arrays.stream(neighbours)
                .filter(Cell::isAlive)
                .count();

    }

    public boolean isAlive() {

        return alive;

    }

}
