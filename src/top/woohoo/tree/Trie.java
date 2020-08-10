package top.woohoo.tree;

import top.woohoo.array.Array;

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
        if (value.trim().equals("")) {
            throw new IllegalArgumentException("Blank is not allow here.");
        }

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

    // 删除元素
    public void remove(String value) {
        if (!value.trim().equals("")) {
            this.remove(root, 0, value);
        }
    }
    private void remove(Node parentNode, int index, String value) {
        Node currentNode = parentNode.next.get(value.charAt(index));
        if (currentNode == null) {
            return;
        }

        // 终止条件
        if (index == value.length() - 1) {
            if (currentNode.isWord) {
                currentNode.isWord = false;
                size--;
            }
            return;
        }

        // 持续递归
        this.remove(currentNode, index + 1, value);

        // 执行操作
        if (currentNode.next.isEmpty()) {
            parentNode.next.put(value.charAt(index), null);
        }
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


    @Override
    public String toString() {
        // 获取字典树中所有词汇
        Array<String> words = new Array<>();
        words = this.getWords(root, new StringBuilder(), words);

        // 将词汇集合拼接成字符串返回
        StringBuilder result = new StringBuilder();
        result.append('[');
        int wordsSize = words.getSize();
        for (int index = 0; index < wordsSize; index++) {
            result.append(words.get(index));
            if (index != wordsSize - 1) {
                result.append(", ");
            }
        }
        return result.append(']').toString();
    }
    private Array<String> getWords(Node currentNode, StringBuilder word, Array<String> words) {
        // 终止条件
        if (currentNode == null) {
            return words;
        }

        // 持续递归
        for (Character character : currentNode.next.keySet()) {
            words = this.getWords(currentNode.next.get(character), word.append(character), words);
            word.deleteCharAt(word.length() - 1);
        }

        // 执行操作
        if (currentNode.isWord) {
            words.add(word.toString());
        }
        return words;
    }
}
