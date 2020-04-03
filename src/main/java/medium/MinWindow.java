package medium;

import com.sun.deploy.net.proxy.pac.PACFunctionsImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 最小覆盖子串
 * @author Yasin Zhang
 */
public class MinWindow {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> dict = new HashMap<>();
        for (char ch : t.toCharArray()) {
            int count = dict.getOrDefault(ch, 0);
            dict.put(ch, count+1);
        }

        ArrayList<Pair> pairs = new ArrayList<>();
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (dict.containsKey(str[i])) {
                pairs.add(new Pair(i, str[i]));
            }
        }

        int minSize = Integer.MAX_VALUE;
        int wl = 0;
        int wr = 0;
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> windowCount = new HashMap<>();
        int count = windowCount.getOrDefault(pairs.get(wl).ch, 0);
        windowCount.put(pairs.get(wl).ch, count+1);
        while (wl <= wr && wr < pairs.size()) {
            while (!isContain(windowCount, dict) && wr+1 < pairs.size()) {
                wr++;
                count = windowCount.getOrDefault(pairs.get(wr).ch, 0);
                windowCount.put(pairs.get(wr).ch, count+1);
            }
            if (isContain(windowCount, dict)) {
                if ((pairs.get(wr).index - pairs.get(wl).index) < minSize) {
                    minSize = pairs.get(wr).index - pairs.get(wl).index;
                    left = pairs.get(wl).index;
                    right = pairs.get(wr).index;
                }
                count = windowCount.get(pairs.get(wl).ch);
                if (count-1 <= 0) {
                    windowCount.remove(pairs.get(wl).ch);
                } else {
                    windowCount.put(pairs.get(wl).ch, count-1);
                }
                wl++;
            } else {
                break;
            }
        }

        return minSize == Integer.MAX_VALUE ? "" : s.substring(left, right+1);
    }

    private boolean isContain(HashMap<Character, Integer> windowCount, HashMap<Character, Integer> dict) {
        for (Character ch : dict.keySet()) {
            if (!windowCount.containsKey(ch) || windowCount.get(ch) < dict.get(ch)) {
                return false;
            }
        }

        return true;
    }

    static class Pair {
        int index;
        char ch;

        Pair(int index, char ch) {
            this.index = index;
            this.ch = ch;
        }
    }

    /**
     * 通过计数实现
     */
    public String minWindow2(String s, String t) {
        int[] map = new int[128];
        for(char c : t.toCharArray()) ++map[c];

        char[] ss = s.toCharArray();
        int start = -1, len = Integer.MAX_VALUE;
        int left = 0, right = 0, count = 0;
        while(right < ss.length){
            if(map[ss[right]]-- > 0) ++count;
            right++;
            while(count == t.length()){
                if(right-left < len){
                    len = right-left;
                    start = left;
                }
                if(++map[ss[left]] > 0) --count;
                left++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start+len);
    }
}
