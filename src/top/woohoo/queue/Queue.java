package top.woohoo.queue;

public interface Queue<T> {
    // 获取队列大小
    int getSize();
    // 检查是否为空队列
    boolean isEmpty();

    // 入队和出队
    void enqueue(T value);
    T dequeue();

    // 查看队首元素
    T getFront();
}
