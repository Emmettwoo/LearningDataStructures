package top.woohoo.table;

import org.junit.Test;
import top.woohoo.utils.FileUtil;
import top.woohoo.utils.TimingUtil;

import java.util.ArrayList;

public class HashTableTest {

    @Test
    public void txtWordTimesCount() {
        ArrayList<String> testData = new ArrayList<>();
        FileUtil.readFile("./test/resources/pride-and-prejudice.txt", testData);
        System.out.println("Total words: " + testData.size());

        HashTable<String, Integer> hashTable = new HashTable<>();
        for (String data : testData) {
            if (hashTable.contains(data)) {
                hashTable.set(data, hashTable.get(data) + 1);
            } else {
                hashTable.add(data, 1);
            }
        }
        System.out.println("Total different words: " + hashTable.getSize());

        System.out.println("Frequency of 'pride': " + hashTable.get("pride"));
        System.out.println("Frequency of 'prejudice': " + hashTable.get("prejudice"));
    }

    @Test
    public void selfTimeCompare() {
        /*
        Test Data: <pride and prejudice> (125901 words)
        default Capacity(97): Total Time: 90 ms
        dataSize Capacity: Total Time: 44 ms
        */

        ArrayList<String> testData = new ArrayList<>();
        FileUtil.readFile("./test/resources/pride-and-prejudice.txt", testData);
        System.out.println("Total words: " + testData.size());

        TimingUtil.StartRecordTime();
        HashTable<String, Integer> hashTable1 = new HashTable<>();
        for (String data : testData) {
            if (hashTable1.contains(data)) {
                hashTable1.set(data, hashTable1.get(data) + 1);
            } else {
                hashTable1.add(data, 1);
            }
        }
        TimingUtil.EndedRecordTime();
        System.out.println("default Capacity(97): " + TimingUtil.getTimeSpan());

        TimingUtil.StartRecordTime();
        HashTable<String, Integer> hashTable2 = new HashTable<>(testData.size());
        for (String data : testData) {
            if (hashTable2.contains(data)) {
                hashTable2.set(data, hashTable2.get(data) + 1);
            } else {
                hashTable2.add(data, 1);
            }
        }
        TimingUtil.EndedRecordTime();
        System.out.println("dataSize Capacity: " + TimingUtil.getTimeSpan());
    }
}
