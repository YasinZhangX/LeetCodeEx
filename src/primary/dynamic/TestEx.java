package primary.dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tools.Print.*;

class TestEx {
    int prices[] = {2,1,2,0,1};
    
    int nums[] = {2, 3};
    
    Ex2 ex2 = null;
    Ex3 ex3 = null;
    Ex4 ex4 = null;
    
    //@BeforeEach
    void beforeEx2() {
        ex2 = new Ex2();
        printnb("Current price is ");
        printInt(prices);
    }
    
    //@BeforeEach
    void beforeEx3() {
        ex3 = new Ex3();
        printnb("Current nums is ");
        printInt(nums);
    }
    
    @BeforeEach
    void beforeEx4() {
        ex4 = new Ex4();
        printnb("Current nums is ");
        printInt(nums);
    }

    //@Test
    void testEx2() {
        int profit = ex2.maxProfit(prices);
        print("Max profit is " + profit);
    }
    
    //@Test
    void testEx3() {
        int maxSum = ex3.maxSubArray_best(nums);
        print("Max subSum is " + maxSum);
        assertEquals(-1, maxSum);
    }
    
    @Test
    void testEx4() {
        int robNum = ex4.rob(nums);
        print("Rob is " + robNum);
    }
}
