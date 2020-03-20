package coding;

/**
 * @author Yasin Zhang
 */
public class CanWinNim {
    public boolean canWinNim(int n) {
        if (n == 1 || n == 2 || n == 3) {
            return true;
        }

        return round(n-1, false)
            || round(n-2, false)
            || round(n-3, false);
    }

    private boolean round(int n, boolean isMe) {
        if (n == 1 || n == 2 || n == 3) {
            return isMe;
        } else if (n <= 0) {
            return !isMe;
        }
        System.out.println("n=" + n + ", isMe=" + isMe);

        return round(n-1, !isMe)
            || round(n-2, !isMe)
            || round(n-3, !isMe);
    }

    public static void main(String[] args) {
        CanWinNim alg = new CanWinNim();
        System.out.println(alg.canWinNim(8));
    }
}
