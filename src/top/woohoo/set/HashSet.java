package top.woohoo.set;

import top.woohoo.table.HashTable;

public class HashSet<T extends Comparable<T>> implements Set<T> {

    private final HashTable<T, Object> hashTable;

    public HashSet() {
        this.hashTable = new HashTable<>();
    }


    @Override
    public void add(T value) {
        hashTable.add(value, null);
    }

    @Override
    public void remove(T value) {
        hashTable.remove(value);
    }

    @Override
    public boolean contains(T value) {
        return hashTable.contains(value);
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
