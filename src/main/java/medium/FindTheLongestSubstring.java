package medium;

import java.util.Arrays;

/**
 * @author Yasin Zhang
 */
public class FindTheLongestSubstring {
    public int findTheLongestSubstring(String s) {
        int[] stateIndex = new int[32];
        Arrays.fill(stateIndex, Integer.MAX_VALUE);
        stateIndex[0] = -1;

        char[] str = s.toCharArray();
        int state = 0;
        int size = str.length;
        int res = 0;
        for (int i = 0; i < size; i++) {
            state = changeState(state, str[i]);
            if (stateIndex[state] != Integer.MAX_VALUE) {
                res = Math.max(res, i - stateIndex[state]);
            } else {
                stateIndex[state] = i;
            }
        }

        return res;
    }

    private boolean stateChanged = true;
    private int changeState(int state, char ch) {
        stateChanged = true;
        switch (ch) {
            case 'a':
                state = state ^ 0x10;
                break;

            case 'e':
                state = state ^ 0x08;
                break;

            case 'i':
                state = state ^ 0x04;
                break;

            case 'o':
                state = state ^ 0x02;
                break;

            case 'u':
                state = state ^ 0x01;
                break;

            default:
                stateChanged = false;
                break;
        }

        return state;
    }

    public static void main(String[] args) {
        FindTheLongestSubstring alg = new FindTheLongestSubstring();
        int result = alg.findTheLongestSubstring("eleetminicoworoep");
        System.out.println(result);
    }
}
