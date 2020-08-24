package top.woohoo.map;

import top.woohoo.tree.RedBlackTree;
import top.woohoo.utils.FileUtil;
import top.woohoo.utils.TimingUtil;

import java.util.ArrayList;
import java.util.Collections;

public class MapTimeCompare {
    /*
        Test Data: <pride and prejudice> (125901 words)
        redBlackTree: Total Time: 778 ms
        avlMap: Total Time: 74 ms
        bstMap: Total Time: 50 ms
        linkedListMap: Total Time: 9904 ms
        ---
        Test Data: <pride and prejudice> (125901 words, sorted)
        redBlackTree: Total Time: 4944 ms
        avlMap: Total Time: 52 ms
        bstMap: Total Time: 10732 ms
        linkedListMap: Total Time: 263 ms
     */

    public static void main(String[] args) {
        ArrayList<String> testData = new ArrayList<>();
        FileUtil.readFile("./test/resources/pride-and-prejudice.txt", testData);
        // Collections.sort(testData);
        System.out.println("Total words: " + testData.size());

        TimingUtil.StartRecordTime();
        RedBlackTree<String, Integer> redBlackTree = new RedBlackTree<>();
        for (String data : testData) {
            if (redBlackTree.contains(data)) {
                redBlackTree.set(data, redBlackTree.get(data) + 1);
            } else {
                redBlackTree.add(data, 1);
            }
        }
        TimingUtil.EndedRecordTime();
        System.out.println("redBlackTree: " + TimingUtil.getTimeSpan());

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
