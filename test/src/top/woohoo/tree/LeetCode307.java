package top.woohoo.tree;

import top.woohoo.tree.segment.SegmentTree;

import java.util.Arrays;

public class LeetCode307 {

    private static final int[] nums = {-2, 0, 3, -5, 2, -1};

    /**
     * NumArray in this code is rename to LeetCode307.
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * obj.update(i,val);
     * int param_2 = obj.sumRange(i,j);
     */

    private final SegmentTree<Integer> segmentTree;

    public LeetCode307(int[] nums) {
        this.segmentTree = new SegmentTree<>(Arrays.stream(nums).boxed().toArray(Integer[]::new), Integer::sum);
    }

    public void update(int i, int val) {
        this.segmentTree.set(i, val);
    }

    public int sumRange(int i, int j) {
        return this.segmentTree.query(i, j);
    }

    public static void main(String[] args) {
        LeetCode307 obj = new LeetCode307(nums);
        int treeSize = obj.segmentTree.getSize();
        for (int index = 0; index < treeSize; index++) {
            System.out.print(obj.sumRange(0, index));
            if (index != treeSize - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
        obj.update(2, 10);
        for (int index = 0; index < treeSize; index++) {
            System.out.print(obj.sumRange(0, index));
            if (index != treeSize - 1) {
                System.out.print(" -> ");
            }
        }
    }
}
