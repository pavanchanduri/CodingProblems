package MiscProblems;

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
