package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/balanced-brackets/problem
 */
public class BalancedBrackets {
    static String isBalanced(String s) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                }
                Character top = stack.peek();
                if ((ch == '}' && top.charValue() == '{')
                        || (ch == ']' && top.charValue() == '[')
                        || (ch == ')' && top.charValue() == '(')) {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            String result = isBalanced(s);
            System.out.println(result);
        }
        in.close();
    }
}
