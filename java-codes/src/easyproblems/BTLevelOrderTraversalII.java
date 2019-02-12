package easyproblems;
import java.util.ArrayList;
import java.util.List;

// Took 3 attempts!
// Time Taken To Solve: 74 mins
class BTLevelOrderTraversalIISolution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> all = new ArrayList<List<Integer>>();
        if(root == null) {
        	return all;
        }
        all.add(new ArrayList<Integer>());
        return getLowestOrder(all, root, 0);
    }

    public List<List<Integer>> getLowestOrder(List<List<Integer>> all, TreeNode node, int level) {
    	if(node == null) {
    		return all;
    	}else {
    		List<Integer> currentList = all.get(all.size() - 1 - level);
    		currentList.add(node.val);
    		if(all.size() - 1 <= level && (node.left != null || node.right != null)) {
    			all.add(0, new ArrayList<Integer>());
    		}
    		getLowestOrder(all, node.left, level + 1);
    		getLowestOrder(all, node.right, level + 1);
    	}
    	return all;
    }
}

public class BTLevelOrderTraversalII {
	public static void main(String args[]) {
		BTLevelOrderTraversalIISolution obj = new BTLevelOrderTraversalIISolution();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		List<List<Integer>> ans = obj.levelOrderBottom(t1);
		for(List<Integer> l : ans) {
			for(Integer i : l) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}