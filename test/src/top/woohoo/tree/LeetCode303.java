package top.woohoo.tree;

import top.woohoo.tree.segment.SegmentTree;

import java.util.Arrays;

public class LeetCode303 {

    private static final int[] nums = {-2, 0, 3, -5, 2, -1};

    /**
     * NumArray in this code is rename to LeetCode303.
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(i,j);
     */

    private final SegmentTree<Integer> segmentTree;

    public LeetCode303(int[] nums) {
        this.segmentTree = new SegmentTree<>(Arrays.stream(nums).boxed().toArray(Integer[]::new), Integer::sum);
    }

    public int sumRange(int i, int j) {
        return this.segmentTree.query(i, j);
    }

    public static void main(String[] args) {
        LeetCode303 obj = new LeetCode303(nums);
        System.out.println(obj.sumRange(0, 2));
        System.out.println(obj.sumRange(2, 5));
        System.out.println(obj.sumRange(0, 5));
    }
}
