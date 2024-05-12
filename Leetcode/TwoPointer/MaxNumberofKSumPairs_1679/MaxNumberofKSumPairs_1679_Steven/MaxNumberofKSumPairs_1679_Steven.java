package TwoPointer.MaxNumberofKSumPairs_1679_Steven;

import java.util.Arrays;

public class MaxNumberofKSumPairs_1679_Steven {
  public static int maxOperations(int[] nums, int k) {
    Arrays.sort(nums);

    int res = 0;
    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
      int sum = nums[left] + nums[right];

      if (sum < k) {
        left++;
      } else if (sum > k) {
        right--;
      } else if (sum == k) {
        left++;
        right--;
        res++;
      }
    }

    return res;
  }

  public static void main(String[] args) {
    int[] nums = new int[] { 3, 1, 3, 4, 3 };
    int res = maxOperations(nums, 6);

    System.out.println("Res: " + res);
  }
}
