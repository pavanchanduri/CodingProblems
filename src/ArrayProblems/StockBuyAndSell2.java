package ArrayProblems;

public class StockBuyAndSell2 {

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println("Max Profit: " + maxProfitUnlimitedTransactions(prices));
    }

    /**
     * This method calculates the maximum profit that can be achieved from multiple buy-sell transactions.
     * The algorithm works as follows:
     * 1. Initialize the buy price to the first day's price and maxProfit to 0.
     * 2. Iterate through the price array starting from the second day.
     * 3. If the current price is less than the buy price, update the buy price.
     * 4. If the current price is greater than the buy price, calculate the profit, add it to maxProfit, and update the buy price to the current price (to simulate buying again).
     * 5. Return the maxProfit after iterating through all prices.
     *
     * @param prices Array of stock prices where prices[i] is the price on day i
     * @return The maximum profit achievable from multiple buy-sell transactions
     */
    private static int maxProfitUnlimitedTransactions(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int buyPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            } else {
                int sellPrice = prices[i];
                maxProfit += sellPrice - buyPrice;
                buyPrice = prices[i]; // buy again after selling
            }
        }
        return maxProfit;
    }
}