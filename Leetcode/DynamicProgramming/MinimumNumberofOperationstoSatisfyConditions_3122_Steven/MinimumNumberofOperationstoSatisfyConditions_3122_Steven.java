package MinimumNumberofOperationstoSatisfyConditions_3122_Steven;

public class MinimumNumberofOperationstoSatisfyConditions_3122_Steven {
  public static int minimumOperations(int[][] grid) {
    int M = grid.length;
    int N = grid[0].length;

    int[][] dp = new int[10][N + 1];

    int res = M * N;

    for (int col = 1; col <= N; col++) {
      int candidate = M * N;

      for (int i = 0; i <= 9; i++) {
        int oper = 0;
        for (int row = 1; row <= M; row++) {
          if (grid[row - 1][col - 1] != i) {
            oper++;
          }
        }

        int min = M * N;

        for (int row = 0; row <= 9; row++) {
          if (i == row) {
            continue;
          }

          min = Math.min(min, oper + dp[row][col - 1]);
        }

        dp[i][col] = min;
        candidate = Math.min(candidate, min);
      }

      res = candidate;
    }

    return res;
  }

  public static void main(String[] args) {
    int[][] grid = new int[][] {
        { 1, 1, 1 },
        { 0, 0, 0 }
    };

    int res = minimumOperations(grid);

    System.out.println("Res: " + res);
  }
}
