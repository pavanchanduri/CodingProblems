package MiscProblems;

public class StockBuyAndSell {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4,10};

        int buy_price = prices[0];
        int profit = 0;
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
