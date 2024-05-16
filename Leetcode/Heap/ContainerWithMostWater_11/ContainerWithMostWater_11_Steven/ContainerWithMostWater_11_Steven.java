package Heap.ContainerWithMostWater_11.ContainerWithMostWater_11_Steven;

public class ContainerWithMostWater_11_Steven {

  public static int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;

    int res = (right - left) * Math.min(height[left], height[right]);

    while (left < right) {
      int leftCandi = 0, rightCandi = 0;

      if (left + 1 < right) {
        leftCandi = (right - (left + 1)) * Math.min(height[left + 1], height[right]);
      }
      if (left < right - 1) {
        rightCandi = ((right - 1) - left) * Math.min(height[left], height[right - 1]);
      }

      int candi = Math.max(leftCandi, rightCandi);
      res = Math.max(res, candi);

      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }

    return res;
  }

  public static void main(String[] args) {
    int[] height = new int[] { 1, 3, 2, 5, 25, 24, 5 };
    System.out.println("Result: " + maxArea(height));
  }
}
// height = 1,3,2,5,25,24,5
// height = 1,8,6,2,5,4,8,3,7
// height = 1, 1
