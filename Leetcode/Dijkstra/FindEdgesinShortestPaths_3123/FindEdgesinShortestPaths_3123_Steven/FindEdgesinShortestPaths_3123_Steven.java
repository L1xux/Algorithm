package Dijkstra.FindEdgesinShortestPaths_3123.FindEdgesinShortestPaths_3123_Steven;

import java.util.*;

class Node {
  int start, dis, idx;

  public Node(int start, int dis, int idx) {
    this.start = start;
    this.dis = dis;
    this.idx = idx;
  }
}

public class FindEdgesinShortestPaths_3123_Steven {
  public static void findPath(int now, int dest, boolean[] res, Map<Integer, Stack<Node>> path) {
    res[now] = true;

    Stack<Node> dests = path.getOrDefault(dest, null);
    if (dests == null) {
      return;
    }

    while (!dests.isEmpty()) {
      Node next = dests.pop();
      findPath(next.idx, next.start, res, path);
    }
  }

  public static boolean[] findAnswer(int n, int[][] edges) {
    int size = edges.length;

    @SuppressWarnings("unchecked")
    List<Node>[] graph = new List[n];

    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<Node>();
    }

    for (int i = 0; i < size; i++) {
      int start = edges[i][0];
      int dest = edges[i][1];
      int dis = edges[i][2];

      Node item = new Node(dest, dis, i);
      graph[start].add(item);

      item = new Node(start, dis, i);
      graph[dest].add(item);
    }

    PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
      @Override
      public int compare(Node a, Node b) {
        return a.dis - b.dis;
      }
    });

    int[] dists = new int[n];
    Arrays.fill(dists, Integer.MAX_VALUE);

    Map<Integer, Stack<Node>> path = new HashMap<>();
    pq.add(new Node(0, 0, 0));
    dists[0] = 0;

    while (!pq.isEmpty()) {
      Node now = pq.poll();

      int nowStart = now.start;
      List<Node> target = graph[nowStart];

      for (Node next : target) {
        int nextStart = next.start;
        int nextDis = dists[nowStart] + next.dis;
        int nextIdx = next.idx;

        int dist = dists[nextStart];

        Stack<Node> stack = new Stack<>();

        stack.add(new Node(nowStart, nextDis, nextIdx));

        if (dist == Integer.MAX_VALUE) {
          dists[nextStart] = nextDis;
          pq.add(new Node(nextStart, nextDis, nextIdx));
          path.put(nextStart, stack);
        } else {
          if (nextDis < dists[nextStart]) {
            dists[nextStart] = nextDis;

            pq.add(new Node(nextStart, nextDis, nextIdx));
            path.put(nextStart, stack);
          } else if (nextDis == dists[nextStart]) {
            stack = path.get(nextStart);
            stack.add(new Node(nowStart, nextDis, nextIdx));

            path.put(nextStart, stack);
          }
        }
      }
    }

    boolean[] res = new boolean[size];

    Stack<Node> start = path.getOrDefault(n - 1, null);
    while (start != null && !start.isEmpty()) {
      Node node = start.pop();
      findPath(node.idx, node.start, res, path);
    }

    return res;
  }

  public static void main(String[] args) {
    int n = 7;
    int[][] edges = { { 1, 0, 2 }, { 4, 1, 1 }, { 5, 0, 3 }, { 6, 0, 8 }, { 2, 0, 5 }, { 3, 2, 10 }, { 4, 0, 9 },
        { 3, 4, 1 }, { 5, 3, 3 }, { 1, 2, 6 }, { 3, 6, 3 }, { 2, 5, 7 } };

    boolean[] res = findAnswer(n, edges);

    for (boolean elem : res) {
      System.out.println("Elem: " + elem);
    }
  }
}
