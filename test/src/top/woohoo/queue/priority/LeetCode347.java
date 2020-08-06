package top.woohoo.queue.priority;

import top.woohoo.array.Array;
import top.woohoo.map.BSTMap;
import top.woohoo.map.Map;

public class LeetCode347 {

    private static final int[] testData = {5, 2, 5, 3, 5, 3, 1, 1, 3};

    private static class ValueWithCount implements Comparable<ValueWithCount> {
        int value;
        int count;

        public ValueWithCount(int value, int count) {
            this.value = value;
            this.count = count;
        }

        @Override
        public int compareTo(ValueWithCount valueWithCount) {
            return Integer.compare(valueWithCount.count, this.count);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new BSTMap<>();
        Array<Integer> array = new Array<>();

        // 将 value : count 存进map, 同时map的key形成array（毕竟没实现keySet）
        for (int num : nums) {
            if (map.contains(num)) {
                map.add(num, map.get(num) + 1);
            } else {
                map.add(num, 1);
                array.add(num);
            }
        }

        // 循环插入map元素到priorityQueue（仅保留k个）
        PriorityQueue<ValueWithCount> priorityQueue = new PriorityQueue<>();
        for (int index = 0; index < array.getSize(); index++) {
            int key = array.get(index);
            if (priorityQueue.getSize() < k) {
                priorityQueue.enqueue(new ValueWithCount(key, map.get(key)));
            } else if (map.get(key) > priorityQueue.getFront().count){
                priorityQueue.dequeue();
                priorityQueue.enqueue(new ValueWithCount(key, map.get(key)));
            }
        }

        // 转换结果集
        int [] results = new int[k];
        for (int index = 0; index < k; index++) {
            results[index] = priorityQueue.dequeue().value;
        }
        return results;
    }

    public static void main(String[] args) {
        LeetCode347 leetCode347 = new LeetCode347();
        int[] result = leetCode347.topKFrequent(testData, 2);

        System.out.print("[");
        for (int index = 0; index < result.length; index++) {
            System.out.print(result[index]);
            if (index + 1 != result.length) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}
