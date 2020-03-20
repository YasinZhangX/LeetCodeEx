package coding;

import java.util.Scanner;

/**
 * @author Yasin Zhang
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        for (int i = L; i <= 100; i++) {
            int t = 2 * N - i * i + i;
            if ((t % (2*i)) == 0) {
                int start = t / (2*i);
                for (int j = 0; j < i-1; j++) {
                    System.out.print(start+j+" ");
                }
                System.out.print(start+i-1);
                return;
            }
        }

        System.out.print("No");
    }
}
