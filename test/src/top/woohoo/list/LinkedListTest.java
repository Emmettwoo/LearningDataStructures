package top.woohoo.list;

import org.junit.Test;
import top.woohoo.utils.RandomUtil;

public class LinkedListTest {

    @Test
    public void BasicTest() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int value = 1; value <= 5; value++) {
            linkedList.add(value);
        }
        System.out.println(linkedList);
        linkedList.add(0, 0);
        System.out.println(linkedList);

        linkedList.remove(0);
        System.out.println(linkedList);

        linkedList.set(0, 0);
        System.out.println(linkedList);

        System.out.println(linkedList.get(0));
    }

    @Test
    public void valueOperationTest() {
        LinkedList<Integer> linkedList = this.generateIntegerLinkedList(20, 0, 10);

        linkedList.removeByValue(0);
        System.out.println("Remove Result: " + linkedList);
    }

    @Test
    public void GetTheNthElementFromTheBottom() {
        LinkedList<Integer> testData = this.generateIntegerLinkedList(11, 0, 1000);
        System.out.println(testData.findNthToTail(2));
    }

    @Test
    public void reverseLinkedList() {
        LinkedList<Integer> testData = this.generateIntegerLinkedList(11, 0, 1000);
        testData.reverse();
        System.out.println("New  Data: " + testData);
    }

    private LinkedList<Integer> generateIntegerLinkedList(int size, int min, int max) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Integer[] testData = RandomUtil.generateIntArray(size, min, max);
        System.out.print("Test Data: ");
        for (Integer value : testData) {
            linkedList.add(value);
            System.out.print(value + " -> ");
        }
        System.out.println("NULL");
        return linkedList;
    }
}
