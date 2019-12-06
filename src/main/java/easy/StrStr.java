package easy;

/**
 * 28. 实现 strStr()
 *
 * @author Yasin Zhang
 */
public class StrStr {
    public int solution(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        char[] source = haystack.toCharArray();
        char[] target = needle.toCharArray();
        int max = source.length - target.length;
        char first = target[0];

        for(int i = 0; i <= max; i++) {
            if (source[i] != first) {
                continue;
            }

            int j = i + 1;
            int end = j + target.length - 1;
            for (int k = 1; j < end && source[j] == target[k]; j++, k++);

            if (j == end) {
                return i;
            }
        }

        return -1;
    }
}
