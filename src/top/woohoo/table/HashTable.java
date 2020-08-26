package top.woohoo.table;

import java.util.TreeMap;

// K extends Comparable<K> 更好的做法是，默认用链表存储，达到阈值判断Comparable决定是否转红黑树
public class HashTable<K extends Comparable<K>, V> {

    // @see https://planetmath.org/goodhashtableprimes
    private static final int[] goodHashTablePrimes =
            { 53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593, 49157, 98317,
            196613, 393241, 786433, 1572869, 3145739, 6291469, 12582917, 25165843,
            50331653, 100663319, 201326611, 402653189, 805306457, 1610612741 };

    private static int CAPACITY_INDEX = 0;
    private static final int UPPER_THRESHOLD = 10;
    private static final int LOWER_THRESHOLD = 2;

    private TreeMap<K, V>[] data;
    private int capacity;
    private int size;

    // Constructors
    public HashTable() {
        this.capacity = goodHashTablePrimes[CAPACITY_INDEX];
        this.size = 0;
        this.data = new TreeMap[capacity];
        for (int index = 0; index < capacity; index++) {
            this.data[index] = new TreeMap<>();
        }
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

        // 扩容判断
        if (size >= UPPER_THRESHOLD * capacity && CAPACITY_INDEX < goodHashTablePrimes.length - 1) {
            this.resize(goodHashTablePrimes[++CAPACITY_INDEX]);
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
        if (!data[hash].containsKey(key)) {
            return null;
        }

        // 删除操作
        V removeValue = data[hash].remove(key);
        size--;

        // 缩容判断
        if (size < LOWER_THRESHOLD * capacity && CAPACITY_INDEX > 0) {
            this.resize(goodHashTablePrimes[--CAPACITY_INDEX]);
        }

        return removeValue;
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

    // 扩容与缩容
    private void resize(int newCapacity) {
        // 初始化新哈希表
        TreeMap<K, V>[] newData = new TreeMap[newCapacity];
        for (int index = 0; index < newCapacity; index++) {
            newData[index] = new TreeMap<>();
        }

        // 调整容量大小
        int oldCapacity = capacity;
        capacity = newCapacity;

        // 复制旧数据
        for (int index = 0; index < oldCapacity; index++) {
            TreeMap<K, V> temp = data[index];
            for (K key : temp.keySet()) {
                newData[this.hash(key)].put(key, temp.get(key));
            }
        }

        // 指向新哈希表
        data = newData;

        /* 测试用输出
            System.out.println("New Capacity: " + newCapacity);
        */
    }
}
