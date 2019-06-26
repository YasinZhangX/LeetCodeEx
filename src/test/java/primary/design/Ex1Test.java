package primary.design; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* Ex1 Tester. 
* 
* @author <Authors name> 
* @since <pre>June 25, 2019</pre>
* @version 1.0 
*/ 
public class Ex1Test {

    Ex1 ex1;

    private int[] nums = {1, 2, 3};
    private int[] result;


    @Before
    public void before() throws Exception {
        ex1 = new Ex1(nums);
    } 
    
    @After
    public void after() throws Exception {
        for (int i : result) {
            System.out.println(i);
        }
    } 

    /** 
    * Method: reset() 
    */ 
    @Test
    public void testReset() throws Exception { 
        result = ex1.reset();
    } 

    /** 
    * Method: shuffle() 
    */ 
    @Test
    public void testShuffle() throws Exception { 
        result = ex1.shuffle();
    }


    @Test
    public void testShuffle_best() throws Exception {
        result = ex1.shuffle_best();
    }
}
