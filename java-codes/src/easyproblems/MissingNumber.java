package easyproblems;

// Took 1 attempt
// Time Taken To Solve: 8 mins
class MissingNumberSolution {
    public int missingNumber(int[] nums) {
    	if(nums == null || nums.length == 0) {
    		return 0;
    	}
        int len = nums.length;
        int actualSum = len * (len + 1)/2;
        int sum = 0;
        for(int i : nums) {
        	sum += i;
        }
        return actualSum - sum;
    }
}

public class MissingNumber {
	public static void main(String args[]) {
		MissingNumberSolution obj = new MissingNumberSolution();
		int[] arr = {9,6,4,2,3,5,7,0,1};
		System.out.println(obj.missingNumber(arr));
	}
}