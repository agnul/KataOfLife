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

    public Board getBoard() {
        return board;
    }

}
