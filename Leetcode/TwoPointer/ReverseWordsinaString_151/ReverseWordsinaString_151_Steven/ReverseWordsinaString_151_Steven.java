package TwoPointer.ReverseWordsinaString_151_Steven;

public class ReverseWordsinaString_151_Steven {
  public static String reverseWords(String s) {
    s = s.trim();
    StringBuilder sb = new StringBuilder();

    int size = s.length();
    int left = size - 1;
    int right = size;

    while (left >= 0 && left < right) {
      while (left > 0 && s.charAt(left - 1) != ' ') {
        left--;
      }

      String candi = s.substring(left, right);

      sb.append(candi);
      sb.append(" ");

      left--;
      while (left > 0 && s.charAt(left) == ' ') {
        left--;
      }

      right = left + 1;
    }

    String res = sb.toString().trim();

    return res;
  }

  public static void main(String[] args) {
    String s = "a";
    String res = reverseWords(s);

    System.out.println("Res: " + res);
  }
}
