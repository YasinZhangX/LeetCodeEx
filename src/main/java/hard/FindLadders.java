package hard;

import java.util.*;

/**
 * 单词接龙 II
 * @author Yasin Zhang
 */
public class FindLadders {
    private List<List<String>> res = new ArrayList<>();
    private ArrayList<Node> nodeList = new ArrayList<>();
    private HashMap<String, Integer> wordIndex = new HashMap<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return res;
        }

        wordSet.add(beginWord);
        for (String word : wordSet) {
            Node cur = new Node(word);
            for (Node node : nodeList) {
                if (transformCheck(node.getWord(), word)) {
                    node.addNeighbor(cur.getId());
                    cur.addNeighbor(node.getId());
                }
            }
            nodeList.add(cur);
            wordIndex.put(word, cur.getId());
        }

        Node start = nodeList.get(wordIndex.get(beginWord));
        start.setCost(0);
        Node end = nodeList.get(wordIndex.get(endWord));
        bfs(start, end);

        return res;
    }

    private void bfs(Node start, Node end) {
        Queue<ArrayList<Node>> q = new LinkedList<>();
        ArrayList<Node> tmp = new ArrayList<>();
        tmp.add(start);
        q.add(tmp);
        while (!q.isEmpty()) {
            ArrayList<Node> curPath = q.poll();
            Node cur = curPath.get(curPath.size()-1);
            if (cur.equals(end)) {
                ArrayList<String> path = new ArrayList<>(curPath.size());
                for (Node n : curPath) {
                    path.add(n.getWord());
                }
                res.add(path);
            } else {
                for (Integer neighborIndex : cur.getNeighbors()) {
                    Node neighbor = nodeList.get(neighborIndex);
                    int neighborCost = neighbor.getCost();
                    if (cur.getCost() + 1 <= neighborCost) {
                        neighbor.setCost(cur.getCost() + 1);
                        ArrayList<Node> copy = new ArrayList<>(curPath);
                        copy.add(neighbor);
                        q.add(copy);
                    }
                }
            }
        }
    }

    private boolean transformCheck(String str1, String str2) {
        int differences = 0;
        for (int i = 0; i < str1.length() && differences < 2; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                ++differences;
            }
        }
        return differences == 1;
    }

    static class Node {
        static int i = 0;
        private final int id = i++;
        private final String word;
        private final HashSet<Integer> neighborSet = new HashSet<>();
        private int cost;

        Node(String word) {
            this.word = word;
            this.cost = Integer.MAX_VALUE;
        }

        public int getId() {
            return this.id;
        }

        public String getWord() {
            return this.word;
        }

        public Set<Integer> getNeighbors() {
            return this.neighborSet;
        }

        public int getCost() {
            return this.cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public void addNeighbor(int i) {
            neighborSet.add(i);
        }

        public boolean equals(Node obj) {
            return obj.getId() == this.getId();
        }

        @Override
        public String toString() {
            return this.word;
        }
    }
}
