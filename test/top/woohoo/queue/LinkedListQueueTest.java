package top.woohoo.queue;

import org.junit.Test;

public class LinkedListQueueTest {
    @Test
    public void NegativeOverflowTest() {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();

        for (int i = 0; i < 2; i++) {
            linkedListQueue.enqueue(i);
            System.out.println(linkedListQueue);
        }
        System.out.println("取出队首元素: " + linkedListQueue.dequeue());
        System.out.println(linkedListQueue);
        System.out.println("取出队首元素: " + linkedListQueue.dequeue());
        System.out.println(linkedListQueue);
        // System.out.println("取出队首元素: " + linkedListQueue.dequeue());
        // System.out.println(linkedListQueue);
    }
}
