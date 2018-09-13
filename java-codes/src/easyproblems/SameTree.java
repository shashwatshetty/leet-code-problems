package easyproblems;

// Took 1 attempt
// Time Taken To Solve: 11 mins
class SameTreeSolution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
        	return true;
        }else if(p == null || q == null){
        	return false;
        }else{
        	boolean isVal = p.val == q.val;
        	boolean isLeft = isSameTree(p.left, q.left);
        	boolean isRight = isSameTree(p.right, q.right);
        	return isVal && isLeft && isRight;
        }
    }
}

public class SameTree{
	public static void main(String args[]){
		SameTreeSolution obj = new SameTreeSolution();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.left = t2;
		t2.right = t3;
		
		TreeNode k1 = new TreeNode(1);
		TreeNode k2 = new TreeNode(2);
		TreeNode k3 = new TreeNode(3);
		k1.left = k2;
		k2.left = k3;

		System.out.println(obj.isSameTree(t1, k1));
	}
}