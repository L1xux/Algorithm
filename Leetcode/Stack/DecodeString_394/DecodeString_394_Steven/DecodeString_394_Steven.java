package Stack.DecodeString_394.DecodeString_394_Steven;

import java.util.Stack;

public class DecodeString_394_Steven {

  public static boolean isNumeric(String str) {
    try {
      Double.parseDouble(str);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  public static String decodeString(String s) {
    StringBuilder res = new StringBuilder();

    StringBuilder targetStr = new StringBuilder();
    char[] cs = s.toCharArray();
    int size = cs.length;

    Stack<String> stack = new Stack<>();

    for (int i = 0; i < size; i++) {
      char now = cs[i];

      if (now == ']') {
        String pop = stack.pop();
        while (!pop.equals("[")) {
          targetStr.insert(0, pop);
          pop = stack.pop();
        }

        String target = targetStr.toString();
        targetStr = new StringBuilder();

        while (!stack.isEmpty() && isNumeric(stack.peek())) {
          pop = stack.pop();
          targetStr.insert(0, pop);
        }

        int mul = Integer.parseInt(targetStr.toString());
        targetStr = new StringBuilder();

        for (int x = 0; x < mul; x++) {
          targetStr.append(target);
        }

        target = targetStr.toString();
        targetStr = new StringBuilder();

        if (stack.isEmpty()) {
          res.append(target);
        } else {
          stack.add(target);
        }

      } else {
        stack.add(String.valueOf(now));
      }

    }

    for (String elem : stack) {
      res.append(elem);
    }

    return res.toString();
  }

  public static void main(String[] args) {
    String s = "3[a10[c]]";
    String res = decodeString(s);

    System.out.println("Res: " + res);
  }
}
