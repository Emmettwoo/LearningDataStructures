package top.woohoo.set;

public interface Set<T> {

    void add(T value);
    void remove(T value);
    boolean contains(T value);
    int getSize();
    boolean isEmpty();
}
