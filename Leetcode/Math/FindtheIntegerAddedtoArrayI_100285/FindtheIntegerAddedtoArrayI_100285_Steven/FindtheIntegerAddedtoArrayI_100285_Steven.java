package Math.FindtheIntegerAddedtoArrayI_100285_Steven;

public class FindtheIntegerAddedtoArrayI_100285_Steven {
  public static int addedInteger(int[] nums1, int[] nums2) {
    int M = nums1.length;
    int N = nums2.length;

    int sum1 = 0;
    int sum2 = 0;

    for (int i = 0; i < M; i++) {
      sum1 += nums1[i];
    }

    for (int i = 0; i < N; i++) {
      sum2 += nums2[i];
    }

    for (int i = -100000; i <= 100000; i++) {
      if (sum1 + i * M == sum2) {
        return i;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] nums1 = new int[] { 4, 20, 16, 12, 8 };
    int[] nums2 = new int[] { 14, 18, 10 };

    int res = addedInteger(nums1, nums2);

    System.out.println("res: " + res);

  }
}
