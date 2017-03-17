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

    public Cell[] getNeighbours(int x, int y) {

        int fromX = Math.max(0, x - 1);
        int toX = Math.min(x + 1, columns);

        int fromY = Math.max(0, y - 1);
        int toY = Math.min(y + 1, rows);

        List<Cell> neighbours = new ArrayList<>();
        for (int i = fromX; i <= toX; ++i) {
            for (int j = fromY; j <= toY; ++j) {
                if (i == x && j == y) {
                    continue;
                }

                neighbours.add(cells[i][j]);
            }
        }

        return neighbours.toArray(new Cell[neighbours.size()]);
    }

}
