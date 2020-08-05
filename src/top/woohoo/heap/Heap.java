package top.woohoo.heap;

public interface Heap<T extends Comparable<T>> {

    void add(T value);
    T getMax();
    T extractMax();

    T replace(T value);

    int getSize();
    boolean isEmpty();
}
