
import java.util.Objects;
import java.util.Stack;
import java.util.function.IntPredicate;

public class StringUtil {

    public static boolean isValid(String s) {

        return  isValidValue(s) &&
                isValidLength(s) &&
                isLowerCaseAndParenthesesChars(s) &&
                isBalancedParentheses(s);
    }

    public static boolean isValidValue(String s) {
        return !s.isEmpty() || s.length() != 0 || Objects.nonNull(s);
    }

    public static boolean isValidLength(String s) {
        final int MIN_LENGTH = 1;
        final int MAX_LENGTH = 2000;

        return (s.length() >= MIN_LENGTH && s.length() <= MAX_LENGTH);
    }

    public static boolean isLowerCaseAndParenthesesChars(String s) {

        IntPredicate intPredicate = ch -> Character.isLowerCase(ch) ||
                ch == '(' || ch == ')';
        return s.chars()
                .allMatch(intPredicate);
    }
    public static boolean isBalancedParentheses(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(')
                stack.push(ch);

            if (ch == ')') {
                if (stack.isEmpty()) return false;

                Character top = stack.pop();
                if (!bracketsMatch(top, ch)) return false;
            }
        }

        return stack.isEmpty();
    }

    public static boolean bracketsMatch(char left, char right) {
        return left == '('  && right == ')';
    }

}

