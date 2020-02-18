package offersword;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 * @author Yasin Zhang
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<Integer>();
        }

        ArrayList<Integer> result = new ArrayList<>();
        int Y = matrix.length;
        int X = matrix[0].length;
        int start = 0;
        while (Y > start * 2 && X > start * 2) {
            printMatrixInCircle(matrix, start, result);
            start++;
        }

        return result;
    }

    private void printMatrixInCircle(int[][] matrix, int start, ArrayList<Integer> result) {
        // 圈中右下角的坐标
        int endY = matrix.length - 1 - start;
        int endX = matrix[0].length - 1 - start;

        // 从左到右
        for (int i = start; i <= endX; i++) {
            result.add(matrix[start][i]);
        }

        // 从上到下
        if (start < endY) {
            for (int i = start+1; i <= endY; i++) {
                result.add(matrix[i][endX]);
            }

            // 从右到左
            if (start < endX) {
                for (int i = endX-1; i >= start; i--) {
                    result.add(matrix[endY][i]);
                }

                if (start < endY - 1) {
                    // 从下到上
                    for (int i = endY-1; i >= start+1; i--) {
                        result.add(matrix[i][start]);
                    }
                }
            }
        }
    }
}
