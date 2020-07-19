package top.woohoo.array;

import org.junit.Test;

public class ArrayTest {

    @Test
    public void ExpansionAndShrinkageTest() {
        Array<Integer> array = new Array<>(32);
        Integer[] temp = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        array.addBatch(0, temp);
        array.show();
        array.removeByIndex(9);
        array.show();
        array.removeByIndex(8);
        array.show();

        array.addBatch(temp);
        array.show();
        array.removeAll();
        array.show();
    }
}
