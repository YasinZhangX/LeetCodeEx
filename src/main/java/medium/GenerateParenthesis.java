package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yasin Zhang
 *
 * 通过回溯法，保证每次向前的时候现有的括号是有效的
 */
public class GenerateParenthesis {
    public List<String> solution(int n) {
        List<String> result = new ArrayList<>();
        backTrack(result, "", 0, 0, n);
        return result;
    }

    private void backTrack(List<String> result, String str, int left, int right, int n) {
        if (str.length() == n * 2) {
            result.add(str);
        }

        if (left < n) {
            backTrack(result, str + "(", left + 1, right, n);
        }
        if (right < left) {
            backTrack(result, str + ")", left, right + 1, n);
        }
    }
}
