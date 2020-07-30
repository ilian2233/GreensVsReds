package Objects;

import Enums.Variant;

public class BoardService {

    private static Cell[][] copyArray(Cell[][] oldArray){

        Cell[][] newArray = new Cell[oldArray.length][oldArray[0].length];

        for (int i = 0; i < oldArray.length; i++) {
            for (int j = 0; j < oldArray[i].length; j++) {
                newArray[i][j] = new Cell(oldArray[i][j].variant);
            }
        }

        return newArray;
    }

    public static Board iterate(Board board) {

        Cell[][] iteratedCells = copyArray(board.cells);

        for (int i = 0; i < board.cells.length; i++) {
            for (int j = 0; j < board.cells[i].length; j++) {
                iteratedCells[i][j] = iterateCell(i, j, board.cells);
            }
        }

        return new Board(iteratedCells);
    }

    private static Cell iterateCell(int i, int j, Cell[][] cells) {

        int adjacentGreens = countAdjacentGreens(i, j, cells);

        Cell newCell = cells[i][j];

        if (cells[i][j].variant == Variant.Green) {
            if (adjacentGreens != 2 && adjacentGreens != 3 && adjacentGreens != 6) {
                newCell = new Cell(Variant.Red);
            }
        } else {
            if (adjacentGreens == 3 || adjacentGreens == 6) {
                newCell = new Cell(Variant.Green);
            }
        }
        return newCell;
    }

    private static int countAdjacentGreens(int x, int y, Cell[][] cells) {

        int count = 0;

        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                try {
                    if (cells[i][j].variant == Variant.Green) {
                        count++;
                    }
                } catch (ArrayIndexOutOfBoundsException ignore) {
                }
            }
        }

        return (cells[x][y].variant == Variant.Green) ? count - 1 : count;
    }

    public static int countGenerationInWitchCellIsGreen(int x, int y, int N, Board board1) {

        int count = 0;

        if (board1.getVariantOfCellAt(y, x) == Variant.Green) {
            count++;
        }

        for (int i = 0; i < N; i++) {
            board1 = BoardService.iterate(board1);
            if (board1.getVariantOfCellAt(y, x) == Variant.Green) {
                count++;
            }
        }
        return count;
    }
}
