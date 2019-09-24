package easyproblems;

// Took 2 attempt
// Time Taken To Solve: 15 mins
class MaxSubArraySolution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return 0;
        }
        int maxSum = Integer.MIN_VALUE, currSum = 0;
        for(int num : nums) {
        	currSum += num;
        	if (currSum > maxSum) {
        		maxSum = currSum;
        	}
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }
}

public class MaxSubArray {
	public static void main(String args[]) {
		MaxSubArraySolution obj = new MaxSubArraySolution();
		int[] arr1 = {1, 2, 3, 4, 5};
		int[] arr2 = {5, -2, -1, 1, 3, -4};
		int[] arr3 = {-2, -3, -9, -1};
		int[] arr4 = {1, -1, 2, -2, 9, 0, 1};
		System.out.println(obj.maxSubArray(arr1));
		System.out.println(obj.maxSubArray(arr2));
		System.out.println(obj.maxSubArray(arr3));
		System.out.println(obj.maxSubArray(arr4));
	}
}