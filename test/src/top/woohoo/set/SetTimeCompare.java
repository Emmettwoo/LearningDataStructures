package top.woohoo.set;

import top.woohoo.utils.FileUtil;
import top.woohoo.utils.TimingUtil;

import java.util.ArrayList;
import java.util.Collections;

public class SetTimeCompare {
    /*
        Test Data: <pride and prejudice> (125901 words)
        hashSet: Total Time: 48 ms
        avlSet: Total Time: 104 ms
        bstSet: Total Time: 52 ms
        linkedListSet: Total Time: 475 ms
        ---
        Test Data: <pride and prejudice> (125901 words, sorted)
        hashSet: Total Time: 64 ms
        avlSet: Total Time: 88 ms
        bstSet: Total Time: 4554 ms
        linkedListSet: Total Time: 1733 ms
     */

    public static void main(String[] args) {
        ArrayList<String> testData = new ArrayList<>();
        FileUtil.readFile("./test/resources/pride-and-prejudice.txt", testData);
        // Collections.sort(testData);
        System.out.println("Total words: " + testData.size());

        TimingUtil.StartRecordTime();
        HashSet<String> hashSet = new HashSet<>();
        for (String data : testData) {
            hashSet.add(data);
        }
        TimingUtil.EndedRecordTime();
        System.out.println("hashSet: " + TimingUtil.getTimeSpan());

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
