package top.woohoo.tree;

import top.woohoo.array.Array;

public class AVLTree<K extends Comparable<K>, V> {

    class Node {
        public K key;
        public V value;
        public Node left;
        public Node right;
        public int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.height = 1;
        }

        @Override
        public String toString() {
            return key.toString() + ": " + value.toString();
        }
    }


    private Node root;
    private int size;

    // Construct
    public AVLTree() {
        this.root = null;
        this.size = 0;
    }


    // 插入元素
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

        // 更新height
        node.height = 1 + Math.max(this.getHeight(node.left), this.getHeight(node.right));
        return this.keepBalance(node);
    }

    // 修改元素
    public void set(K key, V value) {
        Node node = this.getNode(root, key);
        if (node != null) {
            node.value = value;
        } else {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
    }

    // 获取元素
    public V get(K key) {
        Node node = this.getNode(root, key);
        return node == null ? null : node.value;
    }

    // 删除元素
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
        Node returnNode;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            returnNode = node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            returnNode = node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                returnNode = rightNode;
            } else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                returnNode = leftNode;
            } else {
                // 左右皆有孩子，找左孩子最大值（前驱）或右孩子最小值（后继）
                Node minNodeAtRight = this.getMin(node.right);
                // 该前驱或后继，替代原node位置
                minNodeAtRight.right = this.remove(node.right, minNodeAtRight.key);
                minNodeAtRight.left = node.left;
                // 原node置空断开链接
                node.left = node.right = null;
                returnNode = minNodeAtRight;
            }
        }

        if (returnNode == null) {
            return null;
        }

        // 平衡维护
        returnNode.height = 1 + Math.max(this.getHeight(returnNode.left), this.getHeight(returnNode.right));
        return this.keepBalance(returnNode);
    }

    // 判断元素
    public boolean contains(K key) {
        return this.getNode(root, key) != null;
    }
    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    // 左旋右旋
    private Node rightRotate(Node y) {
        // 对节点y进行向右旋转操作，返回旋转后新的根节点x
        //        y                              x
        //       / \                           /   \
        //      x   T4     向右旋转 (y)        z     y
        //     / \       - - - - - - - ->    / \   / \
        //    z   T3                       T1  T2 T3 T4
        //   / \
        // T1   T2

        // 暂存数据
        Node x = y.left;
        Node T3 = x.right;

        // 向右旋转
        x.right = y;
        y.left = T3;

        // 更新高度
        y.height = Math.max(this.getHeight(y.left), this.getHeight(y.right)) + 1;
        x.height = Math.max(this.getHeight(x.left), this.getHeight(x.right)) + 1;

        return x;
    }
    private Node leftRotate(Node y) {
        // 对节点y进行向左旋转操作，返回旋转后新的根节点x
        //    y                             x
        //  /  \                          /   \
        // T1   x      向左旋转 (y)       y     z
        //     / \   - - - - - - - ->   / \   / \
        //   T2  z                     T1 T2 T3 T4
        //      / \
        //     T3 T4

        // 暂存数据
        Node x = y.right;
        Node T2 = x.left;

        // 向右旋转
        x.left = y;
        y.right = T2;

        // 更新高度
        y.height = Math.max(this.getHeight(y.left), this.getHeight(y.right)) + 1;
        x.height = Math.max(this.getHeight(x.left), this.getHeight(x.right)) + 1;

        return x;
    }

    // 平衡判断
    private Node keepBalance(Node node) {
        int balanceFactor = this.getBalanceFactor(node);
        if (balanceFactor > 1 && this.getBalanceFactor(node.left) >= 0) {
            return this.rightRotate(node);
        }
        if (balanceFactor > 1 && this.getBalanceFactor(node.left) < 0) {
            node.left = this.leftRotate(node.left);
            return this.rightRotate(node);
        }
        if (balanceFactor < -1 && this.getBalanceFactor(node.right) <= 0) {
            return this.leftRotate(node);
        }
        if (balanceFactor < -1 && this.getBalanceFactor(node.right) > 0) {
            node.right = this.rightRotate(node.right);
            return this.leftRotate(node);
        }
        return node;
    }
    public boolean isBST() {
        Array<K> keys = new Array<>();
        this.inOrder(root, keys);
        for (int index = 1; index < keys.getSize(); index++) {
            if (keys.get(index - 1).compareTo(keys.get(index)) > 0) {
                return false;
            }
        }
        return true;
    }
    private void inOrder(Node node, Array<K> keys) {
        // 终止条件
        if (node == null) {
            return;
        }

        // 持续递归
        this.inOrder(node.left, keys);
        keys.add(node.key);
        this.inOrder(node.right, keys);
    }
    public boolean isBalance() {
        return this.isBalance(root);
    }
    private boolean isBalance(Node node) {
        // 终止条件
        if (node == null) {
            return true;
        }

        // 执行操作
        if ((Math.abs(this.getBalanceFactor(node))) > 1) {
            return false;
        }

        // 持续递归
        return this.isBalance(node.left) && this.isBalance(node.right);
    }
    private int getBalanceFactor(Node node) {
        return node == null ? 0 : this.getHeight(node.left) - this.getHeight(node.right);
    }
    private int getHeight(Node node) {
        return node == null ? 0 : node.height;
    }

    // 节点操作
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
}
