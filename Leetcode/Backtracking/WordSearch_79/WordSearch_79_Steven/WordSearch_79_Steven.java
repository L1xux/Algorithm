package Backtracking.WordSearch_79.WordSearch_79_Steven;

class WordSearch_79_Steven {
  private static int[] NR = new int[] { -1, 1, 0, 0 };
  private static int[] NC = new int[] { 0, 0, -1, 1 };

  public static boolean solve(int nowRow, int nowCol, int nowChar, char[][] board, char[] word) {
    if (nowChar >= word.length) {
      return true;
    }

    boolean res = false;

    char temp = board[nowRow][nowCol];
    board[nowRow][nowCol] = '.';

    for (int i = 0; i < 4; i++) {
      int nextR = nowRow + NR[i];
      int nextC = nowCol + NC[i];

      if (nextR >= 0 && nextR < board.length
          && nextC >= 0 && nextC < board[0].length
          && board[nextR][nextC] == word[nowChar] && !res) {
        board[nextR][nextC] = '.';
        res = solve(nextR, nextC, nowChar + 1, board, word);
        board[nextR][nextC] = word[nowChar];
      }
    }

    board[nowRow][nowCol] = temp;

    return res;
  }

  public static boolean exist(char[][] board, String word) {
    char[] cWord = word.toCharArray();

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {

        if (board[i][j] == cWord[0] && solve(i, j, 1, board, cWord)) {
          return true;
        }
      }
    }

    return false;
  }

  public static void main(String[] args) {
    char[][] board = new char[][] { { 'a', 'a' }, };
    String word = "aaa";

    boolean res = exist(board, word);

    System.out.println("Res: " + res);
  }
}
