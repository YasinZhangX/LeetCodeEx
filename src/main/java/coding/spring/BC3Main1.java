package coding.spring;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Yasin Zhang
 */
public class BC3Main1 {
    static String cur = "";
    static Stack<String> mem = new Stack<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            int opra = Integer.parseInt(line.substring(0, 1));
            if (opra == 1) {
                add(line.substring(2));
            } else if (opra == 2) {
                remove(Integer.parseInt(line.substring(2)));
            } else if (opra == 3) {
                print(Integer.parseInt(line.substring(2)));
            } else if (opra == 4) {
                rollback();
            }
        }
    }

    private static void add(String s) {
        mem.push(cur);
        cur = cur + s;
    }

    private static void remove(int k) {
        mem.push(cur);
        int len = cur.length();
        if (k >= len) {
            cur = "";
        } else {
            cur = cur.substring(0, len - k);
        }
    }

    private static void print(int k) {
        System.out.println(cur.charAt(k-1));
    }

    private static void rollback() {
        cur = mem.pop();
    }
}
