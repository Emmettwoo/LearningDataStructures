package top.woohoo.tree;

public class RedBlackTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    class Node {
        public K key;
        public V value;
        public Node left;
        public Node right;
        public boolean color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.color = RED;
        }

        @Override
        public String toString() {
            return key.toString() + ": " + value.toString();
        }
    }


    private Node root;
    private int size;

    // Construct
    public RedBlackTree() {
        this.root = null;
        this.size = 0;
    }


    public void add(K key, V value) {
        root = this.add(root, key, value);
        // 红黑树的根节点应为黑色
        root.color = BLACK;
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

        // 维护红黑树
        if (this.isRed(node.right) && !this.isRed(node.left)) {
            node = this.leftRotate(node);
        }
        if (this.isRed(node.right) && this.isRed(node.left)) {
            node = this.rightRotate(node);
        }
        if (this.isRed(node.right) && this.isRed(node.left)) {
            this.flipColor(node);
        }

        return node;
    }

    public void set(K key, V value) {
        Node node = this.getNode(root, key);
        if (node != null) {
            node.value = value;
        } else {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
    }

    public V get(K key) {
        Node node = this.getNode(root, key);
        return node == null ? null : node.value;
    }

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

    public boolean contains(K key) {
        return this.getNode(root, key) != null;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 左旋右旋， 颜色反转
    private Node leftRotate(Node node) {
        //   node                     x
        //  /   \     左旋转         /  \
        // T1   x   --------->   node   T3
        //     / \              /   \
        //    T2 T3            T1   T2

        // 暂存数据
        Node x = node.right;

        // 向左旋转
        node.right = x.left;
        x.left = node;

        // 颜色还原
        x.color = node.color;
        node.color = RED;

        return x;
    }
    private Node rightRotate(Node node) {
        //     node                   x
        //    /   \     右旋转       /  \
        //   x    T2   ------->   y   node
        //  / \                       /  \
        // y  T1                     T1  T2

        // 暂存数据
        Node x = node.left;

        // 向右旋转
        node.left = x.right;
        x.right = node;

        // 颜色还原
        x.color = node.color;
        node.color = RED;

        return x;
    }
    private void flipColor(Node node) {
        // 反转颜色的可能性只有这一种，直接填入值效率更高（虽然看起来逻辑比较奇怪）
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }
    /*
    private void flipColor(Node node) {
        node.color = !node.color;
        node.left.color = !node.left.color;
        node.right.color = !node.right.color;
    }
     */

    private boolean isRed(Node node) {
        if (node == null) {
            return BLACK;
        }
        return node.color;
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