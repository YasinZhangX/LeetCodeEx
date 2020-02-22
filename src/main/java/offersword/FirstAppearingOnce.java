package offersword;

import java.util.HashMap;
import java.util.Set;

/**
 * @author Yasin Zhang
 */
public class FirstAppearingOnce {
    HashMap<Character, Long> dict = new HashMap<>();
    static long index = 0;
    //Insert one char from stringstream
    public void insert(char ch)
    {
        if (dict.containsKey(ch)) {
            dict.put(ch, (long) -1);
        } else {
            dict.put(ch, index);

        }
        index++;
    }
    //return the first appearence once char in current stringstream
    public char solution()
    {
        Set<Character> keys = dict.keySet();
        if (keys.size() == 0) {
            return '#';
        }

        char result = '#';
        long min = Long.MAX_VALUE;
        for (Character ch : keys) {
            long i = dict.get(ch);
            if (i != -1 && i < min) {
                result = ch;
                min = i;
            }
        }

        return result;
    }
}
