package top.woohoo.union;

public class QuickUnionRankOptimize implements UnionFind {

    private final int[] id;
    // rank = depth.
    private final int[] rank;

    public QuickUnionRankOptimize(int size) {
        this.id = new int[size];
        this.rank = new int[size];

        for (int index = 0; index < size; index++) {
            this.id[index] = index;
            this.rank[index] = 1;
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
            int rootA = this.find(indexA);
            int rootB = this.find(indexB);

            if (rootA != rootB) {
                if (rank[rootA] < rank[rootB]) {
                    id[rootA] = rootB;
                } else if(rank[rootA] > rank[rootB]) {
                    id[rootB] = rootA;
                } else {
                    id[rootA] = rootB;
                    rank[rootB]++;
                }
            }
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
