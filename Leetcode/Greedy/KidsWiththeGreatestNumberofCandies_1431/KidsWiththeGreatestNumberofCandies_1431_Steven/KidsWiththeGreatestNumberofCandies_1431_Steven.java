package Greedy.KidsWiththeGreatestNumberofCandies_1431_Steven;

import java.util.ArrayList;
import java.util.List;

public class KidsWiththeGreatestNumberofCandies_1431_Steven {
  public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    int size = candies.length;
    int max = candies[0];

    for (int i = 0; i < size; i++) {
      max = Math.max(max, candies[i]);
    }

    List<Boolean> res = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      res.add(candies[i] + extraCandies >= max);
    }

    return res;
  }

  public static void main(String[] args) {
    int[] candies = new int[] { 2, 3, 5, 1, 3 };
    int extra = 3;

    List<Boolean> res = kidsWithCandies(candies, extra);

    for (boolean elem : res) {
      System.out.println("Elem: " + elem);
    }

  }
}
