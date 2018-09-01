package easyproblems;

// Took 1 attempt
// Time Taken To Solve: 25 mins
class BalancedBTSolution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
        	return true;
        }else{
        	int l = getDepth(root.left, 0);
        	int r = getDepth(root.right, 0);
        	boolean isCurrent = Math.abs(l - r) <= 1;
        	boolean isLeft = isBalanced(root.left);
        	boolean isRight = isBalanced(root.right);
        	return isCurrent && isLeft && isRight;
        }
    }

    public int getDepth(TreeNode n, int level){
    	if(n == null){
    		return level;
    	}else{
    		int l = getDepth(n.left, level + 1);
    		int r = getDepth(n.right, level + 1);
    		return l > r ? l : r;
    	}
    }
}

public class BalancedBT{
	public static void main(String args[]){
		BalancedBTSolution obj = new BalancedBTSolution();

		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(7);
		TreeNode n4 = new TreeNode(5);
		TreeNode n5 = new TreeNode(4);
		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n3.right = n5;

		TreeNode a1 = new TreeNode(2);
		TreeNode a2 = new TreeNode(5);
		TreeNode a3 = new TreeNode(88);
		TreeNode a4 = new TreeNode(1);
		TreeNode a5 = new TreeNode(5);
		TreeNode a6 = new TreeNode(13);
		TreeNode a7 = new TreeNode(55);
		a1.left = a2;
		a1.right = a3;
		a2.left = a4;
		a2.right = a5;
		a4.left = a6;
		a4.right = a7;
		a3.left = n1;

		System.out.println(obj.isBalanced(n1));
		System.out.println(obj.isBalanced(a1));
	}
}