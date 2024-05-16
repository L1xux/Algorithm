package Backtracking.RestoreIPAddresses_93.RestoreIPAddresses_93_Steven;

import java.util.*;

class RestoreIPAddresses_93_Steven {
  public static void makeIpAddresses(int nowIdx, int dotCnt, String candidate, String s, List<String> res) {
    if (dotCnt == 3) {
      String lastSection = s.substring(nowIdx);
      long lastSecInt = Long.parseLong(lastSection);

      if (lastSection.length() == 1
          || (!lastSection.startsWith("0") && lastSection.length() <= 3 && lastSecInt <= 255 && lastSecInt >= 0)) {
        res.add(candidate + lastSection);
      }

      return;
    }

    for (int i = 1; i <= 3; i++) {
      if (nowIdx + i < s.length()) {
        String candiSection = s.substring(nowIdx, nowIdx + i);
        int candiSecInt = Integer.parseInt(candiSection);

        String nextCandidate = candidate + candiSection + ".";

        if ((i == 1 || !candiSection.startsWith("0")) && candiSecInt <= 255 && candiSecInt >= 0) {
          makeIpAddresses(nowIdx + i, dotCnt + 1, nextCandidate, s, res);
        }
      }

    }
  }

  public static List<String> restoreIpAddresses(String s) {
    List<String> res = new ArrayList<>();
    makeIpAddresses(0, 0, "", s, res);
    return res;
  }

  public static void main(String[] args) {
    String s = "25525511135";
    List<String> res = restoreIpAddresses(s);

    Iterator<String> elements = res.iterator();

    while (elements.hasNext()) {
      System.out.println("Res: " + elements.next());
    }
  }
}
