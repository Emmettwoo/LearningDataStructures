package top.woohoo.list;

import org.junit.Test;

public class SinglyLinkedListTest {

    @Test
    public void BasicTest() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
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
}
