package mediumproblems;

import java.util.ArrayList;
import java.util.List;

// Took 1 attempt
// Time Taken To Solve: 52 mins
class PermutationsSolution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> perms = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
        	return perms;
        }
        List<Integer> now = new ArrayList<Integer>();
        getPermutations(perms, now, 0, nums);
        return perms;
    }

    public void getPermutations(List<List<Integer>> p, List<Integer> now, int len, int[] nums){
    	if(len > nums.length){
    		return;
    	}else if(len == nums.length){
    		List<Integer> perm = new ArrayList<Integer>(now);
    		p.add(perm);
    	}else{
    		for(int i = 0; i < nums.length; i++){
    			if(!now.contains(nums[i])){
    				now.add(nums[i]);
    				len = len + 1;
	    			getPermutations(p, now, len, nums);
	    			now.remove(now.size() - 1);
	    			len = len - 1;
    			}
    		}
    	}
    }
}

public class Permutations{
	public static void main(String args[]){
		PermutationsSolution obj = new PermutationsSolution();
		int[] n = {6,5,4,3,2,1};
		List<List<Integer>> ans = obj.permute(n);
		for(List<Integer> l : ans){
			for(int e : l){
				System.out.print(e+" ");
			}
			System.out.println();
		}
	}
}