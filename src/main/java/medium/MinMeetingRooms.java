package medium;

import java.util.*;

/**
 * 会议室 2
 * @author Yasin Zhang
 */
public class MinMeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        List<PriorityQueue<Integer>> minHeaps = new ArrayList<>();

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int[] interval : intervals) {
            if (minHeaps.size() == 0) {
                PriorityQueue<Integer> newRoom = new PriorityQueue<>((o1, o2) -> o2 - o1);
                newRoom.add(interval[1]);
                minHeaps.add(newRoom);
            } else {
                boolean isDone = false;
                for (PriorityQueue<Integer> room : minHeaps) {
                    if (room.peek() <= interval[0]) {
                        room.add(interval[1]);
                        isDone = true;
                        break;
                    }
                }

                if (!isDone) {
                    PriorityQueue<Integer> newRoom = new PriorityQueue<>((o1, o2) -> o2 - o1);
                    newRoom.add(interval[1]);
                    minHeaps.add(newRoom);
                }
            }
        }

        return minHeaps.size();
    }
}
