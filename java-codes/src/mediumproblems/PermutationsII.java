package mediumproblems;

import java.util.List;
import java.util.ArrayList;

// Took 1 attempt
// Time Taken To Solve: 23 mins
class PermutationsIISolution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> all = new ArrayList<List<Integer>>();
        List<Integer> now = new ArrayList<Integer>();
        List<Integer> idx = new ArrayList<Integer>();
        if(nums == null || nums.length == 0){
        	return all;
        }
        getPermutations(all, now, idx, nums, 0);
        return all;
    }

    public void getPermutations(List<List<Integer>> all, List<Integer> now, List<Integer> idx, int[] nums, int len){
    	if(len == nums.length){
    		List<Integer> perm = new ArrayList<Integer>(now);
    		if(!all.contains(perm)){
    			all.add(perm);
    		}
    	}else{
    		for(int i = 0; i < nums.length; i++){
    			if(!idx.contains(i)){
    				now.add(nums[i]);
    				idx.add(i);
    				getPermutations(all, now, idx, nums, len + 1);
    				idx.remove(idx.size() - 1);
    				now.remove(now.size() - 1);
    			}
    		}
    	}
    }
}

public class PermutationsII{
	public static void main(String args[]){
		PermutationsIISolution obj = new PermutationsIISolution();
		int[] n = {4,4,5,5};
		List<List<Integer>> ans = obj.permuteUnique(n);
		for(List<Integer> l  : ans){
			for(int e : l){
				System.out.print(e+" ");
			}
			System.out.println();
		}
	}
}