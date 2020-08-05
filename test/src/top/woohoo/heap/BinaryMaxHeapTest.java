package top.woohoo.heap;

import org.junit.Test;
import top.woohoo.utils.RandomUtil;

public class BinaryMaxHeapTest {

    @Test
    public void baseTest() {
        final int DATA_SIZE = 20;

        Integer[] testData = RandomUtil.generateIntArray(DATA_SIZE, 0, 100);
        BinaryMaxHeap<Integer> binaryMaxHeap = new BinaryMaxHeap<>(testData);

        System.out.print("Raw Data: ");
        for (int index = 0; index < DATA_SIZE; index++) {
            System.out.print(testData[index] + " -> ");
        }
        System.out.println("NULL");

        binaryMaxHeap.replace(42);

        System.out.print("Heap Data: ");
        while (!binaryMaxHeap.isEmpty()) {
            System.out.print(binaryMaxHeap.extractMax() + " -> ");
        }
        System.out.println("NULL");
    }
}
