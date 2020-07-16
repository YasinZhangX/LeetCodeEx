package coding.spring;

import java.util.*;

/**
 * @author Yasin Zhang
 */
public class GetCharacters {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();

        ArrayList<Integer> results = new ArrayList<>();
        for (int t = 0; t < n; t++) {
            int max = 0;
            HashMap<Pair, Integer> counter = new HashMap<>();
            for (int i = 0; i < m; i++) {
                int c = in.nextInt();
                HashSet<Pair> frame = new HashSet<>();
                for (int j = 0; j < c; j++) {
                    int x = in.nextInt();
                    int y = in.nextInt();
                    frame.add(new Pair(x, y));
                }
                Iterator<Pair> iterator = counter.keySet().iterator();
                while (iterator.hasNext()) {
                    Pair cur = iterator.next();
                    if (frame.contains(cur)) {
                        int count = counter.get(cur) + 1;

                        max = Math.max(max, count);

                        counter.put(cur, count);
                        frame.remove(cur);
                    } else {
                        iterator.remove();
                    }
                }
                for (Pair cur : frame) {
                    max = Math.max(max, 1);
                    counter.put(cur, 1);
                }
            }
            results.add(max);
        }

        for (int r : results) {
            System.out.println(r);
        }
    }

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair pair = (Pair) o;
            return x == pair.x &&
                y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
