package easyproblems;

import java.util.HashMap;

// Took 1 attempt
// Time Taken To Solve: 45 mins
class HouseRobberSolution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
        	return 0;
        }
        int max = 0;
        HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
        	int amt = getMaxAmt(nums, i, memo);
        	if(amt > max){
        		max = amt;
        	}
        }
        return max;
    }

    public int getMaxAmt(int[] nums, int index, HashMap<Integer, Integer> memo){
    	if(memo.get(index) != null){
    		return memo.get(index);
    	}
    	if(index >= nums.length){
    		memo.put(index, 0);
    		return 0;
    	}else{
    		int amt1 = getMaxAmt(nums, index + 3, memo);
    		int amt2 = getMaxAmt(nums, index + 2, memo);
    		int amt = amt1 > amt2 ? amt1 : amt2;
    		memo.put(index, nums[index] + amt);
    		return nums[index] + amt;
    	}
    }
}

public class HouseRobber{
	public static void main(String args[]){
		HouseRobberSolution obj = new HouseRobberSolution();
		int[] nums = {2,10,1,1,1,1,1,9};
		System.out.println(obj.rob(nums));
	}
}