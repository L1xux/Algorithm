package SlidingWindow.MaximumSumofDistinctSubarraysWithLengthK_2461_Steven;

import java.util.*;

public class MaximumSumofDistinctSubarraysWithLengthK_2461_Steven {
  public static long maximumSubarraySum(int[] nums, int k) {
    Map<Long, Integer> same = new HashMap<>();

    int size = nums.length;
    long res = 0;

    int left = 0, right = 0;

    long candidate = 0;
    boolean hasAnswer = false;
    while (right < size) {
      long now = nums[right];
      int isSame = same.getOrDefault(now, -1);

      if (isSame != -1) {
        while (left <= isSame) {
          long leftNow = nums[left];

          same.remove(leftNow);
          candidate -= leftNow;
          left++;
        }
      }

      candidate += now;
      same.put(now, right);

      int len = right - left + 1;

      if (len == k) {
        res = Math.max(res, candidate);
        hasAnswer = true;

        long leftNow = nums[left];
        same.remove(leftNow);
        candidate -= leftNow;
        left++;
      }

      right++;
    }

    return hasAnswer ? res : 0;
  }

  public static void main(String[] args) {
    int[] nums = new int[] { 1, 1, 1, 7, 8, 9 };
    int k = 3;

    System.out.println("Res: " + maximumSubarraySum(nums, k));
  }
}
