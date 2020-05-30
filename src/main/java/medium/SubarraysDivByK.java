package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Yasin Zhang
 */
public class SubarraysDivByK {
    public int subarraysDivByK(int[] A, int K) {
        HashMap<Integer, List<Integer>> modIndex = new HashMap<>();
        List<Integer> indexList = new ArrayList<>();
        indexList.add(-1);
        modIndex.put(0, indexList);

        int res = 0;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = sum + A[i];

            if (sum < 0) {
                sum = (sum % K + K) % K;
            }
            if (K != 0) {
                sum = sum % K;
            }
            List<Integer> curIndexList = modIndex.get(sum);
            if (curIndexList != null) {
                res += curIndexList.size();
                curIndexList.add(i);
            } else {
                curIndexList = new ArrayList<>();
                curIndexList.add(i);
                modIndex.put(sum, curIndexList);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        SubarraysDivByK alg = new SubarraysDivByK();
        int[] A = {7,4,-10};
        int k = 5;
        int result = alg.subarraysDivByK(A, k);
        System.out.println(result);
    }
}
