package top.woohoo.union;

public class QuickFind implements UnionFind {

    private final int[] id;

    public QuickFind(int size) {
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
        // O(1)
        return this.find(indexA) == this.find(indexB);
    }

    @Override
    public void unionElements(int indexA, int indexB) {
        if (this.isOverflow(indexA) || this.isOverflow(indexB)) {
            throw new IllegalArgumentException("Index overflow, find failed");
        } else {
            int valueA = id[indexA];
            int valueB = id[indexB];
            if (valueA != valueB) {
                // O(n)
                for (int index = 0; index < id.length; index++) {
                    if (id[index] == valueB) {
                        id[index] = valueA;
                    }
                }
            }
        }
    }


    private int find(int index) {
        if (this.isOverflow(index)) {
            throw new IllegalArgumentException("Index overflow, find failed");
        } else {
            // O(1)
            return id[index];
        }
    }
    private boolean isOverflow(int index) {
        return index < 0 || index >= id.length;
    }
}
