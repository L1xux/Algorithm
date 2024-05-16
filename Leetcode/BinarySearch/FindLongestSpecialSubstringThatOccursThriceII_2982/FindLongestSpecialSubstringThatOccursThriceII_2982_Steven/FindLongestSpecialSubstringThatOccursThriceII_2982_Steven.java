package BinarySearch.FindLongestSpecialSubstringThatOccursThriceII_2982.FindLongestSpecialSubstringThatOccursThriceII_2982_Steven;

public class FindLongestSpecialSubstringThatOccursThriceII_2982_Steven {

  public static int maximumLength(String s) {
    int size = s.length();

    int left = 0;
    int right = size;

    int res = -1;

    while (left < right) {
      int len = right - left;
      int cnt = 0;

      for (int i = 0; i + len <= size; i++) {
        String target = s.substring(i, i + len);
        int start = target.charAt(0);

        boolean isSpecial = true;
        cnt = 0;
        for (int j = 0; j < target.length(); j++) {
          if (start != target.charAt(j)) {
            isSpecial = false;
            break;
          }
        }

        if (!isSpecial) {
          continue;
        }

        for (int j = i; j + len <= size; j++) {
          String candi = s.substring(j, j + len);

          if (target.equals(candi)) {
            cnt++;
          }
        }

        if (cnt >= 3) {
          return len;
        }
      }

      if (cnt > 3) {
        // res = Math.max(res, mid);
        // left = mid + 1;
      } else {
        // right = mid;
      }
    }

    return res;
  }

  public static void main(String[] args) {
    int res = maximumLength("ereerrrererrrererre");
    System.out.println("Res: " + res);
  }
}

// aaaa
// abcdef
// abcaba