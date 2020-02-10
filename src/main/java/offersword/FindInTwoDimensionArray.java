package offersword;

/**
 * 二维数组中的查找
 * @author Yasin Zhang
 */
public class FindInTwoDimensionArray {
    public boolean solution(int target, int [][] array) {
        if (array == null) {
            return false;
        }

        boolean found = false;

        int col = array[0].length - 1;
        int row = 0;

        while (col >= 0 && row <= array.length - 1) {
            if (array[row][col] == target) {
                found = true;
                break;
            } else if (array[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }

        return found;
    }
}
