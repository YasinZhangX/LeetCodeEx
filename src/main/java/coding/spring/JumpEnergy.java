package coding.spring;

import java.util.Scanner;

/**
 * @author Yasin Zhang
 */
public class JumpEnergy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        int max = -1;
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = in.nextInt();
            max = Math.max(max, h[i]);
        }

        double E = 0;
        for (int i = n-1; i >= 0; i--) {
            E = (E + h[i]) / 2;
        }
        int result = (int) Math.ceil(E);

        System.out.println(result);
    }
}
