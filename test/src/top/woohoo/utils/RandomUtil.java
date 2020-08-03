package top.woohoo.utils;

/**
 * 用于生成随机数组以供测试。
 * 目前支持整型、浮点型、字符型。
 * 想支持泛型但随机生成方法不会整。
 *
 * @author Emmettwoo
 */
public class RandomUtil {

    public static Integer[] generateIntArray(int size, int min, int max) {
        Integer[] target = new Integer[size];
        for (int i = 0; i < size; i++) {
            target[i] = (int)(min+Math.random()*(max-min+1));
        }
        return target;
    }

    // 生成泛型数组
    @SuppressWarnings({ "unchecked", "hiding" })
    public static Integer[] generateIntArrayNearlyOrdered(int size, int swapTimes) {
        Integer target[] = new Integer[size];
        for (int i=0; i<size-1; i++) {
            target[i] = i;
        }

        for (int i=0; i<swapTimes; i++) {
            int indexA = (int)(Math.random()*(size));
            int indexB = (int)(Math.random()*(size));

            Integer temp = target[indexA];
            target[indexA] = target[indexB];
            target[indexB] = temp;
        }

        return target;
    }

    public static Double[] generateDoubleArray(int size, double min, double max) {
        Double[] target = new Double[size];
        for (int i = 0; i < size; i++) {
            target[i] = min+Math.random()*(max-min+1);
        }
        return target;
    }

    public static Character[] generateCharacterArray(int size, char min, char max) {
        Character[] target = new Character[size];
        for (int i = 0; i < size; i++) {
            target[i] = (char)(min+Math.random()*(max-min+1));
        }
        return target;
    }
}