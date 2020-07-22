package top.woohoo.stack;

import top.woohoo.utils.RandomUtil;
import top.woohoo.utils.TimingUtil;

public class StackTimeCompare {
    private static final int DATA_SIZE = 10000000;
    /*
        WHEN DATA_SIZE = 1000000:
        arrayStack: Total Time: 57 ms
        linkedListStack: Total Time: 17 ms
        ---
        WHEN DATA_SIZE = 10000000:
        arrayStack(test1): Total Time: 2605 ms
        linkedListStack(test1): Total Time: 1589 ms
        arrayStack(test2): Total Time: 2705 ms
        linkedListStack(test2): Total Time: 3125 ms
        ---
        WHEN DATA_SIZE = 20000000:
        arrayStack: Total Time: 656 ms
        linkedListStack: Total Time: 6382 ms
     */

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        Integer[] testData = RandomUtil.generateIntArray(DATA_SIZE, 0, DATA_SIZE);

        TimingUtil.StartRecordTime();
        for (Integer value : testData) {
            arrayStack.push(value);
        }
        for (int i = 0; i < DATA_SIZE; i++) {
            arrayStack.pop();
        }
        TimingUtil.EndedRecordTime();
        System.out.println("arrayStack: " + TimingUtil.getTimeSpan());

        TimingUtil.StartRecordTime();
        for (Integer value : testData) {
            linkedListStack.push(value);
        }
        for (int i = 0; i < DATA_SIZE; i++) {
            linkedListStack.pop();
        }
        TimingUtil.EndedRecordTime();
        System.out.println("linkedListStack: " + TimingUtil.getTimeSpan());
    }
}
