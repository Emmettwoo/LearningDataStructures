package top.woohoo.queue;

import top.woohoo.utils.RandomUtil;
import top.woohoo.utils.TimingUtil;

import java.util.ArrayList;

public class QueueTimeCompare {
    private static final int DATA_SIZE = 100000;
    /*
        WHEN DATA_SIZE = 100000:
        arrayQueue: Total Time: 472 ms
        loopQueue: Total Time: 13 ms
        ---
        WHEN DATA_SIZE = 1000000:
        arrayQueue: Total Time: 54623 ms
        loopQueue: Total Time: 39 ms
     */

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        Integer[] testData = RandomUtil.generateIntArray(DATA_SIZE, 0, DATA_SIZE);

        TimingUtil.StartRecordTime();
        for (Integer value : testData) {
            arrayQueue.enqueue(value);
        }
        for (int i = 0; i < DATA_SIZE; i++) {
            arrayQueue.dequeue();
        }
        TimingUtil.EndedRecordTime();
        System.out.println("arrayQueue: " + TimingUtil.getTimeSpan());

        TimingUtil.StartRecordTime();
        for (Integer value : testData) {
            loopQueue.enqueue(value);
        }
        for (int i = 0; i < DATA_SIZE; i++) {
            loopQueue.dequeue();
        }
        TimingUtil.EndedRecordTime();
        System.out.println("loopQueue: " + TimingUtil.getTimeSpan());
    }
}
