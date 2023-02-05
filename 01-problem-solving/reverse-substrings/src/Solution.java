import java.util.Stack;

public class Solution {

    public static String reverseParentheses(String s) {

        if (!StringUtil.isValid(s)) return s;

        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        int i = 0;

        while (s.length() > i){

            if(s.charAt(i) == '(') {
                res.append(s.charAt(i++));
                while (s.charAt(i) != ')') {
                    stack.push(s.charAt(i));
                    i++;
                }
            }

            else if (s.charAt(i) == ')') {
                while (!stack.isEmpty())
                    res.append(stack.pop());
                res.append(s.charAt(i));
                i++;
            }

            else {
                res.append(s.charAt(i));
                i++;
            }
        }

        return res.toString();
    }
}
