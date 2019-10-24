package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Yasin Zhang
 */
public class LetterCombination {
    private HashMap<String, String> digitMap = new HashMap<>();
    private List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        initPhone();
        if (digits.length() > 0) {
            backTrack("", digits);
        }

        return result;
    }

    private void initPhone() {
        digitMap.put("2", "abc");
        digitMap.put("3", "def");
        digitMap.put("4", "ghi");
        digitMap.put("5", "jkl");
        digitMap.put("6", "mno");
        digitMap.put("7", "pqrs");
        digitMap.put("8", "tuv");
        digitMap.put("9", "wxyz");
    }

    private void backTrack(String combine, String digits) {
        if (digits.length() == 0) {
            result.add(combine);
        } else {
            String curDigit = digits.substring(0, 1);
            String curLetters = digitMap.get(curDigit);
            for (char c : curLetters.toCharArray()) {
                backTrack(combine + c, digits.substring(1));
            }
        }
    }
}
