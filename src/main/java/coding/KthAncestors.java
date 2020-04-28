package coding;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Yasin Zhang
 */
public class KthAncestors {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        HashMap<Integer, LinkedList<Integer>> dict = new HashMap<>();
        for (int t = 0; t < T; t++) {
            int x = in.nextInt();
            int k = in.nextInt();

            if (x <= Math.pow(2, k)) {
                System.out.println(-1);
                continue;
            }

            if (dict.containsKey(x)) {
                LinkedList<Integer> list = dict.get(x);
                if (k-1 < list.size() && k-1 >= 0) {
                    System.out.println(list.get(k-1));
                } else {
                    System.out.println(-1);
                }
            } else {
                int tmp = x;
                LinkedList<Integer> list = new LinkedList<>();
                tmp = tmp / 2;
                while (tmp > 0) {
                    list.addFirst(tmp);
                    tmp = tmp / 2;
                }
                dict.put(x, list);
                if (k-1 < list.size() && k-1 >= 0) {
                    System.out.println(list.get(k-1));
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}
