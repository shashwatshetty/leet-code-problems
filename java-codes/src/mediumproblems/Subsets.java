package mediumproblems;

import java.util.ArrayList;
import java.util.List;

// Took 1 attempt
// Time Taken To Solve: 33 mins
class SubsetsSolution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> all = new ArrayList<List<Integer>>();
    	if(nums == null || nums.length == 0){
    		return all;
    	}
        List<Integer> now = new ArrayList<Integer>();
        subs(all, now, nums, 0);
        return all;
    }

    public void subs(List<List<Integer>> sol, List<Integer> soFar, int[] nums, int index){
    	if(index > nums.length){
    		return;
    	}else{
    		sol.add(new ArrayList<Integer>(soFar));
    		for(int i = index; i < nums.length; i++){
    			soFar.add(nums[i]);
    			subs(sol, soFar, nums, i + 1);
    			soFar.remove(soFar.size() - 1);
    		}
    	}
    }
}

public class Subsets{
	public static void main(String args[]){
		SubsetsSolution obj = new SubsetsSolution();
		int[] n = {3,6,9};
		List<List<Integer>> ans = obj.subsets(n);
		for(List<Integer> l : ans){
			for(int e : l){
				System.out.print(e+" ");
			}
			System.out.println();
		}
	}
}