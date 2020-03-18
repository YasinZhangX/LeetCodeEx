package medium;

import sun.font.CreatedFontTracker;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Yasin Zhang
 */
public class LRUCache {
    private LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        Integer result = map.get(key);
        if (result == null) {
            return -1;
        }

        return result;
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}
