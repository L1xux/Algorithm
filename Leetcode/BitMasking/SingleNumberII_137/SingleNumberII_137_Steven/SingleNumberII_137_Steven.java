package BitMasking.SingleNumberII_137.SingleNumberII_137_Steven;

public class SingleNumberII_137_Steven {

  public static int singleNumber(int[] nums) {
    int res = 0;

    for (int i = 0; i < 32; i++) {
      int sum = 0;

      for (int num : nums) {
        sum += num >> i & 1;
      }
      sum %= 3;
      res |= sum << i;
    }

    return res;
  }

  public static void main(String[] args) {
    int[] nums = new int[] { 2, 2, 3, 2 };
    int result = singleNumber(nums);

    System.out.println("Result: " + result);
  }
}
