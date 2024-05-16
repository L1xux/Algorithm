package PrefixSum.LongestSubarrayof1sAfterDeletingOneElement_1493.LongestSubarrayof1sAfterDeletingOneElement_1493_Steven;

public class LongestSubarrayof1sAfterDeletingOneElement_1493_Steven {
  public static int longestSubarray(int[] nums) {
    int size = nums.length;
    int[] lSufSum = new int[size + 1];
    int[] rSufSum = new int[size + 1];

    int sum = 0;
    for (int i = 1; i <= size; i++) {
      if (nums[i - 1] == 1) {
        sum++;
      } else {
        sum = 0;
      }

      lSufSum[i] = sum;
    }

    sum = 0;
    for (int i = size - 1; i >= 0; i--) {
      if (nums[i] == 1) {
        sum++;
      } else {
        sum = 0;
      }

      rSufSum[i] = sum;
    }

    int max = 0;
    for (int i = 1; i < size; i++) {
      max = Math.max(max, lSufSum[i - 1] + rSufSum[i]);
    }

    return max;
  }

  public static void main(String[] args) {
    int[] nums = new int[] { 1, 1, 0, 1 };
    System.out.println("Res: " + longestSubarray(nums));
  }
}
