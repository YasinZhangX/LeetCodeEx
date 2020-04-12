package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yasin Zhang
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        for (String p : wordDict) {
            s = s.replaceAll(p, "");
            if (s.length() == 0) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        WordBreak alg = new WordBreak();
        String s = "cars";
        ArrayList<String> dict = new ArrayList<>();
        dict.add("car");
        dict.add("ca");
        dict.add("rs");
        System.out.println(alg.wordBreak(s, dict));
    }
}
