package Utils;

/**
 * 组合数求法
 * @author Yasin Zhang
 */
public class Combination {
    public static long normalC(long n, long m, long p) {
        if (m == 0) {
            return 1;
        }

        long res = 1;
        for (int i = 1; i <= m; i++) {
            res = res * (n - m + i) / i;
            res %= p;
        }

        return res;
    }

    public static void main(String[] args) {
        long a = normalC(4, 2, 100);
        System.out.println(a);
    }
/*
    // 快速求解组合数，从 n 里面选 m 的可能性，对 p 进行取模
    public long C(long n, long m, long p) {
        if (m > n) {
            return  0;
        }

        long x = 1;
        long y = 1;
        while (m != 0) {
            x = (x * n) % p;
            y = (y * m) % p;
            n--;
            m--;
        }

        return x * quickpow(y, p-2, 1) % p;
    }

    // 组合数公式
    public long lucas(long n, long m, long p) {
        if (m == 0) {
            return 1;
        }

        return C(n%p, m%p, p) * lucas(n/p, m/p, p) % p;
    }


    // A Lucas Theorem based solution to compute nCr % p
    class GFG{
        // Returns nCr % p. In this Lucas Theorem based program,
        // this function is only called for n < p and r < p.
        static int nCrModpDP(int n, int r, int p)
        {
            // The array C is going to store last row of
            // pascal triangle at the end. And last entry
            // of last row is nCr
            int[] C=new int[r+1];

            C[0] = 1; // Top row of Pascal Triangle

            // One by constructs remaining rows of Pascal
            // Triangle from top to bottom
            for (int i = 1; i <= n; i++)
            {
                // Fill entries of current row using previous
                // row values
                for (int j = Math.min(i, r); j > 0; j--)

                    // nCj = (n-1)Cj + (n-1)C(j-1);
                    C[j] = (C[j] + C[j-1])%p;
            }
            return C[r];
        }

        // Lucas Theorem based function that returns nCr % p
        // This function works like decimal to binary conversion
        // recursive function. First we compute last digits of
        // n and r in base p, then recur for remaining digits
        static int nCrModpLucas(int n, int r, int p)
        {
            // Base case
            if (r==0)
                return 1;

            // Compute last digits of n and r in base p
            int ni = n%p;
            int ri = r%p;

            // Compute result for last digits computed above, and
            // for remaining digits. Multiply the two results and
            // compute the result of multiplication in modulo p.
            return (nCrModpLucas(n/p, r/p, p) * // Last digits of n and r
                nCrModpDP(ni, ri, p)) % p; // Remaining digits
        }

        // Driver program
        public static void main(String[] args)
        {
            int n = 1000, r = 900, p = 13;
            System.out.println("Value of nCr % p is "+nCrModpLucas(n, r, p));
        }
    }
    // This code is contributed by mits
*/

}
