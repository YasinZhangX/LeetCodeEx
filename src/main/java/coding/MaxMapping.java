package coding;

import java.util.*;

/**
 * 最大映射
2
ABC
BCA
 * @author Yasin Zhang
 */
public class MaxMapping {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = in.nextLine();
        }

        HashSet<Character> firstChar = new HashSet<>();
        double[] weight = new double['J' - 'A' + 1];
        for (String s : strs) {
            firstChar.add(s.charAt(0));
            for (int i = 0; i < s.length(); i++) {
                double curWeight = Math.pow(10, s.length() - i - 1);
                char curChar = s.charAt(i);
                weight[curChar - 'A'] = weight[curChar - 'A'] + curWeight;
            }
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingDouble(o -> o.weight));
        for (int i = 0; i < weight.length; i++) {
            minHeap.add(new Pair((char) ('A'+i), weight[i]));
        }
        while (!minHeap.isEmpty()) {
            if (!firstChar.contains(minHeap.peek().c)) {
                weight[minHeap.peek().c - 'A'] = 0;
                break;
            } else {
                minHeap.poll();
            }
        }

        Arrays.sort(weight);

        double res = 0;
        for (int i = 0; i < weight.length; i++) {
            res = res + weight[i] * i;
        }

        System.out.println((long) res);
    }

    static class Pair {
        char c;
        double weight;

        Pair(char c, double weight) {
            this.c = c;
            this.weight = weight;
        }
    }
}
