package coding.practice;

import java.util.HashSet;

/**
 * @author Yasin Zhang
 */
public class GetPasswordsNumber {
    public int solution(String initPasswd) {
        if (initPasswd.length() == 1) {
            return 10;
        } else if (initPasswd.length() == 0) {
            return 0;
        }

        HashSet<String> dict = new HashSet<>();
        dict.add(initPasswd);

        for (int i = 0; i <= 9; i++) {
            helper(dict, new StringBuilder().append(i), i, 1, initPasswd);
        }

        return dict.size() - 1;
    }

    private void helper(HashSet<String> dict, StringBuilder builder, int pre, int index, String initPasswd) {
        if (initPasswd.length() <= index) {
            dict.add(builder.toString());
            return;
        }

        int cur = initPasswd.charAt(index) - '0';
        int result = (pre + cur) / 2;
        if (result * 2 == (pre + cur)) {
            helper(dict, new StringBuilder(builder.append(result)), result, index + 1, initPasswd);
        } else {
            StringBuilder tmp = new StringBuilder(builder);
            helper(dict, new StringBuilder(builder.append(result)), result, index + 1, initPasswd);
            helper(dict, new StringBuilder(tmp.append(result+1)), result+1, index + 1, initPasswd);
        }
    }
}
