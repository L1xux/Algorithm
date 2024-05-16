package SlidingWindow.MaximumNumberofVowelsinaSubstringofGivenLength_1456.MaximumNumberofVowelsinaSubstringofGivenLength_1456_Steven;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberofVowelsinaSubstringofGivenLength_1456_Steven {

  public static int maxVowels(String s, int k) {
    Map<Character, Boolean> vowels = new HashMap<>();
    vowels.put('a', true);
    vowels.put('e', true);
    vowels.put('i', true);
    vowels.put('o', true);
    vowels.put('u', true);

    int size = s.length();
    char[] cs = s.toCharArray();

    int res = 0;
    int len = 0;

    int left = 0;
    int right = 0;

    while (right < size) {
      if (vowels.containsKey(cs[right])) {
        len++;
      }

      res = Math.max(res, len);

      right++;

      if (right - left + 1 > k) {
        if (vowels.containsKey(cs[left])) {
          len--;
        }

        left++;
      }

    }

    return res;
  }

  public static void main(String[] args) {
    int res = maxVowels("leetcode", 3);
    System.out.println("Res: " + res);
  }
}
