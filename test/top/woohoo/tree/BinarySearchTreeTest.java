package top.woohoo.tree;

import org.junit.Test;
import top.woohoo.utils.RandomUtil;

public class BinarySearchTreeTest {

    private BinarySearchTree<Integer> generateIntegerTree(int size, int min, int max) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        Integer[] testData = RandomUtil.generateIntArray(size, min, max);
        System.out.print("Test Data: ");
        for (Integer value : testData) {
            binarySearchTree.add(value);
            System.out.print(value + " -> ");
        }
        System.out.println("NULL");
        return binarySearchTree;
    }

    @Test
    public void removeMinAndMaxTest() {
        BinarySearchTree<Integer> binarySearchTree = this.generateIntegerTree(10, 0, 100);

        binarySearchTree.preOrder();
        System.out.println("移除最小元素: " + binarySearchTree.removeMin());
        System.out.println("移除最大元素: " + binarySearchTree.removeMax());
        binarySearchTree.levelOrder();
    }

    @Test
    public void removeTargetValueTest() {
        BinarySearchTree<Integer> binarySearchTree = this.generateIntegerTree(10, 0, 100);

        System.out.print("level order: ");
        binarySearchTree.levelOrder();

        int targetValue = 0;
        while (!binarySearchTree.isEmpty() && targetValue < 100) {
            System.out.println("移除指定元素: " + targetValue);
            binarySearchTree.remove(targetValue++);
            System.out.print("level order: ");
            binarySearchTree.levelOrder();
        }
    }

    @Test
    public void getFloorAndCeilTest() {
        BinarySearchTree<Integer> binarySearchTree = this.generateIntegerTree(10, 0, 100);

        binarySearchTree.levelOrder();

        int targetValue = 42;
        System.out.println(targetValue + "'s floor node value: " + binarySearchTree.getFloor(targetValue).value);
        System.out.println(targetValue + "'s ceil node value: " + binarySearchTree.getCeil(targetValue).value);
    }

    @Test
    public void nodeToStringTest() {
        BinarySearchTree<Integer> binarySearchTree = this.generateIntegerTree(20, 0, 10);
        binarySearchTree.levelOrder();
        System.out.println(binarySearchTree.getMax(binarySearchTree.getRoot()));
        System.out.println(binarySearchTree.getRoot().right);
        binarySearchTree.removeMax();
        System.out.println(binarySearchTree.getRoot().right);

    }
}
