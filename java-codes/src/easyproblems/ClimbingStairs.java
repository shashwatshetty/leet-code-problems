package easyproblems;

// Took 2 attempts Before Referring Solution
// Took 1 attempt After Referring Solution
// Time Taken To Solve: 89 mins
class ClimbingStairsSolution {
    /*
        Below approach permutes the twos and ones in the number whose digits
        add up to the number passed to the function. Code works correctly for
        imput values upto 37, after which the answer differs by one making all
        the values above 37 incorrect.
    */
    /*
    public int climbStairs(int n) {
    	if(n == 0){
    		return 0;
    	}
        int twos = n/2;
        int ones = n%2;
        int digits = twos + ones;
        int count = 0;
        double nF, nrF, tF;
        while(twos >= 0){
        	nF = factorial(digits);
        	nrF = factorial(digits - twos);
        	tF = factorial(twos);
        	count += ((nF/nrF)/tF);
        	twos--;
        	digits++;
        }
        return count;
    }

    public double factorial(int n){
    	double fac = 1;
    	while(n > 1){
    		fac *= n;
    		n--;
    	}
    	return fac;
    }
    */

    /*
        Below approach calculates the n + 1 fibonacci number for the
        number of stairs given as parameters.
    */
    public int climbStairs(int n) {
        if(n == 0){
            return 0;
        }
        int n0 = 1, n1 = 1, next;
        for(int i = 1; i < n; i++){
            next = n0 + n1;
            n0 = n1;
            n1 = next;
        }
        return n1;
    }
}

public class ClimbingStairs{
	public static void main(String args[]){
		ClimbingStairsSolution obj = new ClimbingStairsSolution();
		System.out.println(obj.climbStairs(38));
	}
}