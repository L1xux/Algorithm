package String.StringCompression_443_Steven;

public class StringCompression_443_Steven {
  public static int compress(char[] chars) {
    int size = chars.length;

    char c = chars[0];

    int left = -1;
    int right = 0;

    int cnt = 0;

    while (left < right && right < size) {
      cnt = 0;

      while (right < size && chars[right] == c) {
        cnt++;
        right++;
      }

      chars[++left] = c;

      if (cnt >= 2) {
        String cntStr = String.valueOf(cnt);
        int cntStrSize = cntStr.length();

        for (int i = 0; i < cntStrSize; i++) {
          chars[++left] = cntStr.charAt(i);
        }
      }

      if (right >= size) {
        break;
      }
      c = chars[right];
    }

    return left + 1;
  }

  public static void main(String[] args) {
    char[] chars = new char[] { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
    int res = compress(chars);

    System.out.println("Res: " + res);
  }
}
