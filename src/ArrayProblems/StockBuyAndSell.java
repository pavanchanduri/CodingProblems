package ArrayProblems;

public class StockBuyAndSell {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4,10};
        System.out.println("Max Profit: " + maxProfit(prices));
    }

    /**
     * This method calculates the maximum profit that can be achieved from a single buy-sell transaction.
     * The algorithm works as follows:
     * 1. Initialize the buy price to the first day's price and maxProfit to 0.
     * 2. Iterate through the price array starting from the second day.
     * 3. If the current price is less than the buy price, update the buy price.
     * 4. If the current price is greater than the buy price, calculate the profit and update maxProfit if it's higher than the previous maxProfit.
     * 5. Return the maxProfit after iterating through all prices.
     *
     * @param prices Array of stock prices where prices[i] is the price on day i
     * @return The maximum profit achievable from a single buy-sell transaction
     */
    private static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int buy_price = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy_price) {
                buy_price = prices[i];
            } else {
                int sell_price = prices[i];
                int profit = sell_price - buy_price;
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }
}