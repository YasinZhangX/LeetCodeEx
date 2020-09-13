package coding.test;

import java.util.*;

/**
 * @author Yasin Zhang
 */
public class TX2 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        HashMap<Integer, HashSet<Integer>> announceMap = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            announceMap.put(i, new HashSet<>());
//        }
//
//        for (int i = 0; i < m; i++) {
//            int k = sc.nextInt();
//            ArrayList<Integer> members = new ArrayList<>();
//            for (int j = 0; j < k; j++) {
//                int cur = sc.nextInt();
//
//            }
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int k = sc.nextInt();
            ArrayList<Integer> members = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                members.add(sc.nextInt());
            }
            groups.add(members);
        }

        System.out.println(solution(m, groups));
    }

    private static int solution(int m, ArrayList<ArrayList<Integer>> groups) {
        LinkedList<Integer> queue = new LinkedList<>();
        HashSet<Integer> res = new HashSet<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res.add(cur);
            for (int i = 0; i < m; i++) {
                if (groups.get(i).contains(cur)) {
                    for (int j = 0; j < groups.get(i).size(); j++) {
                        int k = groups.get(i).get(j);
                        if (!res.contains(k)) {
                            queue.offer(k);
                        }
                    }
                }
            }
        }

        return res.size();
    }
}
