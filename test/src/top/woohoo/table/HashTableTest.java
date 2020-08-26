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

        // System.out.println("Total different words: " + hashTable.getSize());
        // System.out.println("Frequency of 'pride': " + hashTable.get("pride"));
        // System.out.println("Frequency of 'prejudice': " + hashTable.get("prejudice"));

        for (String data : testData) {
            hashTable.remove(data);
        }
    }
}
