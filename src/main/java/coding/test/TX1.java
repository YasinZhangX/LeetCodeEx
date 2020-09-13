package coding.test;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Yasin Zhang
 */
public class TX1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        long[] list1 = new long[m];
        for (int i = 0; i < m; i ++) {
            list1[i] = sc.nextLong();
        }
        int n = sc.nextInt();
        long[] list2 = new long[n];
        for (int i = 0; i < n; i ++) {
            list2[i] = sc.nextLong();
        }

        HashMap<Long, String> map = new HashMap<>();
        for (long l : list1) {
            map.put(l, "in");
        }

        for (long l : list2) {
            String str = map.get(l);
            if (str != null) {
                System.out.print(l + " ");
            }
        }
    }
}
