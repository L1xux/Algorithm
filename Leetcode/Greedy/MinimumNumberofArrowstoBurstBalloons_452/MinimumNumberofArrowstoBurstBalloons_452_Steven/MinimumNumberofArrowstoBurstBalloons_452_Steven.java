package Greedy.MinimumNumberofArrowstoBurstBalloons_452.MinimumNumberofArrowstoBurstBalloons_452_Steven;

import java.util.Arrays;

public class MinimumNumberofArrowstoBurstBalloons_452_Steven {
  public static int findMinArrowShots(int[][] points) {
    int size = points.length;

    Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

    int arrows = 1;
    int[] prev = points[0];

    for (int i = 1; i < size; i++) {
      int prevEnd = prev[1];

      int newStart = points[i][0];
      int newEnd = points[i][1];

      if (newStart <= prevEnd) {
        prev[0] = newStart;
        prev[1] = Math.min(prevEnd, newEnd);
      } else {
        arrows++;

        prev[0] = newStart;
        prev[1] = newEnd;
      }
    }

    return arrows;
  }

  public static void main(String[] args) {
    int[][] points = new int[][] { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
    int res = findMinArrowShots(points);

    System.out.println("Res: " + res);
  }
}
