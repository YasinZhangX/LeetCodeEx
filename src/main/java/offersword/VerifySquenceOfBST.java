package offersword;

/**
 * 二叉搜索树的后序遍历序列
 * @author Yasin Zhang
 */
public class VerifySquenceOfBST {
    public boolean solution(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }

        return innerVerify(sequence, 0, sequence.length-1);
    }

    private boolean innerVerify(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }

        int root = sequence[end];
        int i = end;
        while (i > start && sequence[i-1] > root) {
            i--;
        }

        for (int j = start; j < i; j++) {
            if (sequence[j] > root) {
                return false;
            }
        }

        return innerVerify(sequence, start, i-1) && innerVerify(sequence, i, end-1);
    }
}
