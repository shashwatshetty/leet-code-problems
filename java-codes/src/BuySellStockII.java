// Took 2 attempts
// Time Taken To Solve: 25 mins
class BSSIISolution {
    public int maxProfit(int[] prices) {
    	if(prices.length < 2){
    		return 0;
    	}
        int[] diff = new int[prices.length - 1];
        int sub;
        for(int i = 0; i < prices.length - 1; i++){
        	sub = prices[i + 1] - prices[i];
        	if(sub < 0){
        		sub = 0;
        	}
        	diff[i] = sub;
        }
        int sum = 0;
        for(int i = 0; i < diff.length; i++){
        	sum += diff[i];
        }
        return sum;
    }
}

public class BuySellStockII{
    public static void main(String args[]){
    	int[] arr = {};
    	BSSIISolution obj = new BSSIISolution();
    	System.out.println(obj.maxProfit(arr));
    }
}