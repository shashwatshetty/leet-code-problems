package easyproblems;

import java.util.Arrays;

// Took 1 attempt Before Referring Solution
// Took 2 attempts After Referring Solution
// Time Taken To Solve: 82 mins
class MaxProductOfThreeSolution {
	/*
		Below approach tries to find the 3 largets numbers in the array 
		and calculates the product. This approach fails the test cases 
		when there is only one positive and rest are all negative numbers.
	*/
	/*
    public int maximumProduct(int[] nums) {
    	if(nums == null || nums.length < 0){
    		return 0;
    	}
        int len = nums.length, count = 3;
        if(len < 3){
        	count = len;
        }
        int prod = 1;
        for(int i = 1; i <= count; i++){
        	int maxNum = Integer.MIN_VALUE;
        	int maxIndex = -1;
        	for(int j = 0; j < len; j++){
        		if(nums[j] > maxNum){
        			maxIndex = j;
        			maxNum = nums[j];
        		}
        	}
        	prod *= maxNum;
        	nums[maxIndex] = nums[len - 1];
        	nums[len - 1] = maxNum;
        	len--;
        }
        return prod;
    }
    */

    /*
    	Below approach, sorts the array, then we calculate two products,
    	one using the minimum two with the maximum of the array and the other
    	using the maximum three of the array, whichever is larger, we return
    	that as the answer.
    */
    public int maximumProduct(int[] nums) {
    	if(nums == null || nums.length < 0){
    		return 0;
    	}
        int len = nums.length;
    	Arrays.sort(nums);
    	int prodMin = nums[len - 1], prodMax = nums[len - 1];
    	int minIndex = 0, maxIndex = len - 2;
    	while(minIndex < 2){
    		prodMin *= nums[minIndex];
    		prodMax *= nums[maxIndex];
    		minIndex++;
    		maxIndex--;
    	}
        int prod = prodMin > prodMax ? prodMin : prodMax;
        return prod;
    }
}

public class MaxProductOfThree{
	public static void main(String args[]){
		MaxProductOfThreeSolution obj = new MaxProductOfThreeSolution();
		int[] n = {0,-2,-3, -4};
		System.out.println(obj.maximumProduct(n));
	}
}