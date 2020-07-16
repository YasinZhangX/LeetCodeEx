package coding.spring;

import java.util.Scanner;

/**
 * @author Yasin Zhang
 */
public class FindCaptain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int mod = (int) (Math.pow(10, 9) + 7);
        long result = solution(n);
        int res = (int) (result % mod);
        System.out.println(res);
    }

    private static long solution(int n) {
        return (long) (n * Math.pow(2, n-1));
    }
}
