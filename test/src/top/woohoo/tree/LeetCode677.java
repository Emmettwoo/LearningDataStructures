package top.woohoo.tree;

import java.util.TreeMap;

public class LeetCode677 {

    /**
     * Your LeetCode677 object will be instantiated and called as such:
     * LeetCode677 obj = new LeetCode677();
     * obj.insert(key,val);
     * int param_2 = obj.sum(prefix);
     */

    private static class Node {
        public int value;
        public TreeMap<Character, Node> next;

        public Node(int value) {
            this.value = value;
            next = new TreeMap<>();
        }

        public Node() {
            this (0);
        }
    }

    private final Node root;

    /** Initialize your data structure here. */
    public LeetCode677() {
        root = new Node();
    }

    public void insert(String key, int val) {
        if (key != null) {
            Node currentNode = root;
            for (int index = 0; index < key.length(); index++) {
                char character = key.charAt(index);
                if (currentNode.next.get(character) == null) {
                    currentNode.next.put(character, new Node());
                }
                currentNode = currentNode.next.get(character);
            }
            currentNode.value = val;
        }
    }

    public int sum(String prefix) {
        if (prefix == null) {
            return 0;
        }
        // 来到prefix明确的最后一个节点（若存在）
        Node currentNode = root;
        for (int prefixIndex = 0; prefixIndex < prefix.length(); prefixIndex++) {
            currentNode = currentNode.next.get(prefix.charAt(prefixIndex));
            if (currentNode == null) {
                return 0;
            }
        }
        // 遍历其子节点
        return this.sum(currentNode);
    }
    private int sum(Node currentNode) {
        // 持续递归
        int sum = currentNode.value;
        for (Character key : currentNode.next.keySet()) {
            sum += this.sum(currentNode.next.get(key));
        }

        return sum;
    }

    public static void main(String[] args) {
        LeetCode677 leetCode677 = new LeetCode677();
        // ["MapSum", "insert", "sum", "insert", "sum"]
        // [[], ["a",3], ["ap"], ["b",2], ["a"]]
        leetCode677.insert("a", 3);
        System.out.println(leetCode677.sum("ap"));
        leetCode677.insert("b", 2);
        System.out.println(leetCode677.sum("a"));
    }
}