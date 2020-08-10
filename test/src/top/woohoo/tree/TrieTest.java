package top.woohoo.tree;

import org.junit.Test;

public class TrieTest {

    @Test
    public void repeatValueTest() {
        Trie trie = new Trie();
        trie.add("test");
        trie.add("test");
        trie.addWithRecursion("test");
        trie.addWithRecursion("test");
        System.out.println(trie.contains("test"));
        System.out.println(trie.getSize());
    }

    @Test
    public void fuzzyMatchTest() {
        Trie trie = new Trie();
        trie.add("test");
        System.out.println(trie.contains("test"));
        System.out.println(trie.fuzzySearch(".est"));
        System.out.println(trie.fuzzySearch("te.t"));
        System.out.println(trie.fuzzySearch("tes."));
        System.out.println(trie.fuzzySearch("t.s."));
        System.out.println(trie.fuzzySearch(".e.."));
        System.out.println(trie.fuzzySearch("...."));
        System.out.println(trie.fuzzySearch("done"));
    }
}
