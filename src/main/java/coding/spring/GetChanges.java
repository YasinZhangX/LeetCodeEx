package coding.spring;

import java.util.Scanner;

/**
 * @author Yasin Zhang
 */
public class GetChanges {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int remain = 1024 - n;
        int n64 = remain / 64;
        remain = remain % 64;
        int n16 = remain / 16;
        remain = remain % 16;
        int n4 = remain / 4;
        remain = remain % 4;
        int n1 = remain;

        System.out.println(n64 + n16 + n4 + n1);
    }
}
