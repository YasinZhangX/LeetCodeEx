package hard;

import java.util.*;

/**
 * @author Yasin Zhang
 */
public class SolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        Set<Integer> column = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>(); // row - column
        Set<Integer> diagonals2 = new HashSet<>(); // row + column
        int[] queens = new int[n];
        Arrays.fill(queens, -1);

        backTrace(results, n, queens, 0, column, diagonals1, diagonals2);
        return results;
    }

    public void backTrace(List<List<String>> results, int n, int[] queens, int curRow, Set<Integer> column, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (curRow == n) {
            List<String> result = generateResult(queens, n);
            results.add(result);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (queens[curRow] != -1) {
                continue;
            }

            if (column.contains(i)) {
                continue;
            }

            if (diagonals1.contains(curRow - i)) {
                continue;
            }

            if (diagonals2.contains(curRow + i)) {
                continue;
            }

            queens[curRow] = i;
            column.add(i);
            diagonals1.add(curRow - i);
            diagonals2.add(curRow + i);
            backTrace(results, n, queens, curRow + 1, column, diagonals1, diagonals2);
            column.remove(i);
            diagonals1.remove(curRow - i);
            diagonals2.remove(curRow + i);
            queens[curRow] = -1;
        }
    }

    private List<String> generateResult(int[] queens, int n) {
        List<String> result = new ArrayList<>();

        for (int site : queens) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i == site) {
                    builder.append('Q');
                } else {
                    builder.append('.');
                }
            }
            result.add(builder.toString().trim());
        }

        return result;
    }
}
