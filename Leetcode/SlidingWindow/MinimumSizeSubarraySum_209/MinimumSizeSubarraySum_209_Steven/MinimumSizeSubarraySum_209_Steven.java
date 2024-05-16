
package SlidingWindow.MinimumSizeSubarraySum_209.MinimumSizeSubarraySum_209_Steven;

class MinimumSizeSubarraySum_209_Steven {
  public static int minSubArrayLen(int target, int[] nums) {
    int size = nums.length;

    int left = 0;
    int right = 0;

    int sum = nums[0];
    int res = sum >= target ? 1 : Integer.MAX_VALUE;

    while (left <= right) {
      if (sum < target) {
        right++;

        if (right >= size) {
          break;
        }

        sum += nums[right];

      } else {
        sum -= nums[left];
        left++;
      }

      if (sum >= target) {
        res = Math.min(res, right - left + 1);
      }
    }

    return res == Integer.MAX_VALUE ? 0 : res;
  }

  public static void main(String[] args) {
    int target = 11;
    int[] nums = new int[] { 1, 2, 3, 4, 5 };

    int res = minSubArrayLen(target, nums);
    System.out.println("Result: " + res);
  }
}