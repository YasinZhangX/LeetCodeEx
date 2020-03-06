package offersword;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @author Yasin Zhang
 */
public class MaxInWindows {
    public ArrayList<Integer> solution(int [] num, int size)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || num.length < 3 || size == 0) {
            return result;
        }

        ArrayDeque<Integer> indexDeque = new ArrayDeque<>();
        int i = 0;
        while (i < size-1) {
            addElementInDeque(indexDeque, num, i++);
        }

        while (i < num.length) {
            if (!indexDeque.isEmpty()) {
                if ((i - indexDeque.peek()) >= size) {
                    indexDeque.poll();
                    continue;
                }
            }

            addElementInDeque(indexDeque, num, i);
            result.add(num[indexDeque.peek()]);
            i++;
        }

        return result;
    }

    private void addElementInDeque(ArrayDeque<Integer> indexDeque, int[] num, int i) {
        if (indexDeque.isEmpty()) {
            indexDeque.offer(i);
            return;
        }

        int cur = num[i];
        while (!indexDeque.isEmpty()) {
            if (num[indexDeque.peekLast()] <= cur) {
                indexDeque.pollLast();
            } else {
                break;
            }
        }

        indexDeque.offer(i);
    }

    public static void main(String[] args) {
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1, 3, 7};
        int size = 4;
        MaxInWindows alg = new MaxInWindows();
        System.out.println(alg.solution(num, size));
    }
}
