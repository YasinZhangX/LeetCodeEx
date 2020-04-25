package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Yasin Zhang
 */
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bans = new HashSet<>(Arrays.asList(banned));
        HashMap<String, Integer> count = new HashMap<>();

        int max = 0;
        String res = "";
        paragraph = paragraph + ".";
        StringBuilder builder = new StringBuilder();
        for (Character c : paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                builder.append(Character.toLowerCase(c));
            } else if (builder.length() > 0) {
                String word = builder.toString();
                if (!bans.contains(word)) {
                    int times = count.getOrDefault(word, 0) + 1;
                    if (times > max) {
                        max = times;
                        res = word;
                    }
                    count.put(word, times);
                }
                builder = new StringBuilder();
            }
        }

        return res;
    }
}
