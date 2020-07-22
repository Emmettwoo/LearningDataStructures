package top.woohoo.queue;

import top.woohoo.array.Array;

public class ArrayQueue<T> implements Queue<T> {
    private Array<T> array;

    public ArrayQueue() {
        array = new Array<>();
    }
    public ArrayQueue(int capacity) {
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
    public void enqueue(T value) {
        array.add(value);
    }
    @Override
    public T dequeue() {
        return array.removeByIndex(0);
    }

    @Override
    public T getFront() {
        return array.get(0);
    }


    @Override
    public String toString() {
        if (array.isEmpty()) {
            return "Queue is empty";
        } else {
            int queueSize = array.getSize();
            StringBuilder dataString = new StringBuilder();
            // 这里的实现方法不符合栈的特性，其实使用了数组的方法。
            for (int index = 0; index < queueSize; index++) {
                dataString.append(array.get(index));
                if (index != queueSize-1) {
                    dataString.append(", ");
                }
            }
            return "Queue data: [ " + dataString + " ] -> end";
        }
    }
}
