package coding.test;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author Yasin Zhang
 */
public class YiTUTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K1 = sc.nextInt();
        int K2 = sc.nextInt();
        int[] money = new int[3];
        money[0] = sc.nextInt();
        money[1] = sc.nextInt();
        money[2] = sc.nextInt();

        List<Price> prices = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int[] good = new int[3];
            good[0] = sc.nextInt();
            good[1] = sc.nextInt();
            good[2] = sc.nextInt();
            int up = sc.nextInt();
            int cost = good[0] * 17 * 29 + good[1] * 29 + good[2];
            double average = up * 1.0 / cost;
            Price price = new Price(good, cost, up, average);
            prices.add(price);
        }

        System.out.println(Arrays.toString(solution(prices, money, K1, K2)));
    }

    private static int[] solution(List<Price> prices, int[] money, int K1, int K2) {
        int need = K1 - K2;
        if (need <= 0) {
            return money;
        }

        prices.sort((o1, o2) -> (int) (o2.average - o1.average));

        int sum = 0;
        for (Price price : prices) {
            sum += price.up;
            useMoney(money, price.good);
            if (sum > need) {
                break;
            }
        }

        return money;
    }

    private static void useMoney(int[] money, int[] good) {
        money[0] -= good[0];
        money[1] -= good[1];
        money[2] -= good[2];
    }

    static class Price {
        int[] good;
        int cost;
        int up;
        double average;

        Price(int[] good, int cost, int up, double average) {
            this.good = good;
            this.cost = cost;
            this.up  = up;
            this.average = average;
        }
    }
}
