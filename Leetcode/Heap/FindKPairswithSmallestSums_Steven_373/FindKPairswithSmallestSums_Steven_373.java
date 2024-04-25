package Heap.FindKPairswithSmallestSums_Steven_373;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;

class Pair_373 {
  int first, second;

  public Pair_373(int first, int second) {
    this.first = first;
    this.second = second;
  }

  @Override
  public int hashCode() {
    return Objects.hash(first, second);
  }
}

public class FindKPairswithSmallestSums_Steven_373 {
  public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<List<Integer>> res = new ArrayList<>();
    int n1Size = nums1.length, n2Size = nums2.length;

    PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new Comparator<List<Integer>>() {
      @Override
      public int compare(List<Integer> o1, List<Integer> o2) {
        int o1Sum = nums1[o1.get(0)] + nums2[o1.get(1)];
        int o2Sum = nums1[o2.get(0)] + nums2[o2.get(1)];

        return o1Sum - o2Sum;
      }
    });

    Set<Pair_373> visited = new HashSet<>();

    visited.add(new Pair_373(nums1[0], nums2[0]));

    List<Integer> candi = new ArrayList<>();
    candi.add(0);
    candi.add(0);

    pq.add(candi);

    while (k-- > 0 && !pq.isEmpty()) {
      List<Integer> cur = pq.poll();

      int first = cur.get(0);
      int second = cur.get(1);

      candi = new ArrayList<>();

      candi.add(nums1[first]);
      candi.add(nums2[second]);

      res.add(candi);

      if (first + 1 < n1Size && !visited.contains(new Pair_373(nums1[first + 1], nums2[second]))) {
        candi = new ArrayList<>();

        candi.add(first + 1);
        candi.add(second);

        visited.add(new Pair_373(nums1[first + 1], nums2[second]));

        pq.add(candi);
      }

      if (second + 1 < n2Size && !visited.contains(new Pair_373(nums1[first], nums2[second + 1]))) {
        candi = new ArrayList<>();

        candi.add(first);
        candi.add(second + 1);

        visited.add(new Pair_373(nums1[first], nums2[second + 1]));

        pq.add(candi);
      }
    }

    return res;
  }

  public static void main(String[] args) {
    int[] nums1 = new int[] { 1, 2, 4, 5, 6 };
    int[] nums2 = new int[] { 3, 5, 7, 9 };

    List<List<Integer>> res = kSmallestPairs(nums1, nums2, 3);
    System.out.println("Res: " + res);
  }
}
