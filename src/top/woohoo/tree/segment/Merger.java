package top.woohoo.tree.segment;

public interface Merger<T> {
    T merge(T valueA, T valueB);
}
