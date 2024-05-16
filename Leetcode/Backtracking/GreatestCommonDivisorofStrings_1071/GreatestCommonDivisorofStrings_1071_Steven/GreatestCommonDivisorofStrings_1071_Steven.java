package Backtracking.GreatestCommonDivisorofStrings_1071.GreatestCommonDivisorofStrings_1071_Steven;

public class GreatestCommonDivisorofStrings_1071_Steven {
  public static String gcdOfStrings(String str1, String str2) {
    int size1 = str1.length();
    int size2 = str2.length();

    String divider = size1 < size2 ? str1 : str2;

    while (!divider.isEmpty()) {
      int divLen = divider.length();

      if (size1 % divLen == 0 && size2 % divLen == 0) {
        StringBuilder sb1 = new StringBuilder();

        int limit = size1 / divLen;
        for (int i = 1; i <= limit; i++) {
          sb1.append(divider);
        }

        StringBuilder sb2 = new StringBuilder();
        limit = size2 / divLen;
        for (int i = 1; i <= limit; i++) {
          sb2.append(divider);
        }

        String s1 = sb1.toString();
        String s2 = sb2.toString();

        if (s1.equals(str1) && s2.equals(str2)) {
          return divider;
        }
      }

      divider = divider.substring(0, divLen - 1);
    }

    return "";
  }

  public static void main(String[] args) {
    String str1 = "TAUXXTAUXXTAUXXTAUXXTAUXX";
    String str2 = "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";

    String res = gcdOfStrings(str1, str2);
    System.out.println("Res: " + res);

  }
}
