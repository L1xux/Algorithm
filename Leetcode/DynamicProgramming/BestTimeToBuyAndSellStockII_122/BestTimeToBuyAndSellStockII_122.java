package BestTimeToBuyAndSellStockII_122;

public class BestTimeToBuyAndSellStockII_122 {
  public static int maxProfit(int[] prices) {
    int pSize = prices.length;

    int[] myPrices = new int[pSize + 1];
    int[] max = new int[pSize + 1];

    for (int i = 1; i <= pSize; i++) {
      myPrices[i] = prices[i - 1];
    }

    for (int i = 2; i <= pSize; i++) {
      int curVal = myPrices[i];
      max[i] = max[i - 1];
      
      for (int j = i - 1; j >= 1; j--) {
        max[i] = Math.max(max[i], curVal - myPrices[j] + max[j - 1]);
      }
     
    }

    return max[pSize];
  }

  public static void main(String[] args) {
    int[] prices = new int[] { 1, 2, 3, 4, 5 };
    int res = maxProfit(prices);

    System.out.println("Res: " + res);
  }
}