package problems;

/**
 * Created by amarendra on 09/02/18.
 * N Queen Problem Using Backtracking Algorithm
 */
public class NQueenProblem {

    public static void main(final String[] args) {

        final int n = 4;
        System.out.println("For n = " + n);
        final Position[] positions = solveNQueenOneSolution(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (final Position position : positions) {
                    if (position.row == i && position.col == j) {
                        System.out.print("Q ");
                        break;
                    }
                }
                System.out.print("X ");
            }

            System.out.println("");
        }

    }

    public static Position[] solveNQueenOneSolution(final int n) {
        final Position[] positions = new Position[n];
        final boolean hasSolution = solveNQueenOneSolution(n, 0, positions);
        if (hasSolution) {
            return positions;
        } else {
            return new Position[0];
        }
    }

    private static boolean solveNQueenOneSolution(final int n, final int row, final Position[] positions) {

        if (n == row) {
            return true;
        }

        for (int col = 0; col < n; col++) {
            boolean foundSafe = true;

            for (int queen = 0; queen < row; queen++) {
                if (positions[queen].col == col ||
                        positions[queen].row == row ||
                        positions[queen].row - positions[queen].col == row - col ||
                        positions[queen].row + positions[queen].col == row + col) {
                    foundSafe = false;
                    break;
                }
            }
            if (foundSafe) {
                positions[row] = new Position(row, col);
                if (solveNQueenOneSolution(n, row + 1, positions)) {
                    return true;
                }
            }
        }
        return false;
    }

    static class Position {
        int row, col;

        Position(final int row, final int col) {
            this.row = row;
            this.col = col;
        }
    }
}
