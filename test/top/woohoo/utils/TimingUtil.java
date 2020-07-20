package top.woohoo.utils;

/**
 * 用于计算测试用例花费的时间。
 * Java使用13bit时间戳，单位为ms。
 *
 * @author Emmettwoo
 */
public class TimingUtil {

    private static long startTimeStamp = 0;
    private static long endedTimeStamp = 0;


    public static void StartRecordTime() {
        startTimeStamp = System.currentTimeMillis();
    }

    public static void EndedRecordTime() {
        endedTimeStamp = System.currentTimeMillis();
    }

    public static String getTimeSpan() {
        return "Total Time: " + (endedTimeStamp - startTimeStamp) + " ms";
    }


    public static long getStartTimeStamp() {
        return startTimeStamp;
    }

    public static long getEndedTimeStamp() {
        return endedTimeStamp;
    }
}