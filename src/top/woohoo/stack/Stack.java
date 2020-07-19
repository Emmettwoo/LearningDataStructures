package top.woohoo.stack;

public interface Stack<T> {
    // 获取栈大小
    int getSize();
    // 检查是否空栈
    boolean isEmpty();

    // 推入一个元素
    void push(T value);
    // 弹出顶部元素
    T pop();

    // 查看顶部元素
    T peek();
}
