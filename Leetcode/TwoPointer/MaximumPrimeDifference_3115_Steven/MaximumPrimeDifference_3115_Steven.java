package TwoPointer.MaximumPrimeDifference_3115_Steven;

public class MaximumPrimeDifference_3115_Steven {
  public static int maximumPrimeDifference(int[] nums) {
    int size = nums.length;
    int left = 0, right = size - 1;

    boolean[] noPrimeNums = new boolean[101];
    noPrimeNums[0] = noPrimeNums[1] = true;
    for (int i = 2; i <= 100; i++) {
      if (noPrimeNums[i]) {
        continue;
      }

      for (int j = 2; i * j <= 100; j++) {
        noPrimeNums[i * j] = true;
      }

    }

    while (left < right) {
      if (!noPrimeNums[nums[left]]) {
        break;
      } else {
        left++;
      }
    }

    while (right > left) {
      if (!noPrimeNums[nums[right]]) {
        break;
      } else {
        right--;
      }
    }

    int res = Math.abs(right - left);
    return res;
  }

  public static void main(String[] args) {
    int[] nums = new int[] { 4, 8, 2, 8 };
    int res = maximumPrimeDifference(nums);

    System.out.println("Res: " + res);
  }
}
