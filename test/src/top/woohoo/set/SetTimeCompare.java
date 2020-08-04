package top.woohoo.set;

import top.woohoo.utils.FileUtil;
import top.woohoo.utils.TimingUtil;

import java.util.ArrayList;

public class SetTimeCompare {
    /*
        Test Data: <pride and prejudice> (125901 words)
        bstSet: Total Time: 44 ms
        linkedListSet: Total Time: 441 ms
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
