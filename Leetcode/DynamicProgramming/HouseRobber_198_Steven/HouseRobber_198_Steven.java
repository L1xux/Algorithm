package HouseRobber_198_Steven;

public class HouseRobber_198_Steven {
  public static int rob(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }

    int size = nums.length;

    int[] dp = new int[nums.length + 1];
    dp[1] = nums[0];

    int res = Math.max(dp[1], dp[2]);

    for (int i = 2; i <= size; i++) {
      dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]);
      res = Math.max(res, dp[i]);
    }

    return res;
  }

  public static void main(String[] args) {
    int[] nums = new int[] { 2, 7, 9, 3, 1 };
    int res = rob(nums);

    System.out.println("Res: " + res);
  }
}
