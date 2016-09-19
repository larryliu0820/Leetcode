/**
 * Created by Valued Customer on 9/18/2016.
 * 123. Best Time to Buy and Sell Stock III
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most two transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class p123 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[] profit = new int[prices.length];
        int lowest = profit[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < lowest) {
                lowest = prices[i];
                continue;
            }
            for (int j = 0; j <= i; j++) {
                if (prices[i] < prices[j]) continue;
                if (j == 0) {
                    profit[i] = Math.max(profit[i], prices[i] - prices[j]);
                } else {
                    profit[i] = Math.max(profit[i], profit[j-1] + prices[i] - prices[j]);
                }
            }
            profit[i] = Math.max(profit[i], profit[i-1]);
        }
        return profit[profit.length-1];
    }
}
