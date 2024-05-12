package Stack.ValidParentheses_20_Steven;

import java.util.*;

public class ValidParentheses_20_Steven {
  public static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();

    if (s.length() <= 1) {
      return false;
    }

    char[] cStr = s.toCharArray();
    int size = cStr.length;

    for (int i = 0; i < size; i++) {
      char now = cStr[i];

      if (now == '(' || now == '{' || now == '[') {
        stack.add(now);
      } else {
        if (stack.isEmpty()) {
          return false;
        }

        char openParen = stack.pop();

        if (!((openParen == '(' && now == ')')
            || (openParen == '{' && now == '}')
            || (openParen == '[' && now == ']'))) {
          return false;
        }
      }
    }

    return stack.empty();
  }

  public static void main(String[] args) {
    boolean res = isValid("){");
    System.out.println("Res: " + res);
  }
}
