package easyproblems;

// Referred The Solution
// Time Taken To Solve: 40 mins
class SingleNumberSolution {
    /*
        Below approach takes the XOR for each number
        and in the end the single number only will be left since
        the XOR for similar numbers in 0.
    */
    public int singleNumber(int[] nums) {
        int x = 0;
        for(int e : nums){
        	x = x ^ e;
        }
        return x;
    }
}

public class SingleNumber{
	public static void main(String args[]){
		SingleNumberSolution obj = new SingleNumberSolution();
		int[] n = {1,3,4,3,1};
		System.out.println(obj.singleNumber(n));
	}
}