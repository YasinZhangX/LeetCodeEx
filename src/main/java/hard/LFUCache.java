package hard;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @author Yasin Zhang
 */
public class LFUCache {

    HashMap<Integer, Node> cache;
    HashMap<Integer, DLinkedList> freqMap = new HashMap<>();
    int minFreq = Integer.MAX_VALUE;
    int size = 0;
    int capacity;

    public LFUCache(int capacity) {
        cache = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            DLinkedList freqList = freqMap.get(node.freq);
            freqList.removeNode(node);
            node.freq = node.freq + 1;
            DLinkedList newFreqList = freqMap.get(node.freq);
            if (newFreqList == null) {
                newFreqList = new DLinkedList();
                freqMap.put(node.freq, newFreqList);
            }
            newFreqList.addNode(node);

            if (minFreq == node.freq-1 && freqList.head.next == freqList.tail) {
                minFreq = node.freq;
            }

            return node.value;
        }
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        Node node = cache.get(key);
        if (node == null) {
            if (size == capacity) {
                DLinkedList freqList = freqMap.get(minFreq);
                cache.remove(freqList.tail.pre.key);
                freqList.removeNode(freqList.tail.pre);
                size--;
            }

            node = new Node(key, value);
            cache.put(key, node);
            minFreq = 1;
            size++;

            DLinkedList newFreqList = freqMap.get(node.freq);
            if (newFreqList == null) {
                newFreqList = new DLinkedList();
                freqMap.put(node.freq, newFreqList);
            }
            newFreqList.addNode(node);
        } else {
            node.value = value;

            DLinkedList freqList = freqMap.get(node.freq);
            freqList.removeNode(node);
            node.freq = node.freq + 1;
            if (minFreq == node.freq-1 && freqList.head.next == freqList.tail) {
                minFreq = node.freq;
            }
            DLinkedList newFreqList = freqMap.get(node.freq);
            if (newFreqList == null) {
                newFreqList = new DLinkedList();
                freqMap.put(node.freq, newFreqList);
            }
            newFreqList.addNode(node);
        }
    }

    static class Node {
        int key;
        int value;
        int freq;
        Node next;
        Node pre;

        Node() {}

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    static class DLinkedList {
        Node head;
        Node tail;

        DLinkedList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
        }

        public void addNode(Node node) {
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
            node.pre = head;
        }

        public void removeNode(Node node) {
            node.next.pre = node.pre;
            node.pre.next = node.next;
        }
    }
}
