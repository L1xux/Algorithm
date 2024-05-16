package Math.LatestTimeYouCanObtainAfterReplacingCharacters_3114.LatestTimeYouCanObtainAfterReplacingCharacters_3114_Steven;

public class LatestTimeYouCanObtainAfterReplacingCharacters_3114_Steven {
  public static String findLatestTime(String s) {
    char[] cs = s.toCharArray();
    char[] res = new char[5];

    res[0] = cs[0];
    res[1] = cs[1];
    res[2] = ':';

    boolean isFistOne = cs[0] == '1' || cs[0] == '?' ? true : false;
    boolean isSecondOneOrZero = cs[1] == '0' || cs[1] == '1' || cs[1] == '?' ? true : false;

    if (isFistOne || isSecondOneOrZero) {
      if (cs[0] == '?') {
        res[0] = !isSecondOneOrZero ? '0' : '1';
      }
      if (cs[1] == '?') {
        res[1] = !isFistOne ? '9' : '1';
      }
    }

    res[3] = cs[3] == '?' ? '5' : cs[3];
    res[4] = cs[4] == '?' ? '9' : cs[4];

    return String.valueOf(res);
  }

  public static void main(String[] args) {
    String s = "0?:5?";
    String res = findLatestTime(s);

    System.out.println("Res: " + res);

  }
}
