package top.woohoo.heap;

import top.woohoo.utils.RandomUtil;
import top.woohoo.utils.TimingUtil;

public class HeapifyTimeCompare {

    private static final int DATA_SIZE = 50000000;
    /*
        WHEN DATA_SIZE = 10000000:
        heapWithHeapify: Total Time: 567 ms
        heapWithoutHeapify: Total Time: 566 ms
        ---
        WHEN DATA_SIZE = 20000000:
        heapWithHeapify: Total Time: 901 ms
        heapWithoutHeapify: Total Time: 1106 ms
        ---
        WHEN DATA_SIZE = 20000000:
        heapWithHeapify: Total Time: 2082 ms
        heapWithoutHeapify: Total Time: 4128 ms
     */

    public static void main(String[] args) {
        BinaryMaxHeap<Integer> heapWithHeapify;
        BinaryMaxHeap<Integer> heapWithoutHeapify;
        Integer[] testData = RandomUtil.generateIntArray(DATA_SIZE, 0, DATA_SIZE);

        TimingUtil.StartRecordTime();
        heapWithHeapify = new BinaryMaxHeap<>(testData);
        TimingUtil.EndedRecordTime();
        System.out.println("heapWithHeapify: " + TimingUtil.getTimeSpan());

        TimingUtil.StartRecordTime();
        heapWithoutHeapify = new BinaryMaxHeap<>();
        for (Integer value : testData) {
            heapWithoutHeapify.add(value);
        }
        TimingUtil.EndedRecordTime();
        System.out.println("heapWithoutHeapify: " + TimingUtil.getTimeSpan());
    }
}
