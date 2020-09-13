package coding.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Yasin Zhang
 */
public class Wangyi2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            System.out.println(solution(s));
        }
    }

    public static int solution(String s) {
        int[] stateIndex = new int[64];
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

    private static int changeState(int state, char ch) {
        switch (ch) {
            case 'a':
                state = state ^ 0x20;
                break;

            case 'b':
                state = state ^ 0x10;
                break;

            case 'c':
                state = state ^ 0x08;
                break;

            case 'x':
                state = state ^ 0x04;
                break;

            case 'y':
                state = state ^ 0x02;
                break;

            case 'z':
                state = state ^ 0x01;
                break;

            default:
                break;
        }

        return state;
    }
}
