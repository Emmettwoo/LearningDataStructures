package top.woohoo.queue.priority;

import org.junit.Test;
import top.woohoo.utils.RandomUtil;

public class PriorityQueueTest {

    @Test
    public void basicTest() {
        final int DATA_SIZE = 20;

        Integer[] testData = RandomUtil.generateIntArray(DATA_SIZE, 0, 100);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        System.out.print("Raw Data: ");
        for (int index = 0; index < DATA_SIZE; index++) {
            priorityQueue.enqueue(testData[index]);
            System.out.print(testData[index] + " -> ");
        }
        System.out.println("NULL");

        System.out.print("Heap Data: ");
        while (!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.dequeue() + " -> ");
        }
        System.out.println("NULL");
    }
}
