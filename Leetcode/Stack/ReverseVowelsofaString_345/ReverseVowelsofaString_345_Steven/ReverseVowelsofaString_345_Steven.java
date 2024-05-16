package Stack.ReverseVowelsofaString_345.ReverseVowelsofaString_345_Steven;

import java.util.Stack;

public class ReverseVowelsofaString_345_Steven {
  public static String reverseVowels(String s) {
    char[] cs = s.toCharArray();

    int size = cs.length;
    String vowels = "aeiouAEIOU";
    Stack<String> stack = new Stack<>();

    for (int i = 0; i < size; i++) {
      String now = String.valueOf(cs[i]);

      if (vowels.contains(now)) {
        stack.push(now);
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < size; i++) {
      String now = String.valueOf(cs[i]);

      if (vowels.contains(now)) {
        now = stack.pop();
      }

      sb.append(now);
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    String s = "hello";
    System.out.println(reverseVowels(s));
  }
}
