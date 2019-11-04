package primary;

import org.junit.Test;

import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class MerchantAssociationTest {
    int[] prices;
    List<Pair<Integer>>

    @Test
    public void maxProfit() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        prices = new int[n];
        for(int i = 0; i < n; i++) {
            prices[i] = in.nextInt();
        }
        for(int i = 0; i < n-1; i++) {
            prices[i] = in.nextInt();
        }
    }
}
