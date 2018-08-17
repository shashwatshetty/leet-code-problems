package easyproblems;

// Took 4 attempts Before Referring Solution
// Took 1 attempt After Referring Solution
// Time Taken To Solve: 54 mins
class PathSumSolution {
	/*
		Below approach uses a recursive function which continues the call
		down the tree till the sum doesnt become 0. However it fails test cases
		as we need to check the path from root to leaf and it doesn't consider
		the entire path.
	*/
	/*
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root != null && (sum - root.val) == 0){
        	return true;
        }else if(sum < 0 || root == null){
        	return false;
        }else{
        	boolean left = hasPathSum(root.left, sum - root.val);
        	boolean right = hasPathSum(root.right, sum - root.val);
        	return left || right;
        }
    }
    */

	/*
		Below approach checks if a node is a leaf node and only then does it compare
		the value of the node to the sum. In other cases, it recursively calls the 
		left node and right node by decrementing the sum with the current node value.
	*/
    public boolean hasPathSum(TreeNode root, int sum) {
    	if(root == null){
    		return false;
    	}else{
    		return checkPathSum(root, sum);
    	}
    }

    public boolean checkPathSum(TreeNode node, int t){
    	if(node.left == null && node.right == null){
    		return node.val == t;
    	}else{
    		boolean l = hasPathSum(node.left, t - node.val);
    		boolean r = hasPathSum(node.right, t - node.val);
    		return l || r;
    	}
    }
}

public class PathSum{
	public static void main(String args[]){
		PathSumSolution obj = new PathSumSolution();
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(4);
		TreeNode n3 = new TreeNode(8);
		TreeNode n4 = new TreeNode(11);
		TreeNode n5 = new TreeNode(13);
		TreeNode n6 = new TreeNode(4);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(2);
		TreeNode n9 = new TreeNode(1);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n3.left = n5;
		n3.right = n6;
		n4.left = n7;
		n4.right = n8;
		n6.right = n9;
		System.out.println(obj.hasPathSum(n1, 22));
	}
}