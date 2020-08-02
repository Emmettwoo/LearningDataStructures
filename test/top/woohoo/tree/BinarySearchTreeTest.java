package top.woohoo.tree;

import org.junit.Test;
import top.woohoo.utils.RandomUtil;

public class BinarySearchTreeTest {

    @Test
    public void removeMinAndMaxTest() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        Integer[] testData = RandomUtil.generateIntArray(10, 0, 100);
        for (Integer value : testData) {
            binarySearchTree.add(value);
        }
        binarySearchTree.preOrder();
        System.out.println("移除最小元素: " + binarySearchTree.removeMin());
        System.out.println("移除最大元素: " + binarySearchTree.removeMax());
        binarySearchTree.levelOrder();
    }

    @Test
    public void removeTargetValueTest() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        Integer[] testData = RandomUtil.generateIntArray(10, 0, 100);

        for (Integer value : testData) {
            binarySearchTree.add(value);
        }
        System.out.print("level order: ");
        binarySearchTree.levelOrder();

        int removeTargetValue = 0;
        while (!binarySearchTree.isEmpty() && removeTargetValue < 100) {
            System.out.println("移除指定元素: " + removeTargetValue);
            binarySearchTree.remove(removeTargetValue++);
            System.out.print("level order: ");
            binarySearchTree.levelOrder();
        }
    }
}
