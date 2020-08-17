package top.woohoo.set;

import top.woohoo.tree.AVLTree;

public class AVLSet<T extends Comparable<T>> implements Set<T> {
    private final AVLTree<T, Object> avlTree;

    public AVLSet() {
        this.avlTree = new AVLTree<>();
    }

    @Override
    public void add(T value) {
        avlTree.add(value, null);
    }

    @Override
    public void remove(T value) {
        avlTree.remove(value);
    }

    @Override
    public boolean contains(T value) {
        return avlTree.contains(value);
    }

    @Override
    public int getSize() {
        return avlTree.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avlTree.isEmpty();
    }
}
