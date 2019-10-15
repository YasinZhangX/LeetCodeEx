package medium;

/**
 * @author Yasin Zhang
 */
public class ZConvert {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        int partSize = 2 * numRows - 2;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int j = 0;
            int index = partSize * j + i;
            while(index < s.length()) {
                sb.append(s.charAt(index));
                int tmpIndex = partSize * j * 2 + partSize - index;
                if (tmpIndex < s.length() && tmpIndex < (partSize * (j+1) + i)
                    && tmpIndex != index) {
                    sb.append(s.charAt(tmpIndex));
                }

                j++;
                index = partSize * j + i;
            }
        }

        return sb.toString();
    }
}
