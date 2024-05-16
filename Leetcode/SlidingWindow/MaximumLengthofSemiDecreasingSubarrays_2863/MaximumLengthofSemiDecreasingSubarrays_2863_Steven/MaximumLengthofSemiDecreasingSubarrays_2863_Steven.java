package SlidingWindow.MaximumLengthofSemiDecreasingSubarrays_2863.MaximumLengthofSemiDecreasingSubarrays_2863_Steven;

public class MaximumLengthofSemiDecreasingSubarrays_2863_Steven {
  public static int maxSubarrayLength(int[] nums) {
    int size = nums.length;

    int res = 0;
    int[] memo = new int[size];

    for (int i = 1; i < size; i++) {
      memo[i] = nums[memo[i - 1]] > nums[i] ? memo[i - 1] : i;
    }

    int left = size - 1;
    for (int right = size - 1; right >= 0; right--) {
      left = Math.min(left, right);

      while (left >= 0 && nums[memo[left]] > nums[right]) {
        res = Math.max(res, right - memo[left] + 1);
        left = memo[left] - 1;
      }
    }

    return res;
  }

  public static void main(String[] args) {
    int[] nums = new int[] { 57, 55, 50, 60, 61, 58, 63, 59, 64, 60, 63 };
    int res = maxSubarrayLength(nums);

    System.out.println("Res: " + res);
  }
}
