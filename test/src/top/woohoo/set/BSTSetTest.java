package top.woohoo.set;

import org.junit.Test;
import top.woohoo.utils.FileUtil;

import java.util.ArrayList;

public class BSTSetTest {

    @Test
    public void txtWordsCount() {
        ArrayList<String> testData = new ArrayList<>();
        FileUtil.readFile("./test/resources/pride-and-prejudice.txt", testData);
        System.out.println("Total words: " + testData.size());

        BSTSet<String> bstSet = new BSTSet<>();
        for (String data : testData) {
            bstSet.add(data);
        }
        System.out.println("Total different words: " + bstSet.getSize());
    }
}
