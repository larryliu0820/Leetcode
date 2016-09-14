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
        return maxProfitHelper(prices, 0, prices.length-1);
    }

    private int maxProfitHelper(int[] prices, int begin, int end) {
        if (end - begin < 1) return 0;
        int max = 0;

        for (int i = begin; i < end; i++) {
            int currMax = 0;
            for (int j = i+1; j <= end; j++) {
                if (prices[j] - prices[i] <= currMax) continue;
                currMax = prices[j] - prices[i];
                int remainMax = 0;
                if (j+2 != end) {
                    remainMax = maxProfitHelper(prices, j+2, end);
                }
                max = Math.max(max, currMax + remainMax);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        p309 sol = new p309();
        System.out.println(sol.maxProfit(new int[]{2,1,4,5,2,9,7}));

    }
}
