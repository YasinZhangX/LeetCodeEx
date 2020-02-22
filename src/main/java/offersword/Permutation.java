package offersword;

import java.util.*;

/**
 * 字符串的排列
 * @author Yasin Zhang
 */
public class Permutation {
    public ArrayList<String> solution(String str) {
        if (str == null || str.length() == 0) {
            return new ArrayList<>();
        }

        ArrayList<Character> chars = new ArrayList<>(str.length());
        for (char ch : str.toCharArray()) {
            chars.add(ch);
        }
        StringBuilder tmpStr = new StringBuilder();
        TreeSet<String> resultSet = new TreeSet<>();
        innerPermutation(str.length(), tmpStr, chars, resultSet);
        return new ArrayList<>(resultSet);
    }

    private void innerPermutation(int n, StringBuilder tmpStr,
                                  ArrayList<Character> chars,
                                  Set<String> result) {
        if (chars.isEmpty()) {
            result.add(tmpStr.toString());
            return;
        }

        for (Character ch : chars) {
            StringBuilder newStr = new StringBuilder(tmpStr);
            newStr.append(ch);
            ArrayList<Character> newChars = new ArrayList<>(chars);
            newChars.remove(ch);
            innerPermutation(n, newStr, newChars, result);
        }
    }

    public ArrayList<String> solution_better(String str) {
        if (str == null || str.length() == 0) {
            return new ArrayList<String>();
        }

        TreeSet<String> result = new TreeSet<>();
        permutationInline(str.toCharArray(), 0, result);

        return new ArrayList<String>(result);
    }

    private void permutationInline(char[] str, int start, TreeSet<String> result) {
        if (start >= str.length) {
            result.add(new String(str));
        }

        for (int i = start; i < str.length; i++) {
            char tmp = str[i];
            str[i] = str[start];
            str[start] = tmp;

            permutationInline(str, start+1, result);

            tmp = str[i];
            str[i] = str[start];
            str[start] = tmp;
        }
    }
}
