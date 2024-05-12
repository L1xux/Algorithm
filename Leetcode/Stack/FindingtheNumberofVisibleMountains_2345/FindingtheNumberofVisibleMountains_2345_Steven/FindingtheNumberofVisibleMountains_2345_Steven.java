package Stack.FindingtheNumberofVisibleMountains_2345_Steven;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

class Node {
  int row, col;

  public Node(int row, int col) {
    this.row = row;
    this.col = col;
  }

}

public class FindingtheNumberofVisibleMountains_2345_Steven {
  public static int visibleMountains(int[][] peaks) {
    Arrays.sort(peaks, new Comparator<int[]>() {
      @Override
      public int compare(int[] a, int[] b) {
        return a[1] - b[1];
      }
    });

    Stack<Node> stack = new Stack<>();
    stack.push(new Node(peaks[0][0], peaks[0][1]));

    return stack.size();
  }

  public static void main(String[] args) {
    int[][] peaks = new int[][] { { 2, 2, }, { 6, 3 }, { 5, 4 } };
    System.out.println("Res: " + visibleMountains(peaks));
  }
}
