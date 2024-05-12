package BFS.RottingOranges_994_Steven;

import java.util.LinkedList;
import java.util.Queue;

class Node {
  int row, col, level;

  public Node(int row, int col, int level) {
    this.row = row;
    this.col = col;
    this.level = level;
  }
}

public class RottingOranges_994_Steven {
  private static int[] NR = new int[] { 0, 0, 1, -1 };
  private static int[] NC = new int[] { 1, -1, 0, 0 };

  public static int orangesRotting(int[][] grid) {
    int M = grid.length;
    int N = grid[0].length;

    int orangesCnt = 0;
    Queue<Node> q = new LinkedList<>();

    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (grid[i][j] == 0) {
          continue;
        }

        orangesCnt++;
        if (grid[i][j] == 2) {
          q.add(new Node(i, j, 0));
        }
      }
    }

    int rottenCnt = q.size();

    while (!q.isEmpty()) {
      Node now = q.poll();

      int nowR = now.row;
      int nowC = now.col;

      int nowL = now.level;

      for (int i = 0; i < 4; i++) {
        int nextR = nowR + NR[i];
        int nextC = nowC + NC[i];

        if (nextR >= 0 && nextR < M && nextC >= 0 && nextC < N && grid[nextR][nextC] == 1) {
          rottenCnt++;

          if (rottenCnt == orangesCnt) {
            return nowL + 1;
          }

          grid[nextR][nextC] = 2;

          Node next = new Node(nextR, nextC, nowL + 1);
          q.add(next);
        }
      }
    }

    return orangesCnt == rottenCnt ? 0 : -1;
  }

  public static void main(String[] args) {
    int[][] grid = new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };

    int res = orangesRotting(grid);
    System.out.println("Res: " + res);
  }

}
