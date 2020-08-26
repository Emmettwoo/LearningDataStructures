package top.woohoo.map;

import top.woohoo.tree.RedBlackTree;
import top.woohoo.utils.FileUtil;
import top.woohoo.utils.TimingUtil;

import java.util.ArrayList;
import java.util.Collections;

public class MapTimeCompare {
    /*
        Test Data: <pride and prejudice> (125901 words)
        hashMap: Total Time: 84 ms
        redBlackTree: Total Time: 852 ms
        avlMap: Total Time: 55 ms
        bstMap: Total Time: 171 ms
        linkedListMap: Total Time: 10055 ms
        ---
        Test Data: <pride and prejudice> (125901 words, sorted)
        hashMap: Total Time: 77 ms
        redBlackTree: Total Time: 4972 ms
        avlMap: Total Time: 60 ms
        bstMap: Total Time: 10851 ms
        linkedListMap: Total Time: 260 ms
     */

    public static void main(String[] args) {
        ArrayList<String> testData = new ArrayList<>();
        FileUtil.readFile("./test/resources/pride-and-prejudice.txt", testData);
        // Collections.sort(testData);
        System.out.println("Total words: " + testData.size());

        TimingUtil.StartRecordTime();
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String data : testData) {
            if (hashMap.contains(data)) {
                hashMap.set(data, hashMap.get(data) + 1);
            } else {
                hashMap.add(data, 1);
            }
        }
        TimingUtil.EndedRecordTime();
        System.out.println("hashMap: " + TimingUtil.getTimeSpan());

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
