package coding.spring;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 或与加
 * @author Yasin Zhang
 */
public class OrAnd {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long x = in.nextLong();
        long k = in.nextLong();

        int i = 0;
        ArrayList<Integer> zeroIndex = new ArrayList<>();
        while (x != 0) {
            if ((x & 1) == 0) {
                zeroIndex.add(i);
            }
            i++;
            x = x >>> 1;
        }

        long result = 0;
        int j = 0;
        while (k != 0 && j < zeroIndex.size()) {
            long tmp = k;
            if ((tmp & (1 << j)) != 0) {
                result = result | (1 << zeroIndex.get(j));
                k = k - (1 << j);
            }
            j++;
        }

        k >>>= zeroIndex.size();
        result |= k << i;

        System.out.println(result);
    }
}
