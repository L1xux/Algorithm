package String.MergeStringsAlternately_1768.MergeStringsAlternately_1768_Steven;

public class MergeStringsAlternately_1768_Steven {
  public static String mergeAlternately(String word1, String word2) {
    int size1 = word1.length();
    int size2 = word2.length();

    int totalSize = size1 + size2;
    char[] res = new char[totalSize];

    int idx = 0;
    int word1Idx = 0;
    int word2Idx = 0;

    while (word1Idx < size1 || word2Idx < size2) {
      if (word1Idx < size1) {
        res[idx++] = word1.charAt(word1Idx);
        word1Idx++;
      }

      if (word2Idx < size2) {
        res[idx++] = word2.charAt(word2Idx);
        word2Idx++;
      }
    }

    return String.valueOf(res);
  }

  public static void main(String[] args) {
    String res = mergeAlternately("ab", "pqrs");

    System.out.println("Res: " + res);
  }
}
