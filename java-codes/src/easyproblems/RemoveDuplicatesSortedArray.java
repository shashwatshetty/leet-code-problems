package easyproblems;

import java.util.Arrays;

// Took 1 attempts
// Time Taken To Solve: 49 mins
class RemoveDuplicatesSortedArraySolution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return 0;
        }
        int i = 0;
        for(int j = 0; j < nums.length; j++) {
        	while(j < nums.length - 1 && nums[j] == nums[j + 1]) {
        		j++;
        	}
        	nums[i] = nums[j];
        	i++;
        }
        return i;
    }
}

public class RemoveDuplicatesSortedArray {
	public static void main(String args[]) {
		RemoveDuplicatesSortedArraySolution obj = new RemoveDuplicatesSortedArraySolution();
		int[] arr = {1, 3, 3, 3, 5};
		int ans = obj.removeDuplicates(arr);
		System.out.println(ans);
		System.out.println(Arrays.toString(arr));
	}
}