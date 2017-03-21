package net.agnul;

public class GameOfLife {

    Board board;

    public GameOfLife(String[] boardState) {

        int rows = boardState.length;
        int columns = boardState[0].split("\\s").length;

        board = new Board(rows, columns);

        for (int i = 0; i < rows; ++i) {
            String[] line = boardState[i].split("\\s");
            for (int j = 0; j < columns; ++j) {

                board.placeCell(i, j, new Cell(board, i, j, "#".equals(line[j])));

            }
        }

    }

    public void tick() {

        Board next = new Board(board.rows, board.columns);

        for (int i = 0; i < next.rows; ++i) {
            for (int j = 0; j < next.columns; ++j) {

                Cell c = board.cellAt(i, j);
                if (c.isAlive()) {
                    next.placeCell(i, j, new Cell(next, i, j, c.willLive()));
                } else {
                    next.placeCell(i, j, new Cell(next, i, j, c.willBeBorn()));
                }

            }
        }

        board = next;

    }

    public Board getBoard() {
        return board;
    }

    public String[] getBoardState() {

        String[] state = new String[board.rows];
        for (int i = 0; i < board.rows; ++i) {
            StringBuilder r = new StringBuilder();
            String sep = "";
            for (int j = 0; j < board.columns; ++j) {
                r.append(sep);
                r.append(board.cellAt(i, j).isAlive() ? "#" : ".");
                sep = " ";
            }
            state[i] = new String(r);
        }

        return state;

    }

}
