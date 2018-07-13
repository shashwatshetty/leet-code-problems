package hardproblems;

// Referred The Solution
// Time Taken To Solve: 97 mins
class FirstMissingPositiveSolution {

	/* 
		Below approach, tries to sum the numbers and the get the difference with the sum
		n natural numbers. Approach fails for repetitive numbers and non sequential
		numbers
	*/

	/*
    public int firstMissingPositive(int[] nums) {
        int sum = 0;
        int n = 1;
        for(int i = 0; i < nums.length; i++){
        	if(nums[i] > 0){
        		sum += nums[i];
        		n++;
        	}
        }
        int sumOfN = (n * (n + 1)) / 2;
        int missing = sumOfN - sum;
        return missing;
    }
    */

    /*
    	Below approach, uses the logic of placing the positive numbers at their
    	respective indexes, i.e. 1 on index 0, 2 on index 1, and so on.
    	It sorts the array in place without comparisons and deals with duplicates as well.
    	Worse Case Time Complexity: O(n)
    	Worse Case Space Complexity: O(1)
    */
    public int firstMissingPositive(int[] nums) {
    	if(nums == null || nums.length == 0){
    		return 1;
    	}
    	int index = 0;
    	int val;
    	while(index < nums.length){
    		val = nums[index];
    		while(val > 0 && val != index + 1 && val <= nums.length){
    			if(nums[val - 1] == nums[index]){
    				break;
    			}
    			nums[index] = nums[val - 1];
    			nums[val - 1] = val;
    			val = nums[index];
    		}
    		index++;
    	}
    	System.out.println();
    	int num = 1;
    	for(int i = 0; i < nums.length; i++){
    		if(nums[i] != num){
    			return num;
    		}
    		num++;
    	}
    	return num;
    }
}

public class FirstMissingPositive{
	public static void main(String args[]){
		int[] arr = {7, 8, 9, 2, 4, 1, 5, 3, 6, 10};
		FirstMissingPositiveSolution obj = new FirstMissingPositiveSolution();
		System.out.println(obj.firstMissingPositive(arr));
	}
}