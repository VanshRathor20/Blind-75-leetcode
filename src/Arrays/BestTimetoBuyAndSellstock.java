package Arrays;

public class BestTimetoBuyAndSellstock {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i=1; i<prices.length; i++) {
            int price = prices[i];
           int cost=price-minPrice;
           maxProfit=Math.max(maxProfit,cost);
           minPrice=Math.min(minPrice,price);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimetoBuyAndSellstock solution = new BestTimetoBuyAndSellstock();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = solution.maxProfit(prices);
        System.out.println("Maximum Profit: " + result);
    }
}
