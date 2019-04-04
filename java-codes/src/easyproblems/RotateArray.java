package easyproblems;

import java.util.Arrays;

// Took 2 attempts
// Time Taken To Solve: 55 mins
class RotateArraySolution {
	public void rotate(int[] nums, int k) {
		if(nums == null || nums.length == 0) {
			return;
		}
		k = k % nums.length;
		while(k > 0) {
			int i = nums.length - 1;
			int last = nums[i];
			while(i > 0) {
				nums[i] = nums[i - 1];
				i--;
			}
			nums[0] = last;
			k--;
		}
    }

    /*
    public void rotate(int[] nums, int k) {
    	if(nums == null || nums.length == 0) {
    		return;
    	}
        int len = nums.length;

        int index = k % len;
        int rotate = nums[0];
        while(index != 0) {
        		int t = nums[index];
        		nums[index] = rotate;
        		rotate = t;
        		index = (index + k) % len;
        }
        nums[index] = rotate;
    }
    */

}

public class RotateArray {
	public static void main(String args[]) {
		RotateArraySolution obj = new RotateArraySolution();
		int[] arr = {1, 2, 3, 4, 5, 6};
		obj.rotate(arr, 6);
		System.out.println(Arrays.toString(arr));
	}
}