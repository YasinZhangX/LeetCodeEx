package medium;

/**
 * @author Yasin Zhang
 */
public class UpdateMatrix {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix[0] == null) {
            return matrix;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] distance = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    distance[i][j] = Integer.MAX_VALUE - 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) {
                    distance[i][j] = Math.min(distance[i][j], distance[i-1][j]);
                }

                if (j - 1 >= 0) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][j-1]);
                }
            }
        }

        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (i + 1 < m) {
                    distance[i][j] = Math.min(distance[i][j], distance[i+1][j]);
                }

                if (j + 1 < n) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][j+1]);
                }
            }
        }

        return distance;
    }
}
