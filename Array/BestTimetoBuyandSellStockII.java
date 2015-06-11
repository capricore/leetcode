package Array;


public class BestTimetoBuyandSellStockII {
	public int maxProfit(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}
		int low = prices[0];
		int max = 0;
		for (int i = 1; i < prices.length; i++) {
			low = Math.min(low, prices[i]);
			if (prices[i] - low > 0) {
				max += prices[i] - low;
				low = prices[i];
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] prices= {1,2,4};
		System.out.println(new BestTimetoBuyandSellStockII().maxProfit(prices));
	}
}
