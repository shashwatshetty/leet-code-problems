package mediumproblems;

import java.util.HashMap;

// Took 1 attempt
// Time Taken To Solve: 31 mins
class PowSolution {
    public double myPow(double x, int n) {
    	HashMap<Integer, Double> memo = new HashMap<Integer, Double>();
    	if(n == 0){
    		return 1;
    	}
    	return power(x, n, memo);
    }

    public double power(double x, int n, HashMap<Integer, Double> memo){
    	if(memo.get(n) != null){
    		return memo.get(n);
    	}
    	double ans;
    	if(n > 0){
	        if(n == 1){
	        	memo.put(n, x);
	        	return x;
	        }else if(n%2 == 0){
	        	ans = power(x, n/2, memo) * power(x, n/2, memo);
	        	memo.put(n, ans);
	        	return ans;
	        }else{
	        	ans = x * power(x, n/2, memo) * power(x, n/2, memo);
	        	memo.put(n, ans);
	        	return ans;
	        }
    	}else{
	        if(n == -1){
	        	memo.put(n, 1/x);
	        	return 1/x;
	        }else if(n%2 == 0){
	        	ans = power(x, n/2, memo) * power(x, n/2, memo);
	        	memo.put(n, ans);
	        	return ans;
	        }else{
	        	ans = 1/x * power(x, n/2, memo) * power(x, n/2, memo);
	        	memo.put(n, ans);
	        	return ans;
	        }
    	}
    }
}

public class Pow{
	public static void main(String args[]){
		PowSolution obj = new PowSolution();
		System.out.println(obj.myPow(10, -1));
	}
}