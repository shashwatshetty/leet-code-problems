package easyproblems;

// Took 2 attempt
// Time Taken To Solve: 50 mins
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
}

public class BuySellStock{
	public static void main(String args[]){
		BuySellStockSolution obj = new BuySellStockSolution();
		int[] n = {3,2,6,5,0,3};
		System.out.println(obj.maxProfit(n));
	}
}