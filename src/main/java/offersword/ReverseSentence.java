package offersword;

/**
 * @author Yasin Zhang
 */
public class ReverseSentence {
    public String solution(String str) {
        if (str == null || str.trim().equals("")) {
            return str;
        }

        String[] strs = str.split(" ");
        for (int i = 0; i < strs.length / 2; i++) {
            String tmp = strs[i];
            strs[i] = strs[strs.length - i - 1];
            strs[strs.length - i - 1] = tmp;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length-1; i++) {
            sb.append(strs[i]);
            sb.append(" ");
        }
        sb.append(strs[strs.length-1]);

        return sb.toString();
    }
}
