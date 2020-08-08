package top.woohoo.array;

public class LeetCode307 {

    private static final int[] nums = {-2, 0, 3, -5, 2, -1};

    /**
     * NumArray in this code is rename to LeetCode307.
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * obj.update(i,val);
     * int param_2 = obj.sumRange(i,j);
     */

    private final Array<Integer> array;

    public LeetCode307(int[] nums) {
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


    public void update(int i, int val) {
        int rawValue = this.array.get(i + 1) - this.array.get(i);
        System.out.println("rawValue: " + rawValue);
        int difference = val - rawValue;
        System.out.println("difference: " + difference);
        int arraySize = this.array.getSize();
        for (int index = i + 1; index < arraySize; index++) {
            this.array.set(index, this.array.get(index) + difference);
        }
        System.out.println(this.array);
    }

    public int sumRange(int i, int j) {
        return this.array.get(j + 1) - this.array.get(i);
    }


    public static void main(String[] args) {
        LeetCode307 obj = new LeetCode307(nums);
        obj.update(2, 10);
    }
}
