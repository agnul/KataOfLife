package net.agnul;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LifeTest {

    String[] board = {
            ". # . . . .",
            ". # # . . .",
            "# # . . . #",
            "# # . . . .",
            ". . . . . ."
    };

    GameOfLife game;

    @Before
    public void setUp() {

        game = new GameOfLife(board);

    }

    @Test
    public void testCellAt_0_0_isNotAlive() {

        assertThat(game.cellAt(0,0).isAlive(), is(false));

    }

    @Test
    public void testCellAt_0_1_isAlive() {

        assertThat(game.cellAt(0,1).isAlive(), is(true));

    }

    @Test
    public void testCellAt_1_1_willDie() {

        assertThat(game.cellAt(1,1).willDie(), is(true));

    }

    @Test
    public void testCellAt_3_4_willNotBeBorn() {

        assertThat(game.cellAt(3, 4).willBeBorn(), is(false));

    }

    @Test
    public void testCellAt_0_2_itNotAlive() {

        assertThat(game.cellAt(0, 2).isAlive(), is(false));

    }

    @Test
    public void testCellAt_0_2_has3LiveNeighbours() {

        assertThat(game.cellAt(0, 2).count(), is(3));

    }

    @Test
    public void testCellAt_0_2_willBeBorn() {

        assertThat(game.cellAt(0, 2).willBeBorn(), is(true));

    }

}
