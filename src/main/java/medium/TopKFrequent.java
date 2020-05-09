package medium;

import java.util.*;

/**
 * @author Yasin Zhang
 */
public class TopKFrequent {
    public List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length == 0 || k == 0) {
            return new ArrayList<>();
        }

        HashMap<String, Integer> dict = new HashMap<>();
        for (String word : words) {
            Integer freq = dict.getOrDefault(word, 0);
            dict.put(word, freq+1);
        }

        PriorityQueue<FreqWord> maxHeap = new PriorityQueue<>(k, new Comparator<FreqWord>() {
            @Override
            public int compare(FreqWord o1, FreqWord o2) {
                if (o1.freq > o2.freq) {
                    return -1;
                } else if (o1.freq < o2.freq) {
                    return 1;
                } else {
                    return o1.word.compareTo(o2.word);
                }
            }
        });
        for (String word : dict.keySet()) {
            maxHeap.add(new FreqWord(word, dict.get(word)));
        }

        ArrayList<String> result = new ArrayList<>();
        while (result.size() < k) {
            result.add(Objects.requireNonNull(maxHeap.poll()).word);
        }

        return result;
    }

    static class FreqWord {
        String word;
        Integer freq;

        FreqWord(String word, Integer freq) {
            this.freq = freq;
            this.word = word;
        }
    }
}
