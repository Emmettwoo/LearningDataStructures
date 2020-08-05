package top.woohoo.heap;

import top.woohoo.array.Array;

public class BinaryMaxHeap<T extends Comparable<T>> implements Heap<T> {

    private final Array<T> data;


    // Constructors
    public BinaryMaxHeap(int capacity) {
        data = new Array<>(capacity);
    }
    public BinaryMaxHeap() {
        data = new Array<>();
    }


    // 数据操作（基础）
    @Override
    public void add(T value) {
        data.add(value);
        this.siftUp(data.getSize() - 1);
    }
    @Override
    public T getMax() {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("Heap is Empty");
        } else {
            return data.get(0);
        }
    }
    @Override
    public T extractMax() {
        T value = this.getMax();
        this.swap(0, data.getSize() - 1);
        data.removeLast();
        this.siftDown(0);
        return value;
    }

    // 数据操作（高级）
    @Override
    public T replace(T value) {
        T maxValue = this.getMax();
        data.set(0, value);
        this.siftDown(0);
        return maxValue;
    }


    // 数据判断
    @Override
    public int getSize() {
        return data.getSize();
    }
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }


    // 获取父节点和子节点的索引
    private int getParent(int index) {
        if (index <= 0) {
            throw new IllegalArgumentException("Index doesn't have parent");
        } else {
            return (index - 1) / 2;
        }
    }
    private int getLeftChild(int index) {
        return index * 2 + 1;
    }
    private int getRightChild(int index) {
        return index * 2 + 2;
    }

    // 调整元素位置
    private void siftUp(int index) {
        while (index > 0 && data.get(index).compareTo(data.get(this.getParent(index))) > 0) {
            this.swap(index, this.getParent(index));
            index = this.getParent(index);
        }
    }
    private void siftDown(int index) {
        int dataSize = data.getSize();

        while (this.getLeftChild(index) < dataSize) {
            int biggerChildIndex = this.getLeftChild(index);

            // 取其左右孩子中的较大值
            if (biggerChildIndex + 1 < dataSize) {
                if (data.get(biggerChildIndex).compareTo(data.get(biggerChildIndex + 1)) < 0) {
                    // 初始化为默认左孩子大，此处+1索引为其右孩子。
                    biggerChildIndex++;
                }
            }

            // 节点值大于其左右孩子，满足堆的设定，下沉完成
            if (data.get(index).compareTo(data.get(biggerChildIndex)) >= 0) {
                break;
            }

            // 交换值，继续下沉
            this.swap(index, biggerChildIndex);
            index = biggerChildIndex;
        }
    }
    private void swap(int oldIndex, int newIndex) {
        T temp = data.get(oldIndex);
        data.set(oldIndex, data.get(newIndex));
        data.set(newIndex, temp);
    }
}
