package net.agnul;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class BoardTest {

    Board createBoard(int r, int c) {
        Board b = new Board(r, c);
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                b.placeCell(i, j, new Cell(b, i, j, false));
            }
        }

        return b;
    }

    @Test
    public void testCellOnASingleCellBoardHas0Neighbours() {

        Board b = createBoard(1, 1);
        assertThat(b.getNeighbours(0, 0).length, is(0));

    }

    @Test
    public void testAllCellsOnATwoCellBoardHave3Neighbours() {

        Board b = createBoard(2, 2);
        assertThat(b.getNeighbours(0, 0).length, is(3));
        assertThat(b.getNeighbours(0, 1).length, is(3));
        assertThat(b.getNeighbours(1, 0).length, is(3));
        assertThat(b.getNeighbours(1, 1).length, is(3));

    }

    @Test
    public void testAllCornerCellsOnABoardHave3Neighbours() {

        Board b = createBoard(5, 8);
        assertThat(b.getNeighbours(0, 0).length, is(3));
        assertThat(b.getNeighbours(0, 7).length, is(3));
        assertThat(b.getNeighbours(4, 0).length, is(3));
        assertThat(b.getNeighbours(4, 7).length, is(3));

    }

    @Test
    public void testAllSideCellsOnABoardHave5Neighbours() {

        Board b = createBoard(3, 3);
        assertThat(b.getNeighbours(0, 1).length, is(5));
        assertThat(b.getNeighbours(1, 0).length, is(5));
        assertThat(b.getNeighbours(1, 2).length, is(5));
        assertThat(b.getNeighbours(2, 1).length, is(5));

    }

    @Test
    public void testAllCellsInsideABoardHave8Neighbours() {

        Board b = createBoard(4, 5);

        for (int i = 1; i < 3; ++i) {
            for (int j = 1; j < 4; ++j) {
                assertThat(String.format("Cell at %s,%s should have 8 neighbours", i, j),
                        b.getNeighbours(i, j).length, is(8));
            }
        }

    }
}
