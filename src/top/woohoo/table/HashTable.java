package top.woohoo.table;

import java.util.TreeMap;

public class HashTable<K, V> {

    private final TreeMap<K, V>[] data;
    private int capacity;
    private int size;

    // Constructors
    public HashTable(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.data = new TreeMap[capacity];
        for (int index = 0; index < capacity; index++) {
            this.data[index] = new TreeMap<>();
        }
    }
    public HashTable() {
        this(97);
    }


    // 插入元素
    public void add(K key, V value) {
        int hash = this.hash(key);
        if (data[hash].containsKey(key)) {
            data[hash].put(key, value);
        } else {
            data[hash].put(key, value);
            size++;
        }
    }

    // 修改元素
    public void set(K key, V value) {
        int hash = this.hash(key);
        if (data[hash].containsKey(key)) {
            data[hash].put(key, value);
        } else {
            throw new IllegalArgumentException("key doesn't exist");
        }
    }

    // 获取元素
    public V get(K key) {
        return data[this.hash(key)].get(key);
    }

    // 删除元素
    public V remove(K key) {
        int hash = this.hash(key);
        if (data[hash].containsKey(key)) {
            size--;
            return data[hash].remove(key);
        }
        return null;
    }

    // 判断元素
    public boolean contains(K key) {
        return data[this.hash(key)].containsKey(key);
    }
    public int getSize() {
        return size;
    }

    // 哈希计算
    private int hash(K key) {
        // 和运算去符号，取模得索引。
        return (key.hashCode() & 0x7fffffff) % capacity;
    }


}
