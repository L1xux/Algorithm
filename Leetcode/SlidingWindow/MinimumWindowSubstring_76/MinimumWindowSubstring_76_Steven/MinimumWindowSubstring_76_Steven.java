package SlidingWindow.MinimumWindowSubstring_76.MinimumWindowSubstring_76_Steven;

import java.util.HashMap;

public class MinimumWindowSubstring_76_Steven {
  @SuppressWarnings("unchecked")
  public static String minWindow(String s, String t) {
    HashMap<Character, Integer> tMasked = new HashMap<>();
    HashMap<Character, Integer> sMasked = new HashMap<>();
    HashMap<Character, Integer> originTMasked = new HashMap<>();

    int tSize = t.length();
    for (int i = 0; i < tSize; i++) {
      char curChar = t.charAt(i);
      int curCnt = originTMasked.getOrDefault(curChar, 0);

      originTMasked.put(t.charAt(i), curCnt + 1);
    }
    tMasked = (HashMap<Character, Integer>) originTMasked.clone();

    int sSize = s.length();
    int left = 0, right = 0;
    String res = "";

    while (right < sSize) {
      char curRightChar = s.charAt(right);
      int curRightCnt = tMasked.getOrDefault(curRightChar, -1);

      if (curRightCnt != -1) {
        sMasked.put(curRightChar, sMasked.getOrDefault(curRightChar, 0) + 1);
        tMasked.put(curRightChar, curRightCnt - 1);

        if (curRightCnt - 1 == 0) {
          tMasked.remove(curRightChar);
        }
      }

      while (left <= right && tMasked.isEmpty()) {
        char curLeftChar = s.charAt(left);

        String candi = s.substring(left, right + 1);
        res = res.length() == 0 || candi.length() < res.length() ? candi : res;

        left++;

        if (sMasked.getOrDefault(curLeftChar, -1) != -1) {
          int curLeftCnt = sMasked.get(curLeftChar);
          sMasked.put(curLeftChar, curLeftCnt - 1);

          int originCnt = originTMasked.get(curLeftChar);

          if (curLeftCnt - 1 < originCnt) {
            // tMasked.put(curLeftChar, );
            break;
          }
        }
      }

      right++;
    }

    return res;
  }

  public static void main(String[] args) {
    String res = minWindow("ADOBECODEBANC", "ABC");
    System.out.println("Res: " + res);
  }
}
