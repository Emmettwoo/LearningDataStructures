package top.woohoo.tree;

public class LeetCode211 {

    /**
     * Your LeetCode211 object will be instantiated and called as such:
     * LeetCode211 obj = new LeetCode211();
     * obj.addWord(word);
     * boolean param_2 = obj.search(word);
     */

    private final Trie trie;

    /** Initialize your data structure here. */
    public LeetCode211() {
        this.trie = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        trie.add(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return trie.fuzzySearch(word);
    }


    public static void main(String[] args) {
        LeetCode211 leetCode211 = new LeetCode211();
        leetCode211.addWord("bad");
        leetCode211.addWord("dad");
        leetCode211.addWord("mad");
        System.out.println(leetCode211.search("pad"));
        System.out.println(leetCode211.search("bad"));
        System.out.println(leetCode211.search(".ad"));
        System.out.println(leetCode211.search("b.."));
    }
}
