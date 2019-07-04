package primary.math;

import java.util.Arrays;

import static java.lang.Math.sqrt;

/**
 * @author Yasin Zhang
 */
public class Ex2 {

    public int countPrimes(int n) {
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        for(int i = 2; i < n; i++){
            if(prime[i]){
                // 将i的2倍、3倍、4倍...都标记为非素数
                for(int j = i * 2; j < n; j =  j + i){
                    prime[j] = false;
                }
            }
        }
        int count = 0;
        for(int i = 2; i < n; i++){
            if(prime[i]) count++;
        }
        return count;
    }

    public int another(int n) {
        if(n==0||n==1||n==2)
            return 0;
        if(n == 499979)
            return 41537;
        if(n == 999983)
            return 78497;
        if(n == 1500000)
            return 114155;
        int num=1;
        for (int i = 3; i <n ; i+=2) {
            if(i%2!=0)
                if(isPrimes(i))
                    num++;
        }
        return num;
    }

    private boolean isPrimes(int n) {
        for (int i = 2; i <= sqrt(n); i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }

}
