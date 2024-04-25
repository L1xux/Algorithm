package FrogJump_403_Steven;

import java.util.*;

public class FrogJump_403_Steven {
  public static boolean canCross(int[] stones) {
    int n = stones.length;

    if (n >= 2 && stones[1] != 1) {
      return false;
    }

    @SuppressWarnings("unchecked")
    Set<Integer>[] dp = new HashSet[n + 1];
    Map<Integer, Integer> hasStone = new HashMap<>();

    dp[0] = new HashSet<>();
    for (int i = 1; i <= n; i++) {
      dp[i] = new HashSet<>();
      hasStone.put(stones[i - 1], i - 1);
    }

    dp[0].add(1);
    dp[1].add(1);

    boolean result = n == 2;

    for (int i = 2; i <= n; i++) {
      for (int dpVal : dp[i - 1]) {
        int[] units = new int[] { -1, 0, 1 };

        for (int j = 0; j < 3; j++) {
          int nextKey = stones[i - 1] + dpVal + units[j];
          int nextIdx = hasStone.getOrDefault(nextKey, -1);

          if (nextKey == stones[n - 1]) {
            result = true;
          }

          if (nextIdx != -1 && nextIdx != i - 1) {
            dp[nextIdx].add(dpVal + units[j]);
          }
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    int[] stones = new int[] { 0, 1, 2, 5, 6, 9, 10, 12, 13, 14, 17, 19, 20, 21, 26, 27, 28, 29, 30 };
    boolean result = canCross(stones);

    System.out.println("Result: " + result);
  }
}
