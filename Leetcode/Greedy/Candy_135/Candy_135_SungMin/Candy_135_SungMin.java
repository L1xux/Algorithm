package Leetcode.Greedy.Candy_135.Candy_135_SungMin;

class Candy_135_SungMin {
    public int candy(int[] ratings) {
        int[] candys = new int[ratings.length];

        
        for(int i = 0; i < ratings.length - 1; i++) {
            if(ratings[i] < ratings[i + 1]) {
                if(candys[i + 1] <= candys[i] + 1)
                    candys[i + 1] = candys[i] + 1;
            }
            if(ratings[ratings.length - i - 1] < ratings[ratings.length - i - 2]) {
                if(candys[ratings.length - i - 2] <= candys[ratings.length - i - 1] + 1)
                    candys[ratings.length - i - 2] = candys[ratings.length - i - 1] + 1;
            }
        }

        int total = 0;

        for(int i = 0; i < ratings.length; i++) {
            total += candys[i];
        }

        total += ratings.length;
        return total;
    }
}