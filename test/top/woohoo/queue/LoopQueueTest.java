package top.woohoo.queue;

import org.junit.Test;

public class LoopQueueTest {
    @Test
    public void NegativeOverflowTest() {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();

        for (int i = 0; i < 2; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
        }
        System.out.println("取出队首元素: " + loopQueue.dequeue());
        System.out.println(loopQueue);
        System.out.println("取出队首元素: " + loopQueue.dequeue());
        System.out.println(loopQueue);
        // System.out.println("取出队首元素: " + loopQueue.dequeue());
        // System.out.println(loopQueue);
    }

    @Test
    public void ExpansionAndShrinkageTest() {
        LoopQueue<Integer> loopQueue = new LoopQueue<>(32);
        // 将队列存满（此时触发扩容）
        for (int i = 1; i <= 32; i++) {
            loopQueue.enqueue(i);
        }
        System.out.println(loopQueue);
        // 使队列减半（因上面的扩容，此次触发缩容）
        for (int i = 1; i <= 16; i++) {
            loopQueue.dequeue();
        }
        System.out.println(loopQueue);

        // 由于队列尾已满，下面两个index分别是0和1
        loopQueue.enqueue(1024);
        loopQueue.enqueue(2048);
        System.out.println(loopQueue);
        // 尝试触发缩容操作（验证队列头部数据是否被遗漏）
        for (int i = 1; i <= 10; i++) {
            loopQueue.dequeue();
        }
        System.out.println(loopQueue);
    }
}
