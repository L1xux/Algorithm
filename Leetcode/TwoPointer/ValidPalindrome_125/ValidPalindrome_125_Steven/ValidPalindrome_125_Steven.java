package TwoPointer.ValidPalindrome_125_Steven;

public class ValidPalindrome_125_Steven {
  public static boolean isPalindrome(String s) {
    s = s.toLowerCase();
    s = s.replaceAll("[^a-zA-Z0-9]", "");

    int sSize = s.length();
    int left = 0;
    int right = sSize - 1;

    while (left <= right && s.charAt(left) == s.charAt(right)) {
      left++;
      right--;
    }

    return left > right;
  }

  public static void main(String[] args) {
    String s = "A man, a plan, a canal: Panama";
    boolean res = isPalindrome(s);

    System.out.println("Res: " + res);
  }
}
