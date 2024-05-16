package TopologicalSort.LargestColorValueinaDirectedGraph_1857.LargestColorValueinaDirectedGraph_1857_Steven;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Degree {
  int now;
  int degree;

  public Degree(int now, int degree) {
    this.now = now;
    this.degree = degree;
  }

}

public class LargestColorValueinaDirectedGraph_1857_Steven {
  public static int largestPathValue(String colors, int[][] edges) {
    int N = colors.length();
    char[] colorsList = colors.toCharArray();

    @SuppressWarnings("unchecked")
    List<Integer>[] graph = new ArrayList[N];
    Degree[] degrees = new Degree[N];

    for (int i = 0; i < N; i++) {
      graph[i] = new ArrayList<Integer>();
      degrees[i] = new Degree(i, 0);
    }

    int totalDegree = edges.length;

    for (int i = 0; i < totalDegree; i++) {
      int now = edges[i][0];
      int next = edges[i][1];

      if (now == next) {
        return -1;
      }

      graph[now].add(next);
      degrees[next].degree++;
    }

    PriorityQueue<Degree> pq = new PriorityQueue<>(new Comparator<Degree>() {
      @Override
      public int compare(Degree a, Degree b) {
        return a.degree - b.degree;
      }
    });

    int[][] count = new int[N][26];

    for (int i = 0; i < N; i++) {
      if (degrees[i].degree == 0) {
        pq.add(degrees[i]);
      }
    }

    int res = -1;

    while (!pq.isEmpty()) {
      Degree degree = pq.poll();

      int now = degree.now;

      count[now][colorsList[now] - 'a']++;
      int nowCnt = count[now][colorsList[now] - 'a'];

      res = Math.max(res, nowCnt);

      for (int next : graph[now]) {
        for (int i = 0; i < 26; i++) {
          count[next][i] = Math.max(count[now][i], count[next][i]);
        }

        degrees[next].degree--;
        totalDegree--;

        if (degrees[next].degree == 0) {
          pq.add(degrees[next]);
        }
      }
    }

    return totalDegree > 0 ? -1 : res;
  }

  public static void main(String[] args) {
    String colors = "aaa";
    int[][] edges = new int[][] { { 1, 2 }, { 2, 1 } };

    int res = largestPathValue(colors, edges);

    System.out.println("Res: " + res);
  }
}
