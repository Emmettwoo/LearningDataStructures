package top.woohoo.map;

import top.woohoo.tree.AVLTree;

public class AVLMap<K extends Comparable<K>, V> implements Map<K, V> {

    private final AVLTree<K, V> avlTree;

    public AVLMap() {
        this.avlTree = new AVLTree<>();
    }

    @Override
    public void add(K key, V value) {
        avlTree.add(key, value);
    }

    @Override
    public void set(K key, V value) {
        avlTree.set(key, value);
    }

    @Override
    public V get(K key) {
        return avlTree.get(key);
    }

    @Override
    public V remove(K key) {
        return avlTree.remove(key);
    }

    @Override
    public boolean contains(K key) {
        return avlTree.contains(key);
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
