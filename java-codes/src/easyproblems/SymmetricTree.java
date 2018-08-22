package easyproblems;

// Took 1 attempt
// Time Taken To Solve: 26 mins
class SymmetricTreeSolution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
        	return true;
        }
        return checkSymmetry(root.left, root.right);
    }

    public boolean checkSymmetry(TreeNode l, TreeNode r){
    	if(l == null && r == null){
    		return true;
    	}else if(l == null || r == null){
    		return false;
    	}else{
    		boolean isSame = l.val == r.val;
    		boolean leftMirror = checkSymmetry(l.left, r.right);
    		boolean rightMirror = checkSymmetry(l.right, r.left);
    		return isSame && leftMirror && rightMirror;
    	}
    }
}

public class SymmetricTree{
	public static void main(String args[]){
		SymmetricTreeSolution obj = new SymmetricTreeSolution();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(3);
		TreeNode n6 = new TreeNode(4);
		TreeNode n7 = new TreeNode(4);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n6;
		n3.left = n7;
		n3.right = n5;
		System.out.println(obj.isSymmetric(n1));
	}
}