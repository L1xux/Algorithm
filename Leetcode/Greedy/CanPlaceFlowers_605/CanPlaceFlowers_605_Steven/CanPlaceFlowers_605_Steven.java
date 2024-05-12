package Greedy.CanPlaceFlowers_605_Steven;

public class CanPlaceFlowers_605_Steven {
  public static boolean canPlaceFlowers(int[] flowerbed, int n) {
    int size = flowerbed.length;

    int[] nums = new int[size + 2];
    for (int i = 1; i <= size; i++) {
      nums[i] = flowerbed[i - 1];
    }

    for (int i = 1; i <= size; i++) {
      if (n == 0) {
        break;
      }

      if (nums[i] == 1) {
        continue;
      }

      if (nums[i - 1] == 0 && nums[i + 1] == 0) {
        nums[i] = 1;
        n--;
      }
    }

    return n == 0;
  }

  public static void main(String[] args) {
    int[] flowerbed = new int[] { 1, 0, 0, 0, 1, 0, 0 };
    int n = 2;

    boolean res = canPlaceFlowers(flowerbed, n);
    System.out.println("Res: " + res);
  }
}
