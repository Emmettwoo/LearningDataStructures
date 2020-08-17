package top.woohoo.set;

import top.woohoo.utils.FileUtil;
import top.woohoo.utils.TimingUtil;

import java.util.ArrayList;
import java.util.Collections;

public class SetTimeCompare {
    /*
        Test Data: <pride and prejudice> (125901 words)
        avlSet: Total Time: 59 ms
        bstSet: Total Time: 46 ms
        linkedListSet: Total Time: 458 ms
        ---
        Test Data: <pride and prejudice> (125901 words, sorted)
        avlSet: Total Time: 59 ms
        bstSet: Total Time: 4434 ms
        linkedListSet: Total Time: 2240 ms
     */

    public static void main(String[] args) {
        ArrayList<String> testData = new ArrayList<>();
        FileUtil.readFile("./test/resources/pride-and-prejudice.txt", testData);
        // Collections.sort(testData);
        System.out.println("Total words: " + testData.size());

        TimingUtil.StartRecordTime();
        AVLSet<String> avlSet = new AVLSet<>();
        for (String data : testData) {
            avlSet.add(data);
        }
        TimingUtil.EndedRecordTime();
        System.out.println("avlSet: " + TimingUtil.getTimeSpan());

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
