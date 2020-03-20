package hard;

import java.util.Collections;
import java.util.HashSet;

/**
 * @author Yasin Zhang
 */
public class NumSimilarGroups {
    public int numSimilarGroups(String[] A) {
        HashSet<String> set = new HashSet<>();
        Collections.addAll(set, A);

        int[] root = new int[set.size()];
        String[] words = new String[root.length];
        int k = 0;
        for(String s : set) {
            root[k] = k;
            words[k++] = s;
        }

        for (int i = 0; i < set.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (isSimilar(words[i], words[j])) {
                    root[getRoot(root, j)] = i;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < root.length; i++) {
            if (root[i] == i) {
                result++;
            }
        }

        return result;
    }

    private int getRoot(int[] root, int j) {
        return root[j] == j ? j : getRoot(root, root[j]);
    }

    private boolean isSimilar(String str1, String str2) {
        for (int i = 0, cnt = 0; i < str1.length(); ++i) {
            if (str1.charAt(i) == str2.charAt(i)) {
                continue;
            }

            if (++cnt > 2) {
                return false;
            }
        }
        return true;
    }
}
