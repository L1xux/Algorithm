package BinarySearch.KthMissingPositiveNumber_1539_Steven;

public class KthMissingPositiveNumber_1539_Steven {
  public static int findKthPositive(int[] nums, int k) {
    int size = nums.length;

    int last = nums[size - 1];
    int criteria = last - size;
    if (criteria < k) {
      return last + (k - criteria);
    }

    int first = nums[0];
    criteria = first - 1;

    if (criteria >= k) {
      return k;
    }

    int left = 0;
    int right = size - 1;

    while (left + 1 < right) {
      int mid = (left + right) / 2;

      int num = nums[mid];
      criteria = num - mid;

      if (criteria <= k) {
        left = mid;
      } else {
        right = mid;
      }
    }

    int res = nums[right - 1] + (k - (nums[right - 1] - right));
    return res;
  }

  public static void main(String[] args) {
    int[] nums = new int[] { 2, 3, 4, 7, 11 };
    int k = 14;

    int res = findKthPositive(nums, k);

    System.out.println("Res: " + res);
  }
}
