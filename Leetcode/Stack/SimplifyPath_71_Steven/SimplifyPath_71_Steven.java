package Stack.SimplifyPath_71_Steven;

import java.util.Stack;

public class SimplifyPath_71_Steven {
  public static String simplifyPath(String path) {
    String[] toks = path.split("/");
    Stack<String> stack = new Stack<>();

    for (String tok : toks) {
      if (tok.isEmpty() || tok.equals(".")) {
        continue;
      }

      if (tok.equals("..")) {
        if (!stack.isEmpty()) {
          stack.pop();
        }
      } else {
        stack.add(tok);
      }
    }

    String res = String.join("/", stack);
    return "/" + res;
  }

  public static void main(String[] args) {
    String path = "/../../test/st/./..//test";
    String res = simplifyPath(path);

    System.out.println("Res: " + res);

  }

}
