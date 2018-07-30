package easyproblems;

import java.util.ArrayList;
import java.util.List;

// Took 1 attempt
// Time Taken To Solve: 25 mins
class PascalsTriangleSolution {
    public List<List<Integer>> generate(int numRows) {
        List<Integer> prev = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 1; i <= numRows; i++){
        	List<Integer> curr = new ArrayList<Integer>();
        	for(int j = 1; j <= i; j++){
        		if(j == 1 || j == i){
        			curr.add(1);
        		}else{
        			int elem = prev.get(j - 2) + prev.get(j - 1);
        			curr.add(elem);
        		}
        	}
        	res.add(curr);
        	prev = curr;
        }
        return res;
    }
}

public class PascalsTriangle{
	public static void main(String args[]){
		PascalsTriangleSolution obj = new PascalsTriangleSolution();
		List<List<Integer>> ans = obj.generate(8);
		for(List<Integer> l : ans){
			for(int e : l){
				System.out.print(e+" ");
			}
			System.out.println();
		}
	}
}