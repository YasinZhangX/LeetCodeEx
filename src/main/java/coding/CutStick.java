package coding;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Yasin Zhang
 */
public class CutStick {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        int[] stick = new int[n];
        for (int i = 0; i < n; i++) {
            stick[i] = in.nextInt();
        }

        int result = solution(stick);
        System.out.println(result);
    }

    private static int solution(int[] stick) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = stick.length-1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(stick[i]);
            } else {
                int top = stack.peek();
                if (top < stick[i]) {
                    int cut = (stick[i] - 1) / top;
                    result = result + cut;
                    stack.push((stick[i]/(cut+1)));
                }
            }
        }

        return result;
    }
}
