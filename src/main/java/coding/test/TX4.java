package coding.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Yasin Zhang
 */
public class TX4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] origin = new int[n];
        int[] tmp = new int[n];
        for(int i = 0; i < n; i++) {
            origin[i] = sc.nextInt();
            tmp[i] = origin[i];
        }

        Arrays.sort(origin);

        int mid = n / 2;
        for (int i = 0; i < n; i++) {
            int temp = Arrays.binarySearch(origin, tmp[i]);
            if (temp < mid) {
                System.out.println(origin[mid]);
            } else {
                System.out.println(origin[mid-1]);
            }
        }
    }
}
