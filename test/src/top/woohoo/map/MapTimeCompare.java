package top.woohoo.map;

import top.woohoo.utils.FileUtil;
import top.woohoo.utils.TimingUtil;

import java.util.ArrayList;

public class MapTimeCompare {
    /*
        Test Data: <pride and prejudice> (125901 words)
        bstMap: Total Time: 58 ms
        linkedListMap: Total Time: 10213 ms
     */

    public static void main(String[] args) {
        ArrayList<String> testData = new ArrayList<>();
        FileUtil.readFile("./test/resources/pride-and-prejudice.txt", testData);
        System.out.println("Total words: " + testData.size());

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
