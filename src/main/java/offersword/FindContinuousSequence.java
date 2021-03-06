package offersword;

import java.util.ArrayList;

/**
 * @author Yasin Zhang
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> solution(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (sum < 3) {
            return result;
        }

        int start = 1;
        int end = 2;
        int mid = (1 + sum) / 2;
        int curSum = 3;

        while (start < end) {
            if (curSum == sum) {
                ArrayList<Integer> list = new ArrayList<>(end - start + 1);
                for (int i = start; i <= end; i++) {
                    list.add(i);
                }
                result.add(list);
            }

            end++;
            curSum = curSum + end;

            while (curSum > sum) {
                curSum = curSum - start;
                start++;
            }
        }

        return result;
    }

    public ArrayList<ArrayList<Integer> > s(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum < 3) {
            return result;
        }

        int start = 1;
        int end = 2;
        int mid = (1+sum) / 2;
        int curSum = 3;

        while (start < end && end <= mid) {
            if (curSum == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    list.add(i);
                }
                result.add(list);

                end++;
                curSum = curSum + end;
            } else if (curSum < sum) {
                end++;
                curSum = curSum + end;
            } else {
                curSum = curSum - start;
                start++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindContinuousSequence alg = new FindContinuousSequence();
        System.out.println(alg.s(5));
    }
}
