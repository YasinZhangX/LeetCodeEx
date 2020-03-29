package easy;

/**
 * 1比特与2比特字符
 * @author Yasin Zhang
 */
public class isOneBitCharacter {
    public boolean solution(int[] bits) {
        if (bits == null || bits.length == 0) {
            return false;
        }

        return isValid(bits, bits.length - 2);
    }

    private boolean isValid(int[] bits, int i) {
        if (i < 0) {
            return true;
        }

        if (bits[i] == 1) {
            return (i-1 >= 0) && (bits[i-1] == 1) && isValid(bits, i-2);
        } else {
            return isValid(bits, i-1)
                || ((i-1 >= 0) && (bits[i-1] == 1) && isValid(bits, i-2));
        }
    }
}
