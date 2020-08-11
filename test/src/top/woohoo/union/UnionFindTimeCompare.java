package top.woohoo.union;

import top.woohoo.utils.RandomUtil;
import top.woohoo.utils.TimingUtil;

public class UnionFindTimeCompare {

    private static final int DATA_SIZE = 1000000;
    private static final int OPERA_TIME = 1000000;
    /*
        WHEN DATA_SIZE = 100000 & OPERA_TIME = 10000:
        quickFind: Total Time: 227 ms
        quickUnion: Total Time: 2 ms
        ---
        WHEN DATA_SIZE = 100000 & OPERA_TIME = 100000:
        quickFind: Total Time: 4417 ms
        quickUnion: Total Time: 9865 ms
        ---
        WHEN DATA_SIZE = 100000 & OPERA_TIME = 100000:
        quickFind: Total Time: 4440 ms
        quickUnionSizeOptimize: Total Time: 22 ms
        ---
        WHEN DATA_SIZE = 1000000 & OPERA_TIME = 1000000:
        quickUnionSizeOptimize: Total Time: 503 ms
        quickUnionRankOptimize: Total Time: 450 ms
        quickUnionPathCompression: Total Time: 266 ms
     */

    public static void main(String[] args) {
        QuickFind quickFind = new QuickFind(DATA_SIZE);
        QuickUnion quickUnion = new QuickUnion(DATA_SIZE);
        QuickUnionSizeOptimize quickUnionSizeOptimize = new QuickUnionSizeOptimize(DATA_SIZE);
        QuickUnionRankOptimize quickUnionRankOptimize = new QuickUnionRankOptimize(DATA_SIZE);
        QuickUnionPathCompression quickUnionPathCompression = new QuickUnionPathCompression(DATA_SIZE);

        TimingUtil.StartRecordTime();
        for (int index = 0; index < OPERA_TIME; index++) {
            quickUnionSizeOptimize.unionElements(RandomUtil.generateInteger(0, DATA_SIZE), RandomUtil.generateInteger(0, DATA_SIZE));
        }
        for (int index = 0; index < OPERA_TIME; index++) {
            quickUnionSizeOptimize.isConnected(RandomUtil.generateInteger(0, DATA_SIZE), RandomUtil.generateInteger(0, DATA_SIZE));
        }
        TimingUtil.EndedRecordTime();
        System.out.println("quickUnionSizeOptimize: " + TimingUtil.getTimeSpan());

        TimingUtil.StartRecordTime();
        for (int index = 0; index < OPERA_TIME; index++) {
            quickUnionRankOptimize.unionElements(RandomUtil.generateInteger(0, DATA_SIZE), RandomUtil.generateInteger(0, DATA_SIZE));
        }
        for (int index = 0; index < OPERA_TIME; index++) {
            quickUnionRankOptimize.isConnected(RandomUtil.generateInteger(0, DATA_SIZE), RandomUtil.generateInteger(0, DATA_SIZE));
        }
        TimingUtil.EndedRecordTime();
        System.out.println("quickUnionRankOptimize: " + TimingUtil.getTimeSpan());

        TimingUtil.StartRecordTime();
        for (int index = 0; index < OPERA_TIME; index++) {
            quickUnionPathCompression.unionElements(RandomUtil.generateInteger(0, DATA_SIZE), RandomUtil.generateInteger(0, DATA_SIZE));
        }
        for (int index = 0; index < OPERA_TIME; index++) {
            quickUnionPathCompression.isConnected(RandomUtil.generateInteger(0, DATA_SIZE), RandomUtil.generateInteger(0, DATA_SIZE));
        }
        TimingUtil.EndedRecordTime();
        System.out.println("quickUnionPathCompression: " + TimingUtil.getTimeSpan());
    }
}
