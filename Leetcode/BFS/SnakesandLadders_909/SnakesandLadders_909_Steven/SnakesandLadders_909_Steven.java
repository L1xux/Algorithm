package BFS.SnakesandLadders_909_Steven;

import java.util.*;

class Pair_909 {
  int idx, move;

  Pair_909(int idx, int move) {
    this.idx = idx;
    this.move = move;
  }

}

public class SnakesandLadders_909_Steven {
  public static int snakesAndLadders(int[][] board) {
    int N = board.length;
    int size = N * N;
    int[] map = new int[size];

    int idx = 0;

    boolean isForward = true;
    for (int i = N - 1; i >= 0; i--) {
      if (isForward) {
        for (int j = 0; j < N; j++) {
          map[idx++] = board[i][j];
        }
      } else {
        for (int j = N - 1; j >= 0; j--) {
          map[idx++] = board[i][j];
        }
      }

      isForward = !isForward;
    }

    Queue<Pair_909> queue = new LinkedList<>();
    boolean[] visited = new boolean[size];

    visited[0] = true;
    queue.add(new Pair_909(0, 0));

    while (!queue.isEmpty()) {
      Pair_909 cur = queue.poll();

      int curIdx = cur.idx;
      int curMov = cur.move;

      if (curIdx == size - 1) {
        return curMov;
      }

      for (int i = 1; i <= 6; i++) {
        int nextIdx = curIdx + i;

        if (nextIdx < size && !visited[nextIdx]) {
          if (map[nextIdx] != -1) {
            visited[nextIdx] = true;
            queue.add(new Pair_909(map[nextIdx] - 1, curMov + 1));
          } else {
            visited[nextIdx] = true;
            queue.add(new Pair_909(nextIdx, curMov + 1));
          }
        }
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    int[][] board = new int[][] { { 1, 1, -1 }, { 1, 1, 1 }, { -1, 1, 1 } };
    int res = snakesAndLadders(board);

    System.out.println("Res: " + res);

  }
}

// {{1,1,-1}, {1,1,1},{-1,1,1}}

// [[-1,1,2,-1],[2,13,15,-1],[-1,10,-1,-1],[-1,6,2,8]];
/*
 * 
 * 
 * [[-1,1,2,-1],
 * [2,13,15,-1],
 * [-1,10,-1,-1],
 * [-1,6,2,8]]
 * 
 * 
 */

/*
 * int[][] board = new int[][] {
 * { -1, -1, -1, -1, -1, -1 },
 * { -1, -1, -1, -1, -1, -1 },
 * { -1, -1, -1, -1, -1, -1 },
 * { -1, 35, -1, -1, 13, -1 },
 * { -1, -1, -1, -1, -1, -1 },
 * { -1, 15, -1, -1, -1, -1 } };
 */