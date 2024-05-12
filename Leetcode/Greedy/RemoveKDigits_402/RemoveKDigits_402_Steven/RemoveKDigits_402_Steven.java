package Greedy.RemoveKDigits_402_Steven;

public class RemoveKDigits_402_Steven {
  public static String removeKdigits(String num, int k) {
    char[] cNums = num.toCharArray();
    int N = num.length();

    String res = "";

    for (int i = 0; i < N - 1; i++) {
      char first = cNums[i];
      char second = cNums[i + 1];

      if (first >= second && k > 0) {
        k--;
        continue;
      }

      res += first;
    }

    if (k == 0) {
      res += cNums[N - 1];
    }

    res = Integer.parseInt(res) + "";
    return res;
  }

  public static void main(String[] args) {
    // num = "1432219", k = 3
    // num = "10200", k = 1

    String res = removeKdigits("1432219", 3);
    System.out.println("Res: " + res);
  }
}
