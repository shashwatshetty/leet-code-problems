package mediumproblems;

import java.util.List;
import java.util.ArrayList;

// Took 1 attempt
// Time Taken To Solve: 26 mins
class CombinationsSolution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> all = new ArrayList<List<Integer>>();
        if(n < 1 || k < 1){
        	return all;
        }
        List<Integer> now = new ArrayList<Integer>();
        getCombos(all, now, n, k, 0, 1);
        return all;
    }

    public void getCombos(List<List<Integer>> sol, List<Integer> soFar, int n, int k, int len, int start){
    	if(len > k){
    		return;
    	}else if(len == k){
    		List<Integer> combo = new ArrayList<Integer>(soFar);
    		sol.add(combo);
    	}else{
    		for(int i = start; i <= n; i++){
    			soFar.add(i);
    			getCombos(sol, soFar, n, k, len + 1, i + 1);
    			soFar.remove(soFar.size() - 1);
    		}
    	}
    }
}

public class Combinations{
	public static void main(String args[]){
		CombinationsSolution obj = new CombinationsSolution();
		List<List<Integer>> ans = obj.combine(4, 2);
		for(List<Integer> l : ans){
			for(int e : l){
				System.out.print(e+" ");
			}
			System.out.println();
		}
	}
}