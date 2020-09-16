package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yasin Zhang
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastIndex[S.charAt(i) - 'a'] = i;
        }

        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = 0;
        for (int i = 0; i < S.length(); i++) {
            right = Math.max(right, lastIndex[S.charAt(i) - 'a']);
            if (i == right) {
                res.add(right - left + 1);
                left = i + 1;
            }
        }

        return res;
    }
}
