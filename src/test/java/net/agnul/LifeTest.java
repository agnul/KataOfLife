package net.agnul;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LifeTest {

    String[] boardState = {
            ". # . . . .",
            ". # # . . .",
            "# # . . . #",
            "# # . . . .",
            ". . . . . ."
    };

    GameOfLife game;
    Board board;

    @Before
    public void setUp() {

        game = new GameOfLife(boardState);
        board = game.getBoard();

    }

    @Test
    public void testCellAt_0_0_isNotAlive() {

        assertThat(board.cellAt(0,0).isAlive(), is(false));

    }

    @Test
    public void testCellAt_0_1_isAlive() {

        assertThat(board.cellAt(0,1).isAlive(), is(true));

    }

    @Test
    public void testCellAt_1_1_willDie() {

        assertThat(board.cellAt(1,1).willLive(), is(false));

    }

    @Test
    public void testCellAt_3_4_willNotBeBorn() {

        assertThat(board.cellAt(3, 4).willBeBorn(), is(false));

    }

    @Test
    public void testCellAt_0_2_itNotAlive() {

        assertThat(board.cellAt(0, 2).isAlive(), is(false));

    }

    @Test
    public void testCellAt_0_2_has3LiveNeighbours() {

        assertThat(board.cellAt(0, 2).count(), is(3));

    }

    @Test
    public void testCellAt_0_2_willBeBorn() {

        assertThat(board.cellAt(0, 2).willBeBorn(), is(true));

    }

    @Test
    public void testCellAt_2_1_willDie() {

        assertThat(board.cellAt(2, 1).willLive(), is(false));

    }

    @Test
    public void testCellAt_1_2_willLive() {

        assertThat(board.cellAt(1, 2).willLive(), is(true));

    }

}
