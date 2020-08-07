package top.woohoo.tree;

import org.junit.Test;
import top.woohoo.tree.segment.SegmentTree;

public class SegmentTreeTest {

    @Test
    public void basicTest() {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        // Integer::sum == (valueA, valueB) -> valueA + valueB
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, Integer::sum);

        System.out.println(segmentTree.query(0, 2));
        System.out.println(segmentTree.query(2, 5));
        System.out.println(segmentTree.query(0, 5));
    }
}
