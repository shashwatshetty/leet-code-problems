package easyproblems;

// Took 2 attempt
// Time Taken To Solve: 50 mins

// Re-Done in 3 attempts Before Referring Solution
// Re-Done in 1 attempt After Referring Solution
// Time Taken: 54 mins
class BuySellStockSolution {
	/*
		Below approach gets the minimum stock price from the left and the 
		maximum stock price from the right, the subtraction of maximum and
		minimum will give the profit. However this approach fails for test
		cases when the prices array is not evenly distributed with minimum numbers
		to the left and maximum numbers to the right.
	*/
	/*
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if(prices == null || prices.length == 0){
        	return maxProfit;
        }
        int minPrice = Integer.MAX_VALUE;
        int maxPrice = Integer.MIN_VALUE;
        for(int i = 0, j = prices.length - 1; i <= j; i++, j--){
        	minPrice = minPrice < prices[i] ? minPrice : prices[i];
        	maxPrice = maxPrice > prices[j] ? maxPrice : prices[j];
        }
        int profit = (maxPrice - minPrice);
        return maxProfit > profit ? maxProfit : profit;
    }
    */

    public int maxProfit(int[] prices) {
    	int maxProfit = 0;
        if(prices == null || prices.length == 0){
        	return maxProfit;
        }
        for(int i = 0; i < prices.length - 1; i++){
        	for(int j = i + 1; j < prices.length; j++){
        		int profit = prices[j] - prices[i];
        		if(profit > maxProfit){
        			maxProfit = profit;
        		}
        	}
        }
        return maxProfit;
    }

    /*
    	Re-Do attempt, logic was to find the lowest and highest values in the array
    	and store their indices. If low index is less than high index, return the difference
    	of high and low else, find the maximum difference in their own halves and return the
    	maximum of the two. Fails for the test case when low and high are at the ends of the array.
     */
	/*
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int low = Integer.MAX_VALUE, high = 0;
		int lowIdx = 0, highIdx = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < low) {
				low = prices[i];
				lowIdx = i;
			}
			if (prices[i] > high) {
				high = prices[i];
				highIdx = i;
			}
		}
		if (lowIdx <= highIdx) {
			return high - low;
		} else {
			int rightProfit = 0, leftProfit = 0;
			while (++lowIdx <= prices.length - 1) {
				int p = prices[lowIdx] - low;
				if (rightProfit < p) {
					rightProfit = p;
				}
			}
			while (--highIdx >= 0) {
				int p = high - prices[highIdx];
				if (leftProfit < p) {
					leftProfit = p;
				}
			}
			return leftProfit > rightProfit ? leftProfit : rightProfit;
		}
	}
	*/

	/*
		Basic approach is to keep track of the minimum price so far and the max profit
		we get with that minimum price. When the minimum price changes, we also keep track of
		the previous max profit and also only look at only the profit after that minimum
		price emulating the stock exchange.
	 */
	public int maxProfitREDO(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int minPrice = Integer.MAX_VALUE, maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minPrice) {
				minPrice = prices[i];
			} else if (maxProfit < prices[i] - minPrice) {
				maxProfit = prices[i] - minPrice;
			}
		}
		return maxProfit;
	}
}

public class BuySellStock{
	public static void main(String args[]){
		BuySellStockSolution obj = new BuySellStockSolution();
		int[] n = {3,2,6,5,0,3};
		System.out.println(obj.maxProfit(n));
	}
}