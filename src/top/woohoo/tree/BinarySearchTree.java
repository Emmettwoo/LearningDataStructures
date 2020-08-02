package top.woohoo.tree;

import top.woohoo.queue.ArrayQueue;
import top.woohoo.queue.Queue;

public class BinarySearchTree<T extends Comparable<T>> {

    class Node {
        public T value;
        public int size;
        public int count;
        // todo: 还可以维护一个depth表所在层次（深度），还没想到实现方法（增删基于递归实现的情况下）。
        public Node left;
        public Node right;

        public Node(T value) {
            this.value = value;
            this.size = 1;
            this.count = 1;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "Node value: " + value + ", count: " + count + ", size: " + size + " .";
        }
    }

    private Node root;
    private int size;
    // fixme: 递归删除元素如何保留node的count而不使用这样丑陋的tempRegister方法。
    private int tempRegister;

    // constructors
    public BinarySearchTree() {
        root = null;
        size = 0;
    }
    public BinarySearchTree(T value) {
        root = new Node(value);
        size = 1;
    }

    // 插入元素
    public void add(T value) {
        root = this.add(root, value);
    }
    private Node add(Node node, T value) {

        // 当前位置为空，可插入
        if (node == null) {
            size++;
            return new Node(value);
        }

        // 递归查询树的元素
        if (value.compareTo(node.value) < 0) {
            node.left = this.add(node.left, value);
            node.size++;
        } else if (value.compareTo(node.value) > 0){
            node.right = this.add(node.right, value);
            node.size++;
        } else {
            node.count++;
            node.size++;
        }

        return node;
    }

    // 判断元素
    public boolean contains(T value) {
        return this.contains(root, value);
    }
    private boolean contains(Node node, T value) {
        if (node == null) {
            return false;
        }

        if (value.compareTo(node.value) == 0) {
            return true;
        } else if (value.compareTo(node.value) < 0) {
            return contains(node.left, value);
        } else {
            return contains(node.right, value);
        }
    }

    // 遍历元素
    public void preOrder() {
        this.preOrder(root);
        System.out.println("NULL");
    }
    private void preOrder(Node node) {
        // 终止条件
        if (node == null) {
            return;
        }

        // 执行操作
        System.out.print(node.value + " -> ");

        // 持续递归
        this.preOrder(node.left);
        this.preOrder(node.right);
    }
    public void inOrder() {
        this.inOrder(root);
        System.out.println("NULL");
    }
    private void inOrder(Node node) {
        // 终止条件
        if (node == null) {
            return;
        }

        // 持续递归
        this.preOrder(node.left);
        System.out.print(node.value + " -> ");
        this.preOrder(node.right);
    }
    public void postOrder() {
        this.postOrder(root);
        System.out.println("NULL");
    }
    private void postOrder(Node node) {
        // 终止条件
        if (node == null) {
            return;
        }

        // 持续递归
        this.preOrder(node.left);
        this.preOrder(node.right);

        // 执行操作
        System.out.print(node.value + " -> ");
    }
    public void levelOrder() {
        if (this.isEmpty()) {
            System.out.println("Tree is empty!");
            return;
        }

        Queue<Node> queue = new ArrayQueue<>();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            Node node = queue.dequeue();
            System.out.print(node.value + " -> ");

            if (node.left != null) {
                queue.enqueue(node.left);
            }
            if (node.right != null) {
                queue.enqueue(node.right);
            }
        }

        System.out.println("NULL");
    }

    // 删除元素
    public void remove(T value) {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Tree is empty!");
        }

        root = this.remove(root, value);
    }
    private Node remove(Node node, T value) {
        // 终止条件
        if (node == null) {
            return null;
        }

        // 持续递归
        if (value.compareTo(node.value) < 0) {
            node.left = remove(node.left, value);
            node.size-=tempRegister;
        } else if (value.compareTo(node.value) > 0) {
            node.right = remove(node.right, value);
            node.size-=tempRegister;
        } else {
            tempRegister = node.count;
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
    public T removeMin() {
        Node minNode = this.getMin(root);
        root = this.removeMin(root);
        return minNode.value;
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
        node.size--;
        return node;
    }
    public T removeMax() {
        Node maxNode = this.getMax(root);
        root = this.removeMax(root);
        return maxNode.value;
    }
    private Node removeMax(Node node) {
        // 终止条件
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        // 持续递归
        node.right = removeMax(node.right);
        node.size--;
        return node;
    }


    // 获取元素
    public Node getMin(Node node) {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Tree is empty!");
        }

        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    public Node getMax(Node node) {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Tree is empty!");
        }

        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
    public Node getFloor(T target) {
        if (this.isEmpty()) {
            System.out.println("Tree is empty!");
            return null;
        } else {
            return this.getFloor(root, target);
        }
    }
    private Node getFloor(Node node, T target) {
        // 终止条件
        if (node == null) {
            return null;
        } else if (target.compareTo(node.value) == 0) {
            return node;
        }

        // 持续递归
        if (target.compareTo(node.value) > 0) {
            Node rightNode = this.getFloor(node.right, target);
            if (rightNode != null) {
                return rightNode;
            } else {
                return node;
            }
        } else {
            return this.getFloor(node.left, target);
        }
    }
    public Node getCeil(T target) {
        if (this.isEmpty()) {
            System.out.println("Tree is empty!");
            return null;
        } else {
            return this.getCeil(root, target);
        }
    }
    private Node getCeil(Node node, T target) {
        // 终止条件
        if (node == null) {
            return null;
        } else if (target.compareTo(node.value) == 0) {
            return node;
        }

        // 持续递归
        if (target.compareTo(node.value) < 0) {
            Node leftNode = this.getCeil(node.left, target);
            if (leftNode != null) {
                return leftNode;
            } else {
                return node;
            }
        } else {
            return this.getCeil(node.right, target);
        }
    }
    // todo: getRank()和selectByRank()，找不到Rank的定义，实现个屁。

    // 条件判断
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isSingleNode() {
        return root.left == null & root.right == null;
    }

    // getters
    public Node getRoot() {
        return root;
    }
    public int getSize() {
        return size;
    }


    @Override
    public String toString() {
        StringBuilder dataString = new StringBuilder();
        generateDataString(root, 0, dataString);
        return dataString.toString();
    }
    private void generateDataString(Node node, int depth, StringBuilder dataString) {
        if (node == null) {
            dataString.append(this.generateDepthString(depth)).append("NULL\n");
            return;
        }

        dataString.append(this.generateDepthString(depth)).append(node.value).append("\n");
        this.generateDataString(node.left, depth + 1, dataString);
        this.generateDataString(node.right, depth + 1, dataString);
    }
    private String generateDepthString(int depth) {
        StringBuilder depthString = new StringBuilder();
        for (int index = 0; index < depth; index++) {
            depthString.append("--");
        }
        depthString.append(" ");
        return depthString.toString();
    }
}
