package hard;

/**
 * @author Yasin Zhang
 */
public class MaxRepetitions {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int[][] next = new int[s2.length()][2];
        for (int i = 0; i < s2.length(); i++) {
            int index = i;
            int count = 0;
            for (int j = 0; j < s1.length(); j++) {
                if (s1.charAt(j) == s2.charAt(index)) {
                    index++;
                    if (index == s2.length()) {
                        index = 0;
                        count++;
                    }
                }
            }

            next[i][0] = index;
            next[i][1] = count;
        }

        int res = 0;
        int nextIndex = 0;
        for (int i = 0; i < n1; i++) {
            res += next[nextIndex][1];
            nextIndex = next[nextIndex][0];
        }

        return res / n2;
    }
}
