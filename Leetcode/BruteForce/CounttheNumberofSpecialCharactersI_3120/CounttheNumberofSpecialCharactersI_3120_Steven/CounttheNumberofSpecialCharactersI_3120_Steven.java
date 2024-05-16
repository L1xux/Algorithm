package BruteForce.CounttheNumberofSpecialCharactersI_3120.CounttheNumberofSpecialCharactersI_3120_Steven;

public class CounttheNumberofSpecialCharactersI_3120_Steven {
  public static int numberOfSpecialChars(String word) {
    int size = word.length();

    boolean[][] check = new boolean[2][26];

    int cnt = 0;
    for (int i = 0; i < size; i++) {
      Character c = word.charAt(i);
      boolean isUpper = Character.isUpperCase(c);

      int idx = isUpper ? c - 'A' : c - 'a';

      if (isUpper) {
        check[0][idx] = true;
      } else {
        check[1][idx] = true;
      }
    }

    for (int i = 0; i < 26; i++) {
      if (check[0][i] && check[1][i]) {
        cnt++;
      }
    }

    return cnt;
  }

  public static void main(String[] args) {
    String word = "aaAbcBC";
    int res = numberOfSpecialChars(word);
    System.out.println("Res: " + res);
  }
}
