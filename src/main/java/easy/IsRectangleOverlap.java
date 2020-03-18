package easy;

/**
 * @author Yasin Zhang
 */
public class IsRectangleOverlap {
    public boolean solution(int[] rec1, int[] rec2) {
        return !(rec2[2] <= rec1[0]     // x4 <= x1, left
            || rec2[0] >= rec1[2]   // x3 >= x2, right
            || rec2[1] >= rec1[3]   // y3 >= y2, top
            || rec2[3] <= rec1[1]); // y4 <= y1, bottom
    }
}
