package BFS.ValidateBinaryTreeNodes_1361_Steven;

import java.util.*;

public class ValidateBinaryTreeNodes_1361_Steven {
  public static int findRoot(int n, int[] leftChild, int[] rightChild) {
    HashSet<Integer> set = new HashSet<>();

    int leftChildSize = leftChild.length;
    int rightChildSize = rightChild.length;

    for (int i = 0; i < leftChildSize; i++) {
      set.add(leftChild[i]);
    }

    for (int i = 0; i < rightChildSize; i++) {
      set.add(rightChild[i]);
    }

    for (int i = 0; i < n; i++) {
      if (!set.contains(i)) {
        return i;
      }
    }

    return -1;
  }

  public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
    int root = findRoot(n, leftChild, rightChild);

    if (root == -1) {
      return false;
    }

    Queue<Integer> q = new LinkedList<>();
    q.add(root);

    boolean[] visited = new boolean[n + 1];
    int visitedCnt = 1;

    visited[root] = true;

    while (!q.isEmpty()) {
      int nod = q.poll();

      int[] children = new int[] { leftChild[nod], rightChild[nod] };

      for (int child : children) {

        if (child != -1) {
          if (visited[child]) {
            return false;
          }

          q.add(child);
          visited[child] = true;

          visitedCnt++;
        }
      }
    }

    return n == visitedCnt;
  }

  public static void main(String[] args) {
    int n = 4;
    int[] leftChild = new int[] { 1, -1, 3, -1 };
    int[] rightChild = new int[] { 2, 3, -1, -1 };

    boolean res = validateBinaryTreeNodes(n, leftChild, rightChild);

    System.out.println("Res: " + res);
  }
}
