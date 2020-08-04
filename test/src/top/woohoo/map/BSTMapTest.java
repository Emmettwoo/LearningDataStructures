package top.woohoo.map;

import org.junit.Test;
import top.woohoo.utils.FileUtil;

import java.util.ArrayList;

public class BSTMapTest {

    @Test
    public void txtWordTimesCount() {
        ArrayList<String> testData = new ArrayList<>();
        FileUtil.readFile("./test/resources/pride-and-prejudice.txt", testData);
        System.out.println("Total words: " + testData.size());

        BSTMap<String, Integer> bstMap = new BSTMap<>();
        for (String data : testData) {
            if (bstMap.contains(data)) {
                bstMap.set(data, bstMap.get(data) + 1);
            } else {
                bstMap.add(data, 1);
            }
        }
        System.out.println("Total different words: " + bstMap.getSize());

        System.out.println("Frequency of 'pride': " + bstMap.get("pride"));
        System.out.println("Frequency of 'prejudice': " + bstMap.get("prejudice"));
    }
}
