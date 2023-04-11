public class Solver {
    public static Grid solve(Grid initialGrid) {
        if (solveHelper(initialGrid, 0, 0)) {
            return initialGrid;
        }
        return null;
    }

    private static boolean solveHelper(Grid grid, int row, int col) {
        if (row == 9) {
            row = 0;
            col++;
            if (col == 9) {
                return true;
            }
        }
        if (!grid.getCell(row, col).isEditable()) {
            return solveHelper(grid, row + 1, col);
        }
        for (int value = 1; value <= 9; value++) {
            if (isValid(grid, row, col, value)) {
                grid.setCell(row, col, value);

                if (solveHelper(grid, row + 1, col)) {
                    return true;
                }
            }
        }
        grid.setCell(row, col, 0); // Reset cell value
        return false;
    }

    private static boolean isValid(Grid grid, int row, int col, int value) {
        return !grid.isDuplicateInRow(row, value) &&
               !grid.isDuplicateInColumn(col, value) &&
               !grid.isDuplicateInBox(row, col, value);
    }
}
