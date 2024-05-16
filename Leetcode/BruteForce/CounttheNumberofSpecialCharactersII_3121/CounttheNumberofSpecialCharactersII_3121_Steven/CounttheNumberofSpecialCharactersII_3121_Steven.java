package BruteForce.CounttheNumberofSpecialCharactersII_3121.CounttheNumberofSpecialCharactersII_3121_Steven;

public class CounttheNumberofSpecialCharactersII_3121_Steven {

  public static int numberOfSpecialChars(String word) {
    int size = word.length();
    // uppercase, lowercase
    int[][] check = new int[2][26];

    for (int i = 0; i < size; i++) {
      char c = word.charAt(i);
      boolean isUpper = Character.isUpperCase(c);

      int idx = isUpper ? c - 'A' : c - 'a';
      if (isUpper && check[1][idx] != -1) {
        check[0][idx] = 1;
      } else if (!isUpper) {
        check[1][idx] = check[0][idx] == 1 ? -1 : 1;
      }
    }

    int cnt = 0;
    for (int i = 0; i < 26; i++) {
      if (check[0][i] == 1 && check[1][i] == 1) {
        cnt++;
      }
    }

    return cnt;
  }

  public static void main(String[] args) {
    String word = "deE";
    int res = numberOfSpecialChars(word);

    System.out.println("Res: " + res);
  }
}
