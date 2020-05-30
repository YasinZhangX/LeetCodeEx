package hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Yasin Zhang
 */
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        } else if (heights.length == 1) {
            return heights[0];
        }

        int[] nHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, nHeights, 1, heights.length);

        int area = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        for (int i = 1; i < nHeights.length; i++) {
            while (nHeights[i] < nHeights[stack.peekLast()]) {
                int height = nHeights[stack.removeLast()];
                int weight = i - stack.peekLast() - 1;
                area = Math.max(height * weight, area);
            }
            stack.addLast(i);
        }

        return area;
    }
}
