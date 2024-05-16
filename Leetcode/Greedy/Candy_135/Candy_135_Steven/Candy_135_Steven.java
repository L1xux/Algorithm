package Greedy.Candy_135.Candy_135_Steven;

import java.util.Arrays;

public class Candy_135_Steven {
  public static int findLowerRatingAndFillCandies(int now, int size, int[] ratings, int[] candies) {
    if (now + 1 == size) {
      return 1;
    }

    if (ratings[now] <= ratings[now + 1]) {
      return 1;
    }

    candies[now] = 1 + findLowerRatingAndFillCandies(now + 1, size, ratings, candies);
    return candies[now];
  }

  public static int candy(int[] ratings) {
    int size = ratings.length;
    int[] candies = new int[size];

    Arrays.fill(candies, 1);

    for (int i = 0; i < size; i++) {
      int leftCandi = 1, rightCandi = 1;

      if (candies[i] == 1 && i + 1 < size && ratings[i] > ratings[i + 1]) {
        rightCandi = findLowerRatingAndFillCandies(i, size, ratings, candies);
      }

      if (i - 1 >= 0 && ratings[i - 1] < ratings[i]) {
        leftCandi = candies[i - 1] + 1;
        candies[i] = Math.max(leftCandi, rightCandi);
      }
    }

    int res = 0;
    for (int i = 0; i < size; i++) {
      res += candies[i];
    }

    return res;
  }

  public static void main(String[] args) {
    int[] ratings = new int[] { 1, 3, 2, 2, 1 };
    int res = candy(ratings);
    System.out.println("Res: " + res);
  }

}

// 1, 0, 2 res: 5
// 1, 2, 2 res: 4
// 1, 3, 2, 2, 1 res: 7