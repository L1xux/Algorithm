package Greedy.MinimumNumberofGroupstoCreateaValidAssignment_2910.MinimumNumberofGroupstoCreateaValidAssignment_2910_Steven;

import java.util.*;

public class MinimumNumberofGroupstoCreateaValidAssignment_2910_Steven {
  public static int solve(int size, Map<Integer, Integer> map) {
    int candi = 0;
    int div = size + 1;

    for (int divided : map.values()) {
      int quot = divided / div;
      int rem = divided % div;

      if (rem == 0) {
        candi += quot;
      } else if (quot >= size - rem) {
        candi += quot + 1;
      } else {
        return -1;
      }
    }

    return candi;
  }

  public static int minGroupsForValidAssignment(int[] balls) {
    int size = balls.length;
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < size; i++) {
      int ball = balls[i];
      int cur = map.getOrDefault(ball, -1);

      if (cur == -1) {
        map.put(ball, 1);
      } else {
        map.put(ball, cur + 1);
      }
    }

    int min = size;
    for (int value : map.values()) {
      min = Math.min(min, value);
    }

    for (int boxSize = min; boxSize >= 1; --boxSize) {
      int res = solve(boxSize, map);
      if (res > 0) {
        return res;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] balls = new int[] { 1, 1, 3, 3, 1, 1, 2, 2, 3, 1, 3, 2 };
    System.out.println("Res: " + minGroupsForValidAssignment(balls));

  }
}

// 1: 5, 2: 3, 3: 4

// [1,1,3,3,1,1,2,2,3,1,3,2], res = 5
// [1, 2]
// [3, 2, 3, 2, 3]
// [10, 10, 10, 3, 1, 1]
// [1, 2, 1, 1]
// [ 3, 2, 2, 1, 1, 1, 2 ]
// [1, 2, 2, 3, 1]