package top.woohoo.map;

import top.woohoo.array.Array;
import top.woohoo.set.BSTSet;

public class LeetCode349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        BSTSet<Integer> set = new BSTSet<>();
        Array<Integer> list = new Array<>();

        // nums1去重
        for (int number : nums1) {
            set.add(number);
        }

        // nums2求同
        for (int number : nums2) {
            if (set.contains(number)) {
                list.add(number);
                // 删除set中的元素，保证nums2中重复元素不会被重复添加
                set.remove(number);
            }
        }

        // 转换结果集
        int [] results = new int[list.getSize()];
        for (int index = 0; index < list.getSize(); index++) {
            results[index] = list.get(index);
        }
        return results;
    }

    public static void main(String[] args) {

        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};

        LeetCode349 leetCode349 = new LeetCode349();
        int[] results = leetCode349.intersection(nums1, nums2);

        System.out.print("[");
        for (int index = 0; index < results.length; index++) {
            System.out.print(results[index]);
            if (index != results.length - 1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
}
