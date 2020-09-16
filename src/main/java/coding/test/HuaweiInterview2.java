package coding.test;

/**
 * @author Yasin Zhang
 */
public class HuaweiInterview2 {
    public static void main(String[] args) {
        String a = "7810";
        String b = "0111";
        System.out.println(solution(a, b));
    }
    private static String solution(String secret, String guess) {
        int ACount = 0;
        int BCount = 0;
        int[] secretCount = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int k = secret.charAt(i) - '0';
            secretCount[k]++;
        }
        for (int i = 0; i < guess.length(); i++) {
            int k = guess.charAt(i) - '0';
            if (secretCount[k] > 0) {
                secretCount[k]--;
                BCount++;
            }
            if (secret.charAt(i) == guess.charAt(i)) {
                BCount--;
                ACount++;
            }
        }
        return ACount + "A" + BCount + "B";
    }
}
