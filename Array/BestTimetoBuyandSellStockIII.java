package Array;

public class BestTimetoBuyandSellStockIII {

	public int maxProfit(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}
		int[] curProfit = new int[prices.length];
		curProfit[0] = 0;
		int low = prices[0];
		for (int i = 1; i < curProfit.length; i++) {
			low = Math.min(low, prices[i]);
			curProfit[i] = Math.max(curProfit[i-1], prices[i]-low);
		}
		int[] futureProfit = new int[prices.length];
		futureProfit[prices.length-1] = 0;
		int high = prices[prices.length-1];
		for (int i = curProfit.length-2; i >= 0; i--) {
			high = Math.max(high, prices[i]);
			futureProfit[i] = Math.max(futureProfit[i+1], high-prices[i]);
		}
		int max = 0;
		for (int i = 0; i < prices.length; i++) {
			max = Math.max(max, curProfit[i] + futureProfit[i]);
		}
		return max;
	}

}
