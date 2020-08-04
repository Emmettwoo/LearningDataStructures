package top.woohoo.map;

public interface Map<K, V> {

    void add(K key, V value);
    void set(K key, V value);

    V get(K key);
    V remove(K key);
    boolean contains(K key);

    int getSize();
    boolean isEmpty();
}
