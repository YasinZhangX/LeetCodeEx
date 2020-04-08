package hard;

import java.util.PriorityQueue;

/**
 * @author Yasin Zhang
 */
public class MediumFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MediumFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((o1, o2) -> (o2 - o1));
    }

    public void addNum(int num) {
        if (minHeap.size() == 0 || num >= minHeap.peek()) {
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }

        if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.add(minHeap.poll());
        } else if (minHeap.size() < maxHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() == 0) {
            return (maxHeap.size() == 0) ? 0 : maxHeap.peek();
        }
        if (maxHeap.size() == 0) {
            return minHeap.peek();
        }

        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            return minHeap.peek();
        }
    }
}
