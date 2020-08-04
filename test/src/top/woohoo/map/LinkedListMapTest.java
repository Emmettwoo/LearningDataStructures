package top.woohoo.map;

import org.junit.Test;
import top.woohoo.utils.FileUtil;

import java.util.ArrayList;

public class LinkedListMapTest {

    @Test
    public void txtWordTimesCount() {
        ArrayList<String> testData = new ArrayList<>();
        FileUtil.readFile("./test/resources/pride-and-prejudice.txt", testData);
        System.out.println("Total words: " + testData.size());

        LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();
        for (String data : testData) {
            if (linkedListMap.contains(data)) {
                linkedListMap.set(data, linkedListMap.get(data) + 1);
            } else {
                linkedListMap.add(data, 1);
            }
        }
        System.out.println("Total different words: " + linkedListMap.getSize());

        System.out.println("Frequency of 'pride': " + linkedListMap.get("pride"));
        System.out.println("Frequency of 'prejudice': " + linkedListMap.get("prejudice"));
    }
}
