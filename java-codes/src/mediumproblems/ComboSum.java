package mediumproblems;

import java.util.ArrayList;
import java.util.List;
/*
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
*/

// Referred The Solution
// Time Taken To Solve: 113 mins
class ComboSumSolution {
	/*
		Below approach stores all the candidate numbers in a HashMap. Then,
		for each candidate number, it decreases the target and checks if the
		difference is present in the HashMap, if it is, we add it to the solution set
		else we keep decreasing. It also uses Sets to avoid duplicates.
		This approach fails cases when the target is a sum of 3 or more numbers used only once
		and also doesn't solve the duplicates issue well.
	*/
	/*
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        HashMap<Integer, Integer> nums = new HashMap<Integer, Integer>();
        for(int i = 0; i < candidates.length; i++){
        	nums.put(candidates[i], i);
        }
        Set<List<Integer>> sol = new HashSet<List<Integer>>();
        for(int i = 0; i < candidates.length; i++){
        	int t = target;
        	int curr = candidates[i];
        	List<Integer> soFar = new ArrayList<Integer>();
        	while(t >= 0){
	        	if(nums.get(t) != null){
	        		List<Integer> combo = new ArrayList<Integer>(soFar);
	        		combo.add(t);
	        		sol.add(combo);
	        	}else if(t == 0){
	        		sol.add(soFar);
	        	}
	        	t -= curr;
	        	soFar.add(curr);
        	}
        }
        return new ArrayList<List<Integer>>(sol);
    }
    */

	/*
		Below approach uses recursion, to decrease the target by each number and
		recursively calls the method for the new decreased target. This way it is
		able to backtrack to previous combinations and also handles the duplicates
		as it checks for a particular combination only once.
	*/
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> sol = new ArrayList<List<Integer>>();
    	if(candidates == null || candidates.length == 0){
    		return sol;
    	}
        List<Integer> soFar = new ArrayList<Integer>();
        combos(sol, soFar, candidates, target, 0);
        return sol;
    }

    public void combos(List<List<Integer>> all, List<Integer> now, int[] nums, int left, int start){
    	if(left < 0){
    		return;
    	}else if(left == 0){
    		List<Integer> combo = new ArrayList<Integer>(now);
    		all.add(combo);
    	}else{
    		for(int i = start; i < nums.length; i++){
    			now.add(nums[i]);
    			combos(all, now, nums, left - nums[i], i);
    			now.remove(now.size() - 1);
    		}
    	}
    }
}

public class ComboSum{
	public static void main(String args[]){
		int[] n = {4,8,2};
		ComboSumSolution obj = new ComboSumSolution();
		List<List<Integer>> ans = obj.combinationSum(n, 10);
		for(List<Integer> l : ans){
			for(int e : l){
				System.out.print(e+" ");
			}
			System.out.println();
		}
	}
}