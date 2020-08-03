package top.woohoo.set;

public class LeetCode804 {

    private static String[] words = {"test", "one", "two", "three", "gin", "zen", "gig", "msg"};

    public static void main(String[] args) {
        String[] morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        // 使用Set存储，会自动排除重复元素
        BSTSet<String> set = new BSTSet<>();
        // 遍历每一个word并转换成morseCode存储
        for (String word : words) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int index = 0; index < word.length(); index++) {
                stringBuilder.append(morseCode[word.charAt(index) - 'a']);
            }
            set.add(stringBuilder.toString());
        }
        System.out.println(set.getSize());
    }
}
