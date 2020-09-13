package coding.test;

import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

/**
 * @author Yasin Zhang
 */
public class Wangyi4 {
    /*static int UNCOLORED = 0;
    static int RED = 1;
    static int GREEN = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String[] boyStr = line1.split(" ");
        HashMap<Integer, ArrayList<Integer>> boys = new HashMap<>();
        HashMap<Integer, Integer> color = new HashMap<>();
        for (String boy : boyStr) {
            int boyId = Integer.parseInt(boy);
            boys.put(boyId, new ArrayList<>());
            color.put(boyId, UNCOLORED);
        }

        String line2 = sc.nextLine();
        String[] girlStr = line2.split(" ");
        HashMap<Integer, ArrayList<Integer>> girls = new HashMap<>();
        for (String girl : girlStr) {
            int girlId = Integer.parseInt(girl);
            girls.put(girlId, new ArrayList<>());
            color.put(girlId, UNCOLORED);
        }

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int boy = sc.nextInt();
            int girl = sc.nextInt();
            boys.get(boy).add(girl);
            girls.get(girl).add(boy);
        }

        int ans = solution(boys, girls, color);
        System.out.println(ans);
    }

    private static int solution(HashMap<Integer, ArrayList<Integer>> boys,
                                 HashMap<Integer, ArrayList<Integer>> girls,
                                 HashMap<Integer, Integer> color) {
        int max = 0;

        for (int boyId : boys.keySet()) {
            int res = helper(boyId, new HashMap<>(boys),
                new HashMap<>(girls),
                new HashMap<>(color));
            max = Math.max(max, res);
        }

        return max;
    }

    private static int helper(Integer boyId,
                            HashMap<Integer, ArrayList<Integer>> boys,
                              HashMap<Integer, ArrayList<Integer>> girls,
                              HashMap<Integer, Integer> color) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(boyId);
        color.put(boyId, RED);
        while (!q.isEmpty()) {
            int node = q.poll();
            int cNei = color.get(node) == RED ? GREEN : RED;
            ArrayList<Integer> neighbors;
            if (boys.containsKey(node)) {
                neighbors = boys.get(node);
            } else {
                neighbors = girls.get(node);
            }
            for (int neighbor : neighbors) {
                if (color.get(neighbor) == UNCOLORED) {
                    q.offer(neighbor);
                    color.put(neighbor, cNei);
                }
            }
        }

        for (int i : color.keySet()) {
            if (color.get(i) == UNCOLORED) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                color.put(i, RED);
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    int cNei = color.get(node) == RED ? GREEN : RED;
                    ArrayList<Integer> neighbors;
                    if (boys.containsKey(node)) {
                        neighbors = boys.get(node);
                    } else {
                        neighbors = girls.get(node);
                    }
                    for (int neighbor : neighbors) {
                        if (color.get(neighbor) == UNCOLORED) {
                            queue.offer(neighbor);
                            color.put(neighbor, cNei);
                        }
                    }
                }
            }
        }

        int redCount = 0;
        int greenCount = 0;
        for (int id : color.keySet()) {
            if (color.get(id) == RED) {
                redCount++;
            } else if (color.get(id) == GREEN) {
                greenCount++;
            }
        }

        return Math.max(redCount, greenCount);
    }*/

    public static void main(String[] args) {
        
    }
}
