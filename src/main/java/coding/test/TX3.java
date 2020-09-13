package coding.test;

import java.util.*;

/**
 * @author Yasin Zhang
 */
public class TX3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        TreeMap<String ,Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            map.put(line, map.getOrDefault(line, 0) + 1);
        }

        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((o1, o2) -> o1.getValue().equals(o2.getValue()) ?
            (o1.getKey()).compareTo(o2.getKey()) : o2.getValue() - o1.getValue());

        for (int i = 0; i < m ; i++) {
            System.out.println(entries.get(i).getKey() +" " + entries.get(i).getValue());
        }

        entries.sort((o1, o2) -> o1.getValue().equals(o2.getValue()) ?
            (o1.getKey()).compareTo(o2.getKey()) : o1.getValue() - o2.getValue());

        for (int i = 0; i < m ; i++) {
            System.out.println(entries.get(i).getKey() +" " + entries.get(i).getValue());
        }
    }
}
