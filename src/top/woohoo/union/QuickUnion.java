package top.woohoo.union;

public class QuickUnion implements UnionFind {

    private final int[] id;

    public QuickUnion(int size) {
        this.id = new int[size];

        for (int index = 0; index < size; index++) {
            this.id[index] = index;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    @Override
    public boolean isConnected(int indexA, int indexB) {
        // O(2h) ?
        return this.find(indexA) == this.find(indexB);
    }

    @Override
    public void unionElements(int indexA, int indexB) {
        if (this.isOverflow(indexA) || this.isOverflow(indexB)) {
            throw new IllegalArgumentException("Index overflow, find failed");
        } else {
            // O(2h) ?
            id[this.find(indexB)] = this.find(indexA);
        }
    }

    private int find(int index) {
        if (this.isOverflow(index)) {
            throw new IllegalArgumentException("Index overflow, find failed");
        } else {
            // O(h)
            while (index != id[index]) {
                index = id[index];
            }
            return index;
        }
    }
    private boolean isOverflow(int index) {
        return index < 0 || index >= id.length;
    }
}
