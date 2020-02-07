package offersword;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author Yasin Zhang
 */
public class GetLeastKNum {
    public ArrayList<Integer> solution(int [] input, int k) {
        if (input == null || k == 0 || input.length < k) {
            return new ArrayList<Integer>();
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (i1, i2) -> i2 - i1);

        for (int value : input) {
            if (maxHeap.size() < k) {
                maxHeap.offer(value);
            } else {
                if (maxHeap.peek() > value) {
                    maxHeap.poll();
                    maxHeap.offer(value);
                }
            }
        }

        return new ArrayList<Integer>(maxHeap);
    }
}
