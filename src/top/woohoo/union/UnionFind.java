package top.woohoo.union;

public interface UnionFind {

    int getSize();
    // 查询是否从属同一集合
    boolean isConnected(int indexA, int indexB);
    // 合并两数的集合
    void unionElements(int indexA, int indexB);
}
