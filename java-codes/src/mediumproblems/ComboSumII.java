package mediumproblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

// Took 1 attempt
// Time Taken To Solve: 34 mins
class ComboSumIISolution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> all = new HashSet<List<Integer>>();
        if(candidates == null || candidates.length == 0){
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(candidates);
        List<Integer> soFar = new ArrayList<Integer>();
        combo(all, soFar, candidates, 0, target);
        return new ArrayList<List<Integer>>(all);
    }

    public void combo(Set<List<Integer>> all, List<Integer> now, int[] candidates, int start, int remaining){
        if(remaining < 0){
            return;
        }else if(remaining == 0){
            all.add(new ArrayList<Integer>(now));
        }else{
            for(int i = start; i < candidates.length; i++){
                now.add(candidates[i]);
                combo(all, now, candidates, i + 1, remaining - candidates[i]);
                now.remove(now.size() - 1);
            }
        }
    }
}

class ComboSumII{
    public static void main(String args[]){
        ComboSumIISolution obj = new ComboSumIISolution();
        int[] n = {2,5,2,1,2};
        List<List<Integer>> ans = obj.combinationSum2(n, 5);
        for(List<Integer> l : ans){
            for(int e : l){
                System.out.print(e+" ");
            }
            System.out.println();
        }
    }
}