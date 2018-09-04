package mediumproblems;

import java.util.List;
import java.util.ArrayList;

// Took 2 attempts
// Time Taken To Solve: 57 mins
class PathSumIISolution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> sol = new ArrayList<List<Integer>>();
        List<Integer> now = new ArrayList<Integer>();
        getPath(root, sum, sol, now);
        return sol;
    }

    public void getPath(TreeNode n, int t, List<List<Integer>> sol, List<Integer> now){
    	if(n == null){
    		return;
    	}else{
    		now.add(n.val);
    		checkPath(n, t, sol, now);
    		now.remove(now.size() - 1);
    	}
    }

    public void checkPath(TreeNode n, int sum, List<List<Integer>> sol, List<Integer> now){
    	if(sum - n.val == 0 && n.left == null && n.right == null){
    		List<Integer> path = new ArrayList<Integer>(now);
    		sol.add(path);
    	}else{
    		getPath(n.left, sum - n.val, sol, now);
    		getPath(n.right, sum - n.val, sol, now);
    	}
    }
}

public class PathSumII{
	public static void main(String aargs[]){
		PathSumIISolution obj = new PathSumIISolution();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(7);
		TreeNode n4 = new TreeNode(8);
		TreeNode n5 = new TreeNode(8);
		TreeNode n6 = new TreeNode(3);
		TreeNode n7 = new TreeNode(1);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n5.left = n7;

		TreeNode a1 = new TreeNode(-2);
		TreeNode a2 = new TreeNode(-3);
		a1.right = a2;

		List<List<Integer>> ans = obj.pathSum(n1, 11);
		for(List<Integer> l : ans){
			for(int e : l){
				System.out.print(e+" ");
			}
			System.out.println();
		}
		// System.out.println(ans.size());
	}
}