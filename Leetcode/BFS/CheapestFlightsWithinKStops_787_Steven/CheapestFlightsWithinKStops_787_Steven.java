package BFS.CheapestFlightsWithinKStops_787_Steven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Node {
  int id, dist;

  Node(int id, int dist) {
    this.id = id;
    this.dist = dist;
  }
}

public class CheapestFlightsWithinKStops_787_Steven {
  public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    int[] dists = new int[n];
    Arrays.fill(dists, Integer.MAX_VALUE);

    Map<Integer, List<int[]>> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      map.put(i, new ArrayList<>());
    }

    for (int i = 0; i < flights.length; i++) {
      List<int[]> value = map.get(flights[i][0]);
      value.add(flights[i]);

      map.put(flights[i][0], value);
    }

    Queue<Node> q = new LinkedList<>();
    q.add(new Node(src, 0));

    dists[src] = 0;

    while (!q.isEmpty() && k-- >= 0) {
      int size = q.size();

      while (size-- > 0) {
        Node cur = q.poll();
        int from = cur.id;
        int dist = cur.dist;

        List<int[]> targets = map.getOrDefault(from, new ArrayList<>());

        for (int[] target : targets) {
          int to = target[1];
          int distFromTo = target[2];

          int nextDist = dist + distFromTo;

          if (dists[to] == Integer.MAX_VALUE || nextDist < dists[to]) {
            dists[to] = nextDist;
            q.add(new Node(to, nextDist));
          }
        }
      }
    }

    return dists[dst] == Integer.MAX_VALUE ? -1 : dists[dst];
  }

  public static void main(String[] args) {
    int n = 5;
    int[][] flights = new int[][] { { 0, 1, 1 }, { 0, 2, 5 }, { 1, 2, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
    int src = 0;
    int dst = 4;
    int k = 2;

    int res = findCheapestPrice(n, flights, src, dst, k);
    System.out.println("Res: " + res);
  }
}
