package TwoPointer.TrappingRainWater_42.TrappingRainWater_42_Steven;

public class TrappingRainWater_42_Steven {
  public static int trap(int[] height) {
    int size = height.length;

    int leftMax = 0;
    int rightMax = 0;

    int left = 0, right = size - 1;
    int res = 0;

    while (left < right) {
      int maxHeight = Math.min(leftMax, rightMax);

      leftMax = Math.max(leftMax, height[left]);
      rightMax = Math.max(rightMax, height[right]);

      if (height[left] < leftMax) {
        res += (maxHeight - height[left]);
      }
      if (height[right] < rightMax) {
        res += (maxHeight - height[right]);
      }

      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }

    }

    return res;
  }

  public static void main(String[] args) {
    int[] height = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
    System.out.println(trap(height));
  }

}

// height = 0,1,0,2,1,0,1,3,2,1,2,1
// height = 4,20,3,2,5
