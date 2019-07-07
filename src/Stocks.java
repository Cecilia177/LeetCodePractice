public class Stocks {
    /*动态规划：使用三位数组表示截至到每个状态下的收益值，
    * 三维值分别表示天数/交易次数/手上是否持有股票*/

    public int maxProfit(int[] prices) {

        if(prices.length == 0) {
            return 0;
        }
        int maxprofit = 0;
        int[][][] profits = new int[prices.length][3][2];

        //第一天什么都不做
        profits[0][0][0] = 0;
        //第一天买入
        profits[0][0][1] = -prices[0];
        //第一天完成一次交易（买入并卖出）
        profits[0][1][0] = 0;
        //第一天买入卖出再买入
        profits[0][1][1] = -prices[0];
        //第一天完成两次交易
        profits[0][2][0] = 0;
        //不存在profits[0][2][1]

        for(int i = 1; i < prices.length; i++) {
            //第i天不持有股票（不买）,无交易（不卖）
            profits[i][0][0] = profits[i-1][0][0];

            //第i天持有股票，已完成0次交易，即今日第一次买进或不买
            profits[i][0][1] = Math.max(profits[i-1][0][1], profits[i-1][0][0] - prices[i]);

            //第i天不持有股票，已完成1次交易，即今日第二次卖出或不卖
            profits[i][1][0] = Math.max(profits[i-1][1][0], profits[i-1][0][1] + prices[i]);

            //第i天持有股票，已完成1次交易，即今日第二次买进或不买
            profits[i][1][1] = Math.max(profits[i-1][1][1], profits[i-1][1][0] - prices[i]);

            //第i天不持有股票，已完成第2次交易，即今日第二次卖出或不卖
            profits[i][2][0] = Math.max(profits[i-1][2][0], profits[i-1][1][1] + prices[i]);

            maxprofit = Math.max(Math.max(profits[i][0][0], Math.max(profits[i][0][1], Math.max(profits[i][1][0],
                    Math.max(profits[i][1][1], profits[i][2][0])))), maxprofit);
        }
        return maxprofit;
    }
}

class StocksTest {
    public void test() {
        int[] values1 = new int[]{3,3,5,0,0,3,1,4};
        int[] values2 = new int[]{1,2,3,4,5};
        int[] values3 = new int[]{7,6,4,3,1};

        Stocks stocks = new Stocks();
        System.out.println(stocks.maxProfit(values1));
        System.out.println(stocks.maxProfit(values2));
        System.out.println(stocks.maxProfit(values3));
    }
}