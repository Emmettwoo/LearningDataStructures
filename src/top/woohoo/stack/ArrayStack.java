package top.woohoo.stack;

import top.woohoo.array.Array;

public class ArrayStack<T> implements Stack<T> {
    private Array<T> array;

    public ArrayStack() {
        array = new Array<>();
    }
    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }


    @Override
    public int getSize() {
        return array.getSize();
    }
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(T value) {
        array.add(value);
    }
    @Override
    public T pop() {
        return array.removeLast();
    }

    @Override
    public T peek() {
        return array.getLast();
    }


    @Override
    public String toString() {
        if (array.isEmpty()) {
            return "Stack is empty";
        } else {
            int stackSize = array.getSize();
            StringBuilder dataString = new StringBuilder();
            // 这里的实现方法不符合栈的特性，其实使用了数组的方法。
            for (int index = 0; index < stackSize; index++) {
                dataString.append(array.get(index));
                if (index != stackSize-1) {
                    dataString.append(", ");
                }
            }
            return "Stack data: [ " + dataString + " ] <- top";
        }
    }
}
