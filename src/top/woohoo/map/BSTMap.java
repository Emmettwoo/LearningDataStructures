package top.woohoo.map;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    class Node {
        public K key;
        public V value;
        public Node left;
        public Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return key.toString() + ": " + value.toString();
        }
    }


    private Node root;
    private int size;

    // Construct
    public BSTMap() {
        this.root = null;
        this.size = 0;
    }


    @Override
    public void add(K key, V value) {
        root = this.add(root, key, value);
    }
    private Node add(Node node, K key, V value) {

        // 当前位置为空，可插入
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        // 递归查询树的元素
        if (key.compareTo(node.key) < 0) {
            node.left = this.add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0){
            node.right = this.add(node.right, key, value);
        } else {
            // key相等，更新其value
            node.value = value;
        }

        return node;
    }

    @Override
    public void set(K key, V value) {
        Node node = this.getNode(root, key);
        if (node != null) {
            node.value = value;
        } else {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
    }

    @Override
    public V get(K key) {
        Node node = this.getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public V remove(K key) {
        Node node = this.getNode(root, key);
        if (node != null) {
            root = this.remove(root, key);
            return node.value;
        } else {
            return null;
        }
    }
    private Node remove(Node node, K key) {
        // 终止条件
        if (node == null) {
            return null;
        }

        // 持续递归
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            } else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            } else {
                // 左右皆有孩子，找左孩子最大值（前驱）或右孩子最小值（后继）
                Node minNodeAtRight = this.getMin(node.right);
                node.value = minNodeAtRight.value;
                removeMin(node.right);
                return node;
            }
        }

        return node;
    }

    @Override
    public boolean contains(K key) {
        return this.getNode(root, key) != null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        } else if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return this.getNode(node.left, key);
        } else {
            return this.getNode(node.right, key);
        }
    }
    private Node getMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    private Node removeMin(Node node) {
        // 终止条件
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        // 持续递归
        node.left = removeMin(node.left);
        return node;
    }
}
