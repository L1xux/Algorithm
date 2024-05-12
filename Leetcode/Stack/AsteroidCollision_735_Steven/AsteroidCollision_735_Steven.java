package Stack.AsteroidCollision_735_Steven;

import java.util.Stack;

public class AsteroidCollision_735_Steven {
  public static int[] asteroidCollision(int[] nums) {
    int size = nums.length;
    Stack<Integer> stack = new Stack<>();

    stack.add(nums[0]);

    for (int i = 1; i < size; i++) {
      if (nums[i] > 0) {
        stack.add(nums[i]);
        continue;
      }

      int absolute = Math.abs(nums[i]);
      while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < absolute) {
        stack.pop();
      }

      if (!stack.isEmpty() && stack.peek() > 0 && stack.peek() - absolute == 0) {
        stack.pop();
        continue;
      }

      if (stack.isEmpty() || stack.peek() < 0) {
        stack.push(nums[i]);
      }
    }

    int[] res = new int[stack.size()];

    size = res.length;
    for (int i = 0; i < size; i++) {
      res[i] = stack.get(i);
    }

    return res;
  }

  public static void main(String[] args) {
    int[] nums = new int[] { 5, 10, -5 };
    int[] res = asteroidCollision(nums);
    for (int elem : res) {
      System.out.println("Elem: " + elem);
    }
  }

}
