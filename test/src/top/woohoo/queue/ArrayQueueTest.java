package top.woohoo.queue;

import org.junit.Test;

public class ArrayQueueTest {
    @Test
    public void NegativeOverflowTest() {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();

        for (int i = 0; i < 2; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);
        }
        System.out.println("取出队首元素: " + arrayQueue.dequeue());
        System.out.println(arrayQueue);
        System.out.println("取出队首元素: " + arrayQueue.dequeue());
        System.out.println(arrayQueue);
        // System.out.println("取出队首元素: " + arrayQueue.dequeue());
        // System.out.println(arrayQueue);
    }

    @Test
    public void ExpansionTest() {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(2);

        for (int i = 0; i < 6; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);
        }
    }
}
