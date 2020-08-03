package top.woohoo.set;

import org.junit.Test;
import top.woohoo.utils.FileUtil;

import java.util.ArrayList;

public class LinkedListSetTest {

    @Test
    public void txtWordsCount() {
        ArrayList<String> testData = new ArrayList<>();
        FileUtil.readFile("./test/resources/pride-and-prejudice.txt", testData);
        System.out.println("Total words: " + testData.size());

        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        for (String data : testData) {
            linkedListSet.add(data);
        }
        System.out.println("Total different words: " + linkedListSet.getSize());
    }
}
