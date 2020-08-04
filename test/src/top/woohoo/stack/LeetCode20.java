package top.woohoo.stack;

public class LeetCode20 {
    public boolean isValid(String s) {
        ArrayStack<Character> stack = new ArrayStack<>();

        for (int index = 0; index < s.length(); index++) {
            char target = s.charAt(index);
            if (target == '{' || target == '[' || target == '(') {
                stack.push(target);
            } else {
                if (!stack.isEmpty()) {
                    char topValue = stack.pop();
                    if (target == '}' && topValue != '{') {
                        return false;
                    } else if (target == ']' && topValue != '[') {
                        return false;
                    } else if (target == ')' && topValue != '(') {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String testData = "[{{([()])}}]";

        LeetCode20 leetCode20 = new LeetCode20();

        System.out.println(leetCode20.isValid(testData));
    }
}
