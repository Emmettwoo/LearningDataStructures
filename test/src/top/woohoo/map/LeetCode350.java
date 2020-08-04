package top.woohoo.map;

import top.woohoo.array.Array;

public class LeetCode350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        BSTMap<Integer, Integer> set = new BSTMap<>();
        Array<Integer> list = new Array<>();

        // nums1计数
        for (int number : nums1) {
            if (set.contains(number)) {
                set.set(number, set.get(number) + 1);
            } else {
                set.add(number, 1);
            }
        }

        // nums2求同
        for (int number : nums2) {
            if (set.contains(number) && set.get(number) > 0) {
                list.add(number);
                set.set(number, set.get(number) - 1);
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

        int[] nums1 = {4, 4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};

        LeetCode350 leetCode350 = new LeetCode350();
        int[] results = leetCode350.intersect(nums1, nums2);

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
