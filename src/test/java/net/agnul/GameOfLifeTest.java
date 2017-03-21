package net.agnul;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class GameOfLifeTest {

    String toadInitialState[] = new String[] {
            ". . . . . .",
            ". . . # . .",
            ". # . . # .",
            ". # . . # .",
            ". . # . . .",
            ". . . . . ."
    };

    String toadAlternateState[] = new String [] {
            ". . . . . .",
            ". . . . . .",
            ". . # # # .",
            ". # # # . .",
            ". . . . . .",
            ". . . . . ."
    };

    @Test
    public void testGameGoesFromToadToToadAlternate() {

        GameOfLife g = new GameOfLife(toadInitialState);

        g.tick();

        assertThat(g.getBoardState(), is(toadAlternateState));

    }

}
