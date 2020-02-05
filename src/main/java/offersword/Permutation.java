package offersword;

import java.util.*;

/**
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
}
