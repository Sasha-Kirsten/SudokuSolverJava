import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Q2Main {
    public static void main(String[] args) {
        String puzzleFile = "Puzzle.txt"; // Replace with the correct path to the puzzle file
        int[][] puzzle = loadPuzzleFromFile(puzzleFile);
        if (puzzle != null) {
            Grid grid = new Grid(puzzle);
            System.out.println("Initial puzzle:");
            System.out.println(grid);
            Grid solvedGrid = Solver.solve(grid);
            if (solvedGrid != null) {
                System.out.println("Solved puzzle:");
                System.out.println(solvedGrid);
            } else {
                System.out.println("Failed to solve the puzzle.");
            }
        }
    }

    private static int[][] loadPuzzleFromFile(String filePath) {
        int[][] puzzle = new int[9][9];
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int row = 0;
            while ((line = br.readLine()) != null && row < 9) {
                String[] values = line.trim().split(",");
                for (int col = 0; col < 9 && col < values.length; col++) {
                    puzzle[row][col] = Integer.parseInt(values[col]);
                }
                row++;
            }
        } catch (IOException e) {
            System.err.println("Error reading the puzzle file: " + e.getMessage());
            return null;
        }

        return puzzle;
    }
}
