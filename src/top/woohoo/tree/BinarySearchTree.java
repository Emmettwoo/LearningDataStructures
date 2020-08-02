package top.woohoo.tree;

import top.woohoo.queue.ArrayQueue;
import top.woohoo.queue.Queue;

public class BinarySearchTree<T extends Comparable<T>> {

    private class Node {
        public T value;
        public Node left;
        public Node right;

        public Node(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

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
        } else if (value.compareTo(node.value) > 0){
            node.right = this.add(node.right, value);
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
        } else if (value.compareTo(node.value) > 0) {
            node.right = remove(node.right, value);
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
        return node;
    }

    // 获取元素
    private Node getMin(Node node) {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Tree is empty!");
        }

        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    private Node getMax(Node node) {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Tree is empty!");
        }

        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isSingleNode() {
        return root.left == null & root.right == null;
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
