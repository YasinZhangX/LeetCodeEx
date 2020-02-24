package offersword;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;

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
                if (value < maxHeap.peek()) {
                    maxHeap.poll();
                    maxHeap.offer(value);
                }
            }
        }

        return new ArrayList<Integer>(maxHeap);
    }

    public ArrayList<Integer> solution2(int [] input, int k) {
        if (input == null || input.length < k || k == 0) {
            return new ArrayList<Integer>();
        }

        int start = 0;
        int end = input.length - 1;
        int index = partition(input, 0, input.length-1);
        while (index != k - 1) {
            if (index < k - 1) {
                start = index + 1;
            } else {
                end = index - 1;
            }
            index = partition(input, start, end);
        }

        ArrayList<Integer> result = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }

        return result;
    }

    private int partition(int[] array, int start, int end) {
        if (array == null || array.length == 0 || start < 0 || end >= array.length) {
            throw new RuntimeException("Illegal arguments");
        }

        int index = new Random().nextInt(end-start+1) + start;
        int tmp = array[index];
        array[index] = array[start];
        array[start] = tmp;

        int smallPart = start;
        for (index = start+1; index <= end; index++) {
            if (array[index] < array[start]) {
                smallPart++;
                if (index != smallPart) {
                    tmp = array[index];
                    array[index] = array[smallPart];
                    array[smallPart] = tmp;
                }
            }
        }

        tmp = array[start];
        array[start] = array[smallPart];
        array[smallPart] = tmp;

        return smallPart;
    }
}
