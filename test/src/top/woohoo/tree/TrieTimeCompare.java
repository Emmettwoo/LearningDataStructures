package top.woohoo.tree;

import top.woohoo.set.BSTSet;
import top.woohoo.utils.FileUtil;
import top.woohoo.utils.TimingUtil;

import java.util.ArrayList;

public class TrieTimeCompare {

    /*
        Test Data: <pride and prejudice> (125901 words)
        bstSet: Total Time: 41 ms
        trie: Total Time: 38 ms
     */

    public static void main(String[] args) {
        ArrayList<String> testData = new ArrayList<>();
        FileUtil.readFile("./test/resources/pride-and-prejudice.txt", testData);
        System.out.println("Total words: " + testData.size());

        TimingUtil.StartRecordTime();
        BSTSet<String> bstSet = new BSTSet<>();
        for (String data : testData) {
            bstSet.add(data);
        }
        TimingUtil.EndedRecordTime();
        System.out.println("bstSet: " + TimingUtil.getTimeSpan());

        TimingUtil.StartRecordTime();
        Trie trie = new Trie();
        for (String data : testData) {
            trie.add(data);
        }
        TimingUtil.EndedRecordTime();
        System.out.println("trie: " + TimingUtil.getTimeSpan());
    }
}
