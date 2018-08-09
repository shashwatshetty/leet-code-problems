package easyproblems;

import java.util.HashMap;

// Took 1 attempt
// Time Taken To Solve: 21 mins
class MajorityElementSolution {
    public int majorityElement(int[] nums) {
    	if(nums == null || nums.length == 0){
    		return 0;
    	}
        Integer maxCount = 0, majElem = null;
        HashMap<Integer, Integer> counter = new HashMap<Integer, Integer>();
        for(Integer e : nums){
        	Integer count = counter.get(e);
        	if(count != null){
        		count++;
        	}else{
        		count = 1;
        	}
        	counter.put(e, count);
        	if(count > maxCount){
        		maxCount = count;
        		majElem = e;
        	}
        }
        return majElem;
    }
}

public class MajorityElement{
	public static void main(String args[]){
		MajorityElementSolution obj = new MajorityElementSolution();
		int[] n = {2,2,1,1,1,2,2};
		System.out.println(obj.majorityElement(n));
	}
}