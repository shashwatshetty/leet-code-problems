package easyproblems;

// Took 1 attempts
// Time Taken To Solve: 17 mins
class MinDepthBTSolution {
    public int minDepth(TreeNode root) {
        if(root == null) {
        	return 0;
        }else {
        	return getDepth(root, 1);
        }
    }

    public int getDepth(TreeNode node, int depth) {
    	if(node.left == null && node.right == null) {
    		return depth;
    	}else {
    		int leftDepth = Integer.MAX_VALUE;
    		int rightDepth = Integer.MAX_VALUE;
    		if(node.left != null) {
    			leftDepth = getDepth(node.left, depth + 1);
    		}
    		if(node.right != null) {
    			rightDepth = getDepth(node.right, depth + 1);
    		}
    		return leftDepth < rightDepth ? leftDepth : rightDepth;
    	}
    }
}

public class MinDepthBT {
	public static void main(String args[]) {
		MinDepthBTSolution obj = new MinDepthBTSolution();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		System.out.println(obj.minDepth(n5));
	}
}