package easyproblems;

// Took 1 attempt
// Time Taken To Solve:33 mins


// To run the file uncomment this section
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

class MaxDepthBinaryTreeSolution {
    public int maxDepth(TreeNode root) {
        return findDepth(root, 0);
    }

    public int findDepth(TreeNode node, int d){
    	if(node != null){
    		int leftDepth = findDepth(node.left, d + 1);
    		int rightDepth = findDepth(node.right, d + 1);
    		if(leftDepth >= rightDepth){
    			return leftDepth;
    		}else{
    			return rightDepth;
    		}
    	}
    	return d;
    }
}

public class MaxDepthBinaryTree{
	public static void main(String args[]){
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(9);
		TreeNode n3 = new TreeNode(20);
		TreeNode n4 = new TreeNode(15);
		TreeNode n5 = new TreeNode(7);
		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n3.right = n5;
		MaxDepthBinaryTreeSolution obj = new MaxDepthBinaryTreeSolution();
		System.out.println(obj.maxDepth(null));
	}
}