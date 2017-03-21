package net.agnul;

import java.util.ArrayList;
import java.util.List;

public class Board {

    Cell[][] cells;

    int rows;

    int columns;

    public Board(int rows, int columns) {

        this.rows = rows;
        this.columns = columns;

        cells = new Cell[rows][columns];

    }

    public void placeCell(int r, int c, Cell cell) {

        cells[r][c] = cell;

    }

    public Cell cellAt(int r, int c) {

        return cells[r][c];

    }

    public Cell[] getNeighbours(int r, int c) {

        int fromI = Math.max(0, r - 1);
        int toI = Math.min(r + 1, rows - 1);

        int fromJ = Math.max(0, c - 1);
        int toJ = Math.min(c + 1, columns - 1);

        List<Cell> neighbours = new ArrayList<>();
        for (int i = fromI; i <= toI; ++i) {
            for (int j = fromJ; j <= toJ; ++j) {
                if (i == r && j == c) {
                    continue;
                }

                neighbours.add(cells[i][j]);
            }
        }

        return neighbours.toArray(new Cell[neighbours.size()]);
    }

}
