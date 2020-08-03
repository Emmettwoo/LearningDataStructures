package top.woohoo.set;

import top.woohoo.utils.FileUtil;
import top.woohoo.utils.TimingUtil;

import java.util.ArrayList;

public class SetTimeCompare {
    /*
        WHEN Total words = 125901:
        bstSet: Total Time: 44 ms
        linkedListSet: Total Time: 441 ms
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
        ArrayList<String> testData = new ArrayList<>();
        FileUtil.readFile("./test/resources/pride-and-prejudice.txt", testData);
        System.out.println("Total words: " + testData.size());

        TimingUtil.StartRecordTime();
        BSTSet<String> bstSet = new BSTSet<>();
        for (String data : testData) {
            bstSet.add(data);
        }
        TimingUtil.EndedRecordTime();
        System.out.println("bstSet: " + TimingUtil.getTimeSpan());

        TimingUtil.StartRecordTime();
        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        for (String data : testData) {
            linkedListSet.add(data);
        }
        TimingUtil.EndedRecordTime();
        System.out.println("linkedListSet: " + TimingUtil.getTimeSpan());

    }
}
