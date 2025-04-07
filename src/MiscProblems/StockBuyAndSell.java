package MiscProblems;

/*
1. Set the initial buy price as prices[0]
2. Iterate in the array from element 2 i.e., index 1
3. If the current price is less than previous buy price, set new buy price as prices[i]
4. Else if the current price is more than the previous buy price, set sell price as prices[i]
   and sell the stock i.e., profit = sell price - buy price and store the profit and change it
   if current profit > maxProfit till now.
 */
public class StockBuyAndSell {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4,10};

        int buy_price = prices[0];
        int profit;
        int maxProfit = 0;

        for(int i = 1; i< prices.length; i++){
            if(prices[i]<buy_price){
                buy_price = prices[i];
            } else {
                int sell_price = prices[i];
                profit = sell_price-buy_price;
                if(profit>maxProfit){
                    maxProfit = profit;
                }
            }
        }
        System.out.println("Max Profit: "+maxProfit);
    }
}
