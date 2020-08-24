package top.woohoo.tree;

import org.junit.Test;
import top.woohoo.utils.FileUtil;

import java.util.ArrayList;

public class RedBlackTreeTest {

    @Test
    public void txtWordTimesCount() {
        ArrayList<String> testData = new ArrayList<>();
        FileUtil.readFile("./test/resources/pride-and-prejudice.txt", testData);
        System.out.println("Total words: " + testData.size());

        RedBlackTree<String, Integer> redBlackTree = new RedBlackTree<>();
        for (String data : testData) {
            if (redBlackTree.contains(data)) {
                redBlackTree.set(data, redBlackTree.get(data) + 1);
            } else {
                redBlackTree.add(data, 1);
            }
        }
        System.out.println("Total different words: " + redBlackTree.getSize());
        System.out.println("Frequency of 'pride': " + redBlackTree.get("pride"));
        System.out.println("Frequency of 'prejudice': " + redBlackTree.get("prejudice"));
    }
}
