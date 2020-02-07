package offersword;

/**
 * 丑数
 * @author Yasin Zhang
 */
public class GetUglyNumber {
    public int solution(int index) {
        if (index < 7) {
            return index;
        }

        int [] ugly = new int [index];
        ugly[0] = 1;
        int min = 1;
        int m2 = 0;
        int m3 = 0;
        int m5 = 0;
        for(int i = 1; i < index; i++) {
            ugly[i] = Math.min(ugly[m2]*2, Math.min(ugly[m3]*3, ugly[m5]*5));
            if (ugly[i] == ugly[m2]*2)
                m2++;
            if (ugly[i] == ugly[m3]*3)
                m3++;
            if (ugly[i] == ugly[m5]*5)
                m5++;
        }

        return ugly[index-1];
    }
}
