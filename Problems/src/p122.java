/**
 * Created by Valued Customer on 9/18/2016.
 * 122. Best Time to Buy and Sell Stock II
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell
 one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you
 must sell the stock before you buy again).
 */
public class p122 {
    public int maxProfit2(int[] prices) {
        int total = 0;
        for (int i=0; i< prices.length-1; i++) {
            if (prices[i+1]>prices[i]) total += prices[i+1]-prices[i];
        }
        return total;
    }

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

    public static void main(String[] args) {
        p122 sol = new p122();
        System.out.println(sol.maxProfit(new int[]{2,1,4,5,2,9,7}));
    }
}
