package primary.others;

import java.util.ArrayList;
import java.util.List;

/**
 * 帕斯卡三角形
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 * @author Yasin Zhang
 */
public class Ex4 {

    public List<List<Integer>> generate(int numRows) {
        if (numRows < 1) {
            return new ArrayList<>();
        }

        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);

        List<Integer> lastRow = firstRow;
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);

            int j;
            for (j = 1; j <= i/2; j++) {
                row.add(lastRow.get(j)+lastRow.get(j-1));
            }
            while (j <= i) {
                row.add(row.get(i-j));
                j++;
            }
            triangle.add(row);

            lastRow = row;
        }

        return triangle;
    }

    public List<List<Integer>> simply(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }

            }
            result.add(list);
        }
        return result;
    }

}
