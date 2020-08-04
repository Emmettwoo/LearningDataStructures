package top.woohoo.set;

public class LeetCode804 {

    private static final String[] morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public int uniqueMorseRepresentations(String[] words) {
        // 使用Set存储，会自动排除重复元素
        Set<String> set = new BSTSet<>();
        // 遍历每一个word并转换成morseCode存储
        for (String word : words) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int index = 0; index < word.length(); index++) {
                stringBuilder.append(morseCode[word.charAt(index) - 'a']);
            }
            set.add(stringBuilder.toString());
        }
        return set.getSize();
    }

    public static void main(String[] args) {

        String[] words = {"gin", "zen", "gig", "msg"};

        LeetCode804 leetCode804 = new LeetCode804();
        System.out.println(leetCode804.uniqueMorseRepresentations(words));
    }

}
