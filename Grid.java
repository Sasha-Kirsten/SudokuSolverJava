import java.util.Arrays;

public class Grid {
    private final Cell[][] grid;

    public Grid(int[][] puzzle) {
        grid = new Cell[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = new Cell(puzzle[i][j], puzzle[i][j] == 0);
            }
        }
    }

    public Cell getCell(int row, int col) {
        return grid[row][col];
    }

    public void setCell(int row, int col, int value) {
        grid[row][col].setValue(value);
    }

    public boolean isDuplicateInRow(int row, int value) {
        return Arrays.stream(grid[row]).anyMatch(cell -> cell.getValue() == value);
    }

    public boolean isDuplicateInColumn(int col, int value) {
        return Arrays.stream(grid).anyMatch(row -> row[col].getValue() == value);
    }

    public boolean isDuplicateInBox(int row, int col, int value) {
        int boxRow = row / 3 * 3;
        int boxCol = col / 3 * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[boxRow + i][boxCol + j].getValue() == value) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Cell[] row : grid) {
            for (Cell cell : row) {
                sb.append(cell.getValue()).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
