package top.woohoo.tree.segment;

/* ※ */
public class SegmentTree<T> {

    private final Merger<T> merger;
    private final T[] data;
    private final T[] tree;


    // Constructs
    public SegmentTree(T[] array, Merger<T> merger) {

        this.merger = merger;
        this.data = array;
        if (data.length == 0) {
            throw new IllegalArgumentException("Array is empty!");
        } else {
            // 2n最优解（最底层为n个节点），4n最差情况
            tree = (T[]) new Object[4 * array.length];
            buildSegmentTree(0, 0, data.length - 1);
        }
    }


    // 构造线段树
    private void buildSegmentTree(int currentTreeIndex, int leftArrayIndex, int rightArrayIndex) {
        if (leftArrayIndex == rightArrayIndex) {
            tree[currentTreeIndex] = data[leftArrayIndex];
        } else {
            // 得到左右孩子节点的索引
            int leftTreeIndex = this.getLeftChildIndex(currentTreeIndex);
            int rightTreeIndex = this.getRightChildIndex(currentTreeIndex);

            // 用于划分左右界限的中间索引
            int middleTreeIndex = leftArrayIndex + (rightArrayIndex - leftArrayIndex) / 2;

            // 持续递归左右孩子（直到叶子节点）
            buildSegmentTree(leftTreeIndex, leftArrayIndex, middleTreeIndex);
            buildSegmentTree(rightTreeIndex, middleTreeIndex + 1, rightArrayIndex);

            // 非叶子节点，节点值为左右孩子的merge操作
            this.tree[currentTreeIndex] = this.merger.merge(this.tree[leftTreeIndex], this.tree[rightTreeIndex]);
        }
    }

    // 获取元素
    public T query(int leftQueryIndex, int rightQueryIndex) {
        if (this.isOverflow(leftQueryIndex, rightQueryIndex)) {
            throw new IllegalArgumentException("Index overflow, query failed.");
        } else {
            return query(0, 0, data.length - 1, leftQueryIndex, rightQueryIndex);
        }
    }
    private T query(int currentTreeIndex, int leftArrayIndex, int rightArrayIndex, int leftQueryIndex, int rightQueryIndex) {
        if (leftArrayIndex == leftQueryIndex && rightArrayIndex == rightQueryIndex) {
            return tree[currentTreeIndex];
        }
        // 得到左右孩子节点的索引
        int leftTreeIndex = this.getLeftChildIndex(currentTreeIndex);
        int rightTreeIndex = this.getRightChildIndex(currentTreeIndex);

        // 用于划分左右界限的中间索引
        int middleTreeIndex = leftArrayIndex + (rightArrayIndex - leftArrayIndex) / 2;

        // 左边界大于中间索引加一，说明数据全在右子树，反之亦然
        if (leftQueryIndex >= middleTreeIndex + 1) {
            return query(rightTreeIndex, middleTreeIndex + 1, rightArrayIndex, leftQueryIndex, rightQueryIndex);
        } else if (rightQueryIndex <= middleTreeIndex) {
            return query(leftTreeIndex, leftArrayIndex, middleTreeIndex, leftQueryIndex, rightQueryIndex);
        } else {
            // 请求结果分布于左右子树，分别获取后进行merge
            T leftResult = query(leftTreeIndex, leftArrayIndex, middleTreeIndex, leftQueryIndex, middleTreeIndex);
            T rightResult = query(rightTreeIndex, middleTreeIndex + 1, rightArrayIndex, middleTreeIndex + 1, rightQueryIndex);
            return this.merger.merge(leftResult, rightResult);
        }

    }
    public T get(int index) {
        if (this.isOverflow(index)) {
           throw new IllegalArgumentException("Index overflow, get failed.");
        } else {
            return data[index];
        }
    }
    public int getSize() {
        return data.length;
    }

    // 孩子元素
    private int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }
    private int getRightChildIndex(int index) {
        return index * 2 + 2;
    }

    // 条件判断
    private boolean isOverflow(int index) {
        return index < 0 || index >= data.length;
    }
    private boolean isOverflow(int leftIndex, int rightIndex) {
        return leftIndex < 0 || rightIndex >= data.length || leftIndex > rightIndex;
    }


    @Override
    public String toString() {
        int treeLength = this.tree.length;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        for (int index = 0; index < treeLength; index++) {
            if (this.tree[index] != null) {
                stringBuilder.append(this.tree[index]);
            } else {
                stringBuilder.append("NULL");
            }
            if (index != treeLength - 1) {
                stringBuilder.append(" -> ");
            }
        }
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }
}
