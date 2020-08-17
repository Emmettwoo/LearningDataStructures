package top.woohoo.map;

import top.woohoo.utils.FileUtil;
import top.woohoo.utils.TimingUtil;

import java.util.ArrayList;
import java.util.Collections;

public class MapTimeCompare {
    /*
        Test Data: <pride and prejudice> (125901 words)
        avlMap: Total Time: 61 ms
        bstMap: Total Time: 60 ms
        linkedListMap: Total Time: 9534 ms
        ---
        Test Data: <pride and prejudice> (125901 words, sorted)
        avlMap: Total Time: 44 ms
        bstMap: Total Time: 10603 ms
        linkedListMap: Total Time: 265 ms
     */

    public static void main(String[] args) {
        ArrayList<String> testData = new ArrayList<>();
        FileUtil.readFile("./test/resources/pride-and-prejudice.txt", testData);
        // Collections.sort(testData);
        System.out.println("Total words: " + testData.size());

        TimingUtil.StartRecordTime();
        AVLMap<String, Integer> avlMap = new AVLMap<>();
        for (String data : testData) {
            if (avlMap.contains(data)) {
                avlMap.set(data, avlMap.get(data) + 1);
            } else {
                avlMap.add(data, 1);
            }
        }
        TimingUtil.EndedRecordTime();
        System.out.println("avlMap: " + TimingUtil.getTimeSpan());

        TimingUtil.StartRecordTime();
        BSTMap<String, Integer> bstMap = new BSTMap<>();
        for (String data : testData) {
            if (bstMap.contains(data)) {
                bstMap.set(data, bstMap.get(data) + 1);
            } else {
                bstMap.add(data, 1);
            }
        }
        TimingUtil.EndedRecordTime();
        System.out.println("bstMap: " + TimingUtil.getTimeSpan());

        TimingUtil.StartRecordTime();
        LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();
        for (String data : testData) {
            if (linkedListMap.contains(data)) {
                linkedListMap.set(data, linkedListMap.get(data) + 1);
            } else {
                linkedListMap.add(data, 1);
            }
        }
        TimingUtil.EndedRecordTime();
        System.out.println("linkedListMap: " + TimingUtil.getTimeSpan());
    }
}
