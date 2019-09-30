package mediumproblems;

import java.util.Arrays;

// Took 1 attempt
// Time Taken To Solve: 40 mins
class ThreeSumClosestSolution {
    public int threeSumClosest(int[] nums, int target) {
    	if (nums == null || nums.length == 0) {
    		return 0;
    	}
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE, minSum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
        	int low = i + 1, high = nums.length - 1;
        	while (low < high) {
        		int sum = nums[i] + nums[low] + nums[high];
        		int diff = Math.abs(target - sum);
        		if (diff < minDiff) {
        			minDiff = diff;
        			minSum = sum;
        		}
        		if (sum == target) {
        			return minSum;
        		} else if (sum > target) {
        			high--;
        		}else if (sum < target) {
        			low++;
        		}
        	}
        }
        return minSum;
    }
}

public class ThreeSumClosest {
	public static void main (String args[]) {
		ThreeSumClosestSolution obj = new ThreeSumClosestSolution();
		int[] arr = {5, 3, 1, -1, -2};
		System.out.println(obj.threeSumClosest(arr, 0));
	}
}