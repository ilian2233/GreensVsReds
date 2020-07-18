package Objects;

import Enums.Variant;
import Exceptions.BoardNotCompatibleException;
import Exceptions.VariantNotFoundException;

public class Board {

    Cell[][] cells;

    public Board(int x, int y, String[] rows) throws BoardNotCompatibleException, VariantNotFoundException {
        cells = new Cell[x][y];

        cells = fillBoard(rows);
    }

    public Board(Cell[][] cells) {
        this.cells = cells;
    }

    private Cell[][] fillBoard(String[] rows) throws BoardNotCompatibleException, VariantNotFoundException {
        if (rows.length != cells.length) {
            throw new BoardNotCompatibleException();
        }

        Cell[][] tempCells = cells;

        int i = 0;

        for (String str : rows) {
            if (str.length() != cells[i].length) {
                throw new BoardNotCompatibleException();
            }

            tempCells[i++] = rowToCells(str);
        }

        return tempCells;
    }

    private Cell[] rowToCells(String str) throws VariantNotFoundException {
        Cell[] row = new Cell[str.length()];

        for (int i = 0; i < row.length; i++) {
            row[i] = new Cell(Variant.valueOf(str.charAt(i)));
        }

        return row;
    }

    public Variant getVariantOfCellAt(int x, int y) {
        return cells[x][y].variant;
    }
}
