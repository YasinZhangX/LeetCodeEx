package medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class MinMeetingRoomsTest {

    @Test
    public void minMeetingRooms() {
        int[][] intervals = {{1,5},{8,9},{8,9}};
        MinMeetingRooms alg = new MinMeetingRooms();
        System.out.println(alg.minMeetingRooms(intervals));
    }
}
