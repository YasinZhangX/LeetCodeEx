package hard;

import java.util.ArrayList;

/**
 * @author Yasin Zhang
 */
public class NumberToWords {
    String[] partsName = {"", "Thousand", "Million", "Billion"};
    String[] numbers = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] tensNum = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
        "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] overTenNum = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
        "Eighty", "Ninety"};
    String HUNDRED = "Hundred";

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        ArrayList<Integer> parts = new ArrayList<>();
        while (num != 0) {
            parts.add(num % 1000);
            num = num / 1000;
        }

        String[] partWords = getPartWords(parts);
        StringBuilder result = new StringBuilder(partWords[0]);
        for (int i = 1; i < partWords.length; i++) {
            if (!partWords[i].equals("")) {
                result.insert(0, partWords[i] + partsName[i] + " ");
            }
        }

        return result.toString().trim();
    }

    private String[] getPartWords(ArrayList<Integer> parts) {
        String[] res = new String[parts.size()];

        for (int i = 0; i < parts.size(); i++) {
            int cur = parts.get(i);
            int d0 = cur % 10;
            int d1 = cur / 10 % 10;
            int d2 = cur / 100;

            StringBuilder sb = new StringBuilder();
            if (d2 != 0) {
                sb.append(numbers[d2]);
                sb.append(" ");
                sb.append(HUNDRED);
                sb.append(" ");
            }

            if (d1 == 1) {
                sb.append(tensNum[d0]);
                sb.append(" ");
            } else {
                if (d1 > 1) {
                    sb.append(overTenNum[d1]);
                    sb.append(" ");
                }

                if (d0 != 0) {
                    sb.append(numbers[d0]);
                    sb.append(" ");
                }
            }

            res[i] = sb.toString();
        }

        return res;
    }

    public String numberToWords_better(int num) {
        StringBuilder sb = new StringBuilder();
        String[] nums = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] tens = {"Ten", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        int bs = num / 1000000000;
        if (bs > 0) {
            sb.append(numberToWords(bs)).append(" Billion ");
            num = num % 1000000000;
        }
        int ms = num / 1000000;
        if (ms > 0) {
            sb.append(numberToWords(ms)).append(" Million ");
            num = num % 1000000;
        }
        int ts = num / 1000;
        if (ts > 0) {
            sb.append(numberToWords(ts)).append(" Thousand ");
            num = num % 1000;
        }
        int hs = num / 100;
        if (hs > 0) {
            sb.append(nums[hs]).append(" Hundred ");
            num = num % 100;
        }
        int tns = num / 10;
        if (tns > 1) {
            sb.append(tens[tns]);
            num = num % 10;
            if (num != 0) {
                sb.append(" ").append(nums[num]);
            }
        } else if (tns == 1) {
            if (num % 10 == 0) {
                if (sb.length() == 0 && num == 0) {
                    sb.append(nums[num]);
                } else {
                    sb.append(tens[num % 10]);
                }
            } else {
                sb.append(teens[num % 10]);
            }
        } else if (tns == 0) {
            num = num % 10;
            if (num == 0) {
                if (sb.length() == 0) {
                    sb.append(nums[num]);
                }
            } else {
                sb.append(nums[num]);
            }
        }
        return sb.toString().trim();
    }
}
