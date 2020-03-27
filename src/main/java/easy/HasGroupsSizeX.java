package easy;

import java.util.HashMap;

/**
 * @author Yasin Zhang
 */
public class HasGroupsSizeX {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck == null || deck.length <= 1) {
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : deck) {
            Integer counter = map.get(i);
            if (counter == null) {
                counter = 1;
            } else {
                counter = counter + 1;
            }
            map.put(i, counter);
        }

        int m = -1;
        for (Integer k : map.keySet()) {
            if (m == -1) {
                m = map.get(k);
            } else {
                m = gcd(m, map.get(k));
            }
            if (m < 2) {
                break;
            }
        }

        return (m >= 2);
    }

    private int gcd(int a, int b) {
        if (a >= b) {
            return b != 0 ? gcd(b, a%b) : a;
        } else {
            return a != 0 ? gcd(a, b%a) : b;
        }
    }
}
