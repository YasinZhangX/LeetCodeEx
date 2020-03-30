package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 发 leetcoin
 * @author Yasin Zhang
 */
public class Bonus {
    public int[] bonus(int n, int[][] leadership, int[][] operations) {
        ArrayList<Integer> resultlist = new ArrayList<>();
        HashMap<Integer, HashSet<Integer>> relationships = new HashMap<>();

        for (int[] ints : leadership) {
            int a = ints[0];
            int b = ints[1];
            HashSet<Integer> subs = relationships.get(a);
            if (subs == null) {
                subs = new HashSet<>();
            }
            subs.add(b);
            relationships.put(a, subs);

//            subs = relationships.get(b);
//            if (subs == null) {
//                subs = new HashSet<>();
//            }
//            relationships.put(b, subs);
        }

        int[] bonus = new int[n];
        for (int[] operation : operations) {
            int opraType = operation[0];
            int opraNum = operation[1];
            switch (opraType) {
                case 1:
                    bonus[opraNum-1] += operation[2];
                    break;

                case 2:
                    opration2(opraNum, operation[2], relationships, bonus);
                    break;

                case 3:
                    int[] sum = new int[1];
                    opration3(opraNum, bonus, sum, relationships);
                    resultlist.add(sum[0]);
                    break;

                default:
                    break;
            }
        }

        int[] result = new int[resultlist.size()];
        for (int i = 0; i < resultlist.size(); i++) {
            result[i] = resultlist.get(i);
        }
        return result;
    }

    private void opration2(int opraNum, int coins,
                           HashMap<Integer, HashSet<Integer>> relationships, int[] bonus) {
        bonus[opraNum-1] = bonus[opraNum-1] + coins;

        HashSet<Integer> subs = relationships.get(opraNum);
        if (subs == null) {
            return;
        }

        for (int sub : subs) {
            opration2(sub, coins, relationships, bonus);
        }
    }

    private void opration3(int opraNum, int[] bonus, int[] sum,
                          HashMap<Integer, HashSet<Integer>> relationships) {
        int mod = 1000000007;
        long tmp = sum[0];
        tmp = tmp + bonus[opraNum-1];
        sum[0] = (int) (tmp % mod);

        HashSet<Integer> subs = relationships.get(opraNum);
        if (subs == null) {
            return;
        }

        for (int sub : subs) {
            opration3(sub, bonus, sum, relationships);
        }
    }
}
