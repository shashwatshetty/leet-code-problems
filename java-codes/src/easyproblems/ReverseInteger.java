package easyproblems;

// Took 2 attempts
// Time Taken To Solve: 37 mins
class ReverseIntegerSolution {
    public int reverse(int x) {
    	int mul = 1;
        if(x < 0) {
        	mul = -1;
        	x *= -1;
        }
        int rev = 0;
        while(x != 0) {
        	if(rev != (rev * 10)/10) {
        		return 0;
        	}
        	rev = (rev * 10) + (x % 10);
        	x /= 10;
        	// System.out.println(rev);
        }
        rev *= mul;
        if(mul < 0 && rev > 0) {
        	return 0;
        }
        return rev;
    }
}

public class ReverseInteger {
	public static void main(String args[]) {
		ReverseIntegerSolution obj = new ReverseIntegerSolution();
		System.out.println(obj.reverse(1437889999));
	}
}