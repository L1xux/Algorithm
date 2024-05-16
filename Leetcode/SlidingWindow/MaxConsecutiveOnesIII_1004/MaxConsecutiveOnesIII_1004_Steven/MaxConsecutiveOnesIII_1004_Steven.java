package SlidingWindow.MaxConsecutiveOnesIII_1004.MaxConsecutiveOnesIII_1004_Steven;

import java.util.LinkedList;
import java.util.Queue;

public class MaxConsecutiveOnesIII_1004_Steven {
  public static int longestOnes(int[] nums, int k) {
    int size = nums.length;

    int left = 0;
    int right = 0;

    int max = 0;
    int used = 0;

    Queue<Integer> q = new LinkedList<>();

    while (left <= right && right < size) {
      if (nums[right] == 0 && used >= k) {
        if (!q.isEmpty()) {
          used--;
          left = q.poll() + 1;
        } else {
          left = right + 1;
        }
      }

      if (nums[right] == 0 && used < k) {
        used++;
        q.add(right);
      }

      right++;
      max = Math.max(max, right - left);
    }

    return max;
  }

  public static void main(String[] args) {
    int[] nums = new int[] { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
    int k = 3;

    int res = longestOnes(nums, k);
    System.out.println("Res: " + res);
  }
}
