package mediumproblems;

// Took 4 attempts
// Time Taken To Solve: 50 mins
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class ValidBstSolution {
    public boolean isValidBST(TreeNode root) {
    	boolean isMin, isMax, isLeft, isRight;
        if(root == null || (root.left == null && root.right == null)){
        	return true;
        }else if(root.left == null){
        	isMin = true;
        	isMax = root.val < getMin(root.right);
        }else if(root.right == null){
        	isMin = root.val > getMax(root.left);
        	isMax = true;
        }else{
        	isMin = root.val > getMax(root.left);
        	isMax = root.val < getMin(root.right);
        }
    	isLeft = isValidBST(root.left);
    	isRight = isValidBST(root.right);
        return isMin && isMax && isLeft && isRight;
    }

    public int getMin(TreeNode x){
    	int minVal = x.val;
    	while(x != null){
    		minVal = x.val;
    		x = x.left;
    	}
    	return minVal;
    }

    public int getMax(TreeNode x){
    	int maxVal = x.val;
    	while(x != null){
    		maxVal = x.val;
    		x = x.right;
    	}
    	return maxVal;
    }
}

public class ValidBst{
	public static void main(String args[]){
		ValidBstSolution obj = new ValidBstSolution();
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(9);
		TreeNode n4 = new TreeNode(6);
		TreeNode n5 = new TreeNode(11);
		TreeNode n6 = new TreeNode(1);
		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n3.right = n5;
		n5.left = n6;
		System.out.println(obj.isValidBST(n1));
	}
}