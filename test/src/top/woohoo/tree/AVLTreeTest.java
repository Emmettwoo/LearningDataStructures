package top.woohoo.tree;

import org.junit.Test;
import top.woohoo.utils.FileUtil;

import java.util.ArrayList;

public class AVLTreeTest {

    @Test
    public void txtWordTimesCount() {
        ArrayList<String> testData = new ArrayList<>();
        FileUtil.readFile("./test/resources/pride-and-prejudice.txt", testData);
        System.out.println("Total words: " + testData.size());

        AVLTree<String, Integer> avlTree = new AVLTree<>();
        for (String data : testData) {
            if (avlTree.contains(data)) {
                avlTree.set(data, avlTree.get(data) + 1);
            } else {
                avlTree.add(data, 1);
            }
        }
        System.out.println("Total different words: " + avlTree.getSize());

        System.out.println("Frequency of 'pride': " + avlTree.get("pride"));
        System.out.println("Frequency of 'prejudice': " + avlTree.get("prejudice"));
        System.out.println("isBST: " + avlTree.isBST());
        System.out.println("isBalance: " + avlTree.isBalance());

        for (String data : testData) {
            avlTree.remove(data);
            if (!avlTree.isBST() || !avlTree.isBalance()) {
                throw new RuntimeException("AVL Balance Error");
            }
        }
    }
}
