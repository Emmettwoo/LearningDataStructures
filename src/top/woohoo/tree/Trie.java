package top.woohoo.tree;

import java.util.TreeMap;

public class Trie {
    private static class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this (false);
        }
    }


    private final Node root;
    private int size;


    // Constructs
    public Trie() {
        root = new Node();
        size = 0;
    }


    // 新增元素
    public void add(String value) {
        Node currentNode = root;
        for (int index = 0; index < value.length(); index++) {
            char character = value.charAt(index);
            if (currentNode.next.get(character) == null) {
                currentNode.next.put(character, new Node());
            }
            currentNode = currentNode.next.get(character);
        }
        if (!currentNode.isWord) {
            currentNode.isWord = true;
            size++;
        }
    }
    public void addWithRecursion(String value) {
        this.addWithRecursion(root, 0, value);
    }
    private void addWithRecursion(Node currentNode, int index, String value) {
        // 终止条件
        if (index == value.length()) {
            if (!currentNode.isWord) {
                currentNode.isWord = true;
                size++;
            }
            return;
        }

        // 执行操作
        char character = value.charAt(index);
        if (currentNode.next.get(character) == null) {
            currentNode.next.put(character, new Node());
        }

        // 持续递归
        this.addWithRecursion(currentNode.next.get(character), index + 1, value);
    }

    // 判断元素
    public int getSize() {
        return this.size;
    }
    public boolean contains(String value) {
        Node targetNode = this.isPrefix(value);
        return targetNode != null && targetNode.isWord;
    }
    public boolean fuzzySearch(String value) {
        return this.fuzzySearch(root, 0, value);
    }
    private boolean fuzzySearch(Node currentNode, int index, String value) {
        // 终止条件
        if (index == value.length()) {
            return currentNode.isWord;
        }

        // 持续递归
        char character = value.charAt(index);
        if (character == '.') {
            for (Character key : currentNode.next.keySet()) {
                if (this.fuzzySearch(currentNode.next.get(key), index + 1, value)) {
                    return true;
                }
            }
            return false;
        } else {
            return currentNode.next.get(character) != null && this.fuzzySearch(currentNode.next.get(character), index + 1, value);
        }
    }
    public boolean startWith(String prefix) {
        return this.isPrefix(prefix) != null;
    }
    private Node isPrefix(String prefix) {
        Node currentNode = root;
        for (int index = 0; index < prefix.length(); index++) {
            char character = prefix.charAt(index);
            if (currentNode.next.get(character) == null) {
                return null;
            }
            currentNode = currentNode.next.get(character);
        }
        return currentNode;
    }
}
