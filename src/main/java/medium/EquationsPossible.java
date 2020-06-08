package medium;

import java.util.Arrays;

/**
 * 990. 等式方程的可满足性
 * @author Yasin Zhang
 */
public class EquationsPossible {
    public boolean equationsPossible(String[] equations) {
        int[] union = new int[26];
        Arrays.fill(union, -1);

        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int leftIndex = equation.charAt(0) - 'a';
                int rightIndex = equation.charAt(3) - 'a';
                int leftParentIndex = findParent(leftIndex, union);
                int rightParentIndex = findParent(rightIndex, union);
                if (leftParentIndex != rightParentIndex) {
                    union[rightParentIndex] = leftIndex;
                }
            }
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int leftParentIndex = findParent(equation.charAt(0) - 'a', union);
                int rightParentIndex = findParent(equation.charAt(3) - 'a', union);
                if (leftParentIndex == rightParentIndex) {
                    return false;
                }
            }
        }

        return true;
    }

    private int findParent(int index, int[] union) {
        return union[index] == -1 ? index : findParent(union[index], union);
    }
}
