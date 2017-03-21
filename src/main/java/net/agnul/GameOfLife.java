package net.agnul;

import java.util.ArrayList;
import java.util.List;

public class GameOfLife {

    Cell[][] cells;

    int rows;
    int columns;

    public GameOfLife(String[] cells) {

        this.rows = cells.length;
        this.columns = cells[0].split("\\s").length;

        this.cells = new Cell[rows][columns];

        for (int i = 0; i < rows; ++i) {
            String[] line = cells[i].split("\\s");
            for (int j = 0; j < columns; ++j) {

                this.cells[i][j] = new Cell(this, i, j, "#".equals(line[j]));

            }
        }

    }

    public Cell cellAt(int x, int y) {

        return cells[x][y];

    }

    public Cell[] getNeighbours(int r, int c) {

        int fromI = Math.max(0, r - 1);
        int toI = Math.min(r + 1, columns);

        int fromJ = Math.max(0, c - 1);
        int toJ = Math.min(c + 1, rows);

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
