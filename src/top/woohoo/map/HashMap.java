package top.woohoo.map;

import top.woohoo.table.HashTable;

public class HashMap<K extends Comparable<K>, V> implements Map<K, V> {

    private final HashTable<K, V> hashTable;

    public HashMap() {
        this.hashTable = new HashTable<>();
    }

    @Override
    public void add(K key, V value) {
        hashTable.add(key, value);
    }

    @Override
    public void set(K key, V value) {
        hashTable.set(key, value);
    }

    @Override
    public V get(K key) {
        return hashTable.get(key);
    }

    @Override
    public V remove(K key) {
        return hashTable.remove(key);
    }

    @Override
    public boolean contains(K key) {
        return hashTable.contains(key);
    }

    @Override
    public int getSize() {
        return hashTable.getSize();
    }

    @Override
    public boolean isEmpty() {
        return hashTable.getSize() == 0;
    }
}
