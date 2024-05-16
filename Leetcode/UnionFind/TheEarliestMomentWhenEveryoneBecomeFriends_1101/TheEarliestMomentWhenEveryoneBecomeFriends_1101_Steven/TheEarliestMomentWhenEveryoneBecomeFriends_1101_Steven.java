package UnionFind.TheEarliestMomentWhenEveryoneBecomeFriends_1101.TheEarliestMomentWhenEveryoneBecomeFriends_1101_Steven;

import java.util.Arrays;
import java.util.Comparator;

public class TheEarliestMomentWhenEveryoneBecomeFriends_1101_Steven {
  public static int find(int friend, int[] parent) {
    if (friend != parent[friend]) {
      parent[friend] = find(parent[friend], parent);
    }

    return parent[friend];
  }

  public static boolean unionByRank(int a, int b, int n, int[] parent, int[] rank, int[] nodCnt) {
    int p1 = find(a, parent);
    int p2 = find(b, parent);

    if (p1 == p2) {
      return nodCnt[p1] == n;
    }

    int p = rank[p1] >= rank[p2] ? p1 : p2;
    int c = rank[p1] >= rank[p2] ? p2 : p1;

    parent[c] = p;
    if (rank[p1] == rank[p2]) {
      rank[p]++;
    }

    nodCnt[p] = nodCnt[p1] + nodCnt[p2];

    return nodCnt[p] == n;
  }

  public static int earliestAcq(int[][] logs, int n) {
    Arrays.sort(logs, new Comparator<int[]>() {
      @Override
      public int compare(int[] a, int[] b) {
        return a[0] - b[0];
      }
    });

    int[] parent = new int[n];
    int[] rank = new int[n];
    int[] nodCnt = new int[n];

    for (int i = 0; i < n; i++) {
      parent[i] = i;
      rank[i] = nodCnt[i] = 1;
    }

    int size = logs.length;

    for (int i = 0; i < size; i++) {
      int[] elem = logs[i];

      if (unionByRank(elem[1], elem[2], n, parent, rank, nodCnt)) {
        return elem[0];
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    int n = 6;
    int[][] logs = new int[][] { { 20190101, 0, 1 }, { 20190104, 3, 4 }, { 20190107, 2, 3 }, { 20190211, 1, 5 },
        { 20190224, 2, 4 }, { 20190301, 0, 3 }, { 20190312, 1, 2 }, { 20190322, 4, 5 } };

    int res = earliestAcq(logs, n);

    System.out.println("Res: " + res);
  }
}
