package top.woohoo.queue.priority;

import top.woohoo.heap.BinaryMaxHeap;
import top.woohoo.queue.Queue;

public class PriorityQueue<T extends Comparable<T>> implements Queue<T> {

    private final BinaryMaxHeap<T> binaryMaxHeap;

    // Constructors
    public PriorityQueue() {
        this.binaryMaxHeap = new BinaryMaxHeap<>();
    }
    public PriorityQueue(T[] array) {
        this.binaryMaxHeap = new BinaryMaxHeap<>(array);
    }


    @Override
    public int getSize() {
        return binaryMaxHeap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return binaryMaxHeap.isEmpty();
    }

    @Override
    public void enqueue(T value) {
        binaryMaxHeap.add(value);
    }

    @Override
    public T dequeue() {
        return binaryMaxHeap.extractMax();
    }

    @Override
    public T getFront() {
        return binaryMaxHeap.getMax();
    }
}
