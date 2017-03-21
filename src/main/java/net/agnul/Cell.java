package net.agnul;

import java.util.Arrays;

public class Cell {

    private Board board;

    private int r;

    private int c;

    private boolean alive = false;

    public Cell(Board board, int r, int c, boolean alive) {

        this.board = board;
        this.r = r;
        this.c = c;
        this.alive = alive;

    }

    public boolean willLive() {

        int neighboursAlive = count();

        return alive && (neighboursAlive == 2 || neighboursAlive == 3);

    }

    public boolean willBeBorn() {

        int neighboursAlive = count();

        return (! alive) && neighboursAlive == 3;

    }

    public int count() {

        Cell[] neighbours = board.getNeighbours(this.r, this.c);

        return (int) Arrays.stream(neighbours)
                .filter(Cell::isAlive)
                .count();

    }

    public boolean isAlive() {

        return alive;

    }

}
