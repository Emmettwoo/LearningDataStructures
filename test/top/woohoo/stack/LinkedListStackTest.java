package top.woohoo.stack;

import org.junit.Test;

public class LinkedListStackTest {

    @Test
    public void NegativeOverflowTest() {
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();

        for (int i = 0; i < 2; i++) {
            linkedListStack.push(i);
            System.out.println(linkedListStack);
        }
        System.out.println("取出顶部元素: " + linkedListStack.pop());
        System.out.println(linkedListStack);
        System.out.println("取出顶部元素: " + linkedListStack.pop());
        System.out.println(linkedListStack);
        // System.out.println("取出顶部元素: " + linkedListStack.pop());
        // System.out.println(linkedListStack);
    }
}
