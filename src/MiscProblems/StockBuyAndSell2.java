package MiscProblems;

/**
1. Set the initial buy price as prices[0]
2. Iterate in the array from element 2 i.e., index 1
3. If the current price is less than previous buy price, set new buy price as prices[i]
4. Else if the current price is more than the previous buy price, set sell price as prices[i]
   and sell the stock i.e., profit = sell price - buy price and keep adding it to the existing profit
5. Now buy a new stock as soon as you sell a stock and iterate in the loop.
 */
public class StockBuyAndSell2 {

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};

        int buyPrice = prices[0];
        int profit, maxProfit=0;

        for(int i=1;i<prices.length;i++) {
            if (buyPrice > prices[i]) {
                buyPrice = prices[i];
            } else {
                int sellPrice = prices[i];
                profit = sellPrice - buyPrice;
                maxProfit += profit;
                buyPrice = prices[i]; //buy on the same day after selling
            }
        }
        System.out.println(maxProfit);
    }
}
