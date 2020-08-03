package top.woohoo.set;

import top.woohoo.tree.BinarySearchTree;

// 其实就是二分搜索树重新包装一下，并无差别。
public class BSTSet<T extends Comparable<T>> implements Set<T> {

    private final BinarySearchTree<T> binarySearchTree;

    public BSTSet() {
        this.binarySearchTree = new BinarySearchTree<>();
    }

    @Override
    public void add(T value) {
        binarySearchTree.add(value);
    }

    @Override
    public void remove(T value) {
        binarySearchTree.remove(value);
    }

    @Override
    public boolean contains(T value) {
        return binarySearchTree.contains(value);
    }

    @Override
    public int getSize() {
        return binarySearchTree.getSize();
    }

    @Override
    public boolean isEmpty() {
        return binarySearchTree.isEmpty();
    }
}
