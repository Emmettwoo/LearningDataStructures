package top.woohoo.stack;

import org.junit.Test;

public class ArrayStackTest {
    @Test
    public void NegativeOverflowTest() {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();

        for (int i = 0; i < 2; i++) {
            arrayStack.push(i);
            System.out.println(arrayStack);
        }
        System.out.println("取出顶部元素: " + arrayStack.pop());
        System.out.println(arrayStack);
        System.out.println("取出顶部元素: " + arrayStack.pop());
        System.out.println(arrayStack);
        // System.out.println("取出顶部元素: " + arrayStack.pop());
        // System.out.println(arrayStack);
    }

    @Test
    public void ExpansionTest() {
        ArrayStack<Integer> arrayStack = new ArrayStack<>(2);

        for (int i = 0; i < 6; i++) {
            arrayStack.push(i);
            System.out.println(arrayStack);
        }
    }
}
