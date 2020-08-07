package top.woohoo.array;

public class LeetCode303 {

    private static final int[] nums = {-2, 0, 3, -5, 2, -1};

    /**
     * NumArray in this code is rename to LeetCode303.
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(i,j);
     */

    private final Array<Integer> array;

    public LeetCode303(int[] nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException("Array is empty!");
        }
        array = new Array<>(nums.length + 1);
        array.add(0, 0);
        for (int index = 1; index <= nums.length; index++) {
            array.add(index, array.get(index - 1) + nums[index - 1]);
        }
        System.out.println(array);
    }

    public int sumRange(int i, int j) {
        return this.array.get(j + 1) - this.array.get(i);
    }

    public static void main(String[] args) {
        LeetCode303 obj = new LeetCode303(nums);
        System.out.println(obj.sumRange(0, 2));
        System.out.println(obj.sumRange(2, 5));
        System.out.println(obj.sumRange(0, 5));
    }
}
