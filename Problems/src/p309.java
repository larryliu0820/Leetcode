/**
 * Created by mengwliu on 9/13/16.
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell
 one share of the stock multiple times) with the following restrictions:

 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)

 Example:

 prices = [1, 2, 3, 0, 2]
 maxProfit = 3
 transactions = [buy, sell, cooldown, buy, sell]

 */
public class p309 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[] memo = new int[prices.length];
        memo[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < i; j++) {
                int diff = prices[i] - prices[j];
                if (diff < 0) continue;
                if (j <= 1) memo[i] = Math.max(memo[i],diff);
                else memo[i] = Math.max(memo[i], memo[j-2] + diff);
            }
            memo[i] = Math.max(memo[i-1], memo[i]);
        }
        return memo[prices.length-1];
    }

    public static void main(String[] args) {
        p309 sol = new p309();
        System.out.println(sol.maxProfit(new int[]{1,2,4}));

    }
}
