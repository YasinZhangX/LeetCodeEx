package primary.math;

/**
 * @author Yasin Zhang
 */
public class Ex3 {

    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }

        double num = Math.log10(n) / Math.log10(3);
        return (num%1 == 0);
    }

}
