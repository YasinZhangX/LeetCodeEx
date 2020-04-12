package coding;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Yasin Zhang
 */
public class HowtoHu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] cards = new int[9];
        for (int i = 0; i < 13; i++) {
            int k = in.nextInt();
            cards[k-1]++;
        }

        ArrayList<Integer> results = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (cards[i] < 4) {
                int[] copy = cards.clone();

                copy[i]++;
                if (canHu(copy, 14, false)) {
                    results.add(i+1);
                }
            }
        }

        if (results.isEmpty()) {
            System.out.println(0);
        } else {
            for (int i = 0; i < results.size() - 1; i++) {
                System.out.print(results.get(i) + " ");
            }
            System.out.println(results.get(results.size()-1));
        }
    }

    private static boolean canHu(int[] cards, int nums, boolean hasHead) {
        if (nums == 0) {
            return true;
        }

        if (hasHead) {
            for (int i = 0; i < 9; i++) {
                if (cards[i] >= 3) {
                    cards[i] -= 3;
                    if (canHu(cards, nums-3, true)) {
                        return true;
                    }
                    cards[i] += 3;
                } else if (i < 7 && cards[i] > 0 && cards[i+1] > 0 && cards[i+2] > 0) {
                    cards[i] -= 1;
                    cards[i+1] -= 1;
                    cards[i+2] -= 1;
                    if (canHu(cards, nums-3, true)) {
                        return true;
                    }
                    cards[i] += 1;
                    cards[i+1] += 1;
                    cards[i+2] += 1;
                }
            }
        } else {
            for (int i = 0; i < 9; i++) {
                if (cards[i] >= 2) {
                    cards[i] -= 2;
                    if (canHu(cards, nums-2, true)) {
                        return true;
                    }
                    cards[i] += 2;
                }
            }
        }

        return false;
    }
}
