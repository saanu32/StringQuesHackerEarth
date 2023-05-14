import java.util.*;

public class BalancedString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // number of test cases
        scanner.nextLine(); // consume the newline character

        while (t-- > 0) {
            String str = scanner.nextLine(); // input string
            int maxLength = findMaxLengthOfBalancedString(str);
            System.out.println(maxLength);
        }

        scanner.close();
    }

    private static int findMaxLengthOfBalancedString(String str) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // sentinel value to mark the start

        int maxLength = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    int top = stack.pop();
                    if (str.charAt(top) == getOpeningBracket(c)) {
                        maxLength = Math.max(maxLength, i - stack.peek());
                    } else {
                        stack.push(i);
                    }
                } else {
                    stack.push(i);
                }
            }
        }

        return maxLength;
    }

    private static char getOpeningBracket(char closingBracket) {
        if (closingBracket == ')') {
            return '(';
        } else if (closingBracket == ']') {
            return '[';
        } else if (closingBracket == '}') {
            return '{';
        }
        return '\0';
    }
}

