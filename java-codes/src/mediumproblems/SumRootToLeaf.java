package mediumproblems;

// Took 1 attempt
// Time Taken To Solve: 25 mins
class SumRootToLeafSolution {
    public int sumNumbers(TreeNode root) {
        if(root == null) {
        	return 0;
        }
        return addPathNumbers(root, 0);
    }

    public int addPathNumbers(TreeNode node, int sum) {
    	if(node == null) {
    		return 0;
    	}else if(node.left == null && node.right == null){
    		return node.val + sum*10;
    	}else{
    		int l = addPathNumbers(node.left, sum*10 + node.val);
    		int r = addPathNumbers(node.right, sum*10 + node.val);
    		return l + r;
    	}
    }
}

public class SumRootToLeaf {
	public static void main(String args[]) {
		SumRootToLeafSolution obj = new SumRootToLeafSolution();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(0);
		TreeNode t3 = new TreeNode(0);
		TreeNode t4 = new TreeNode(0);
		TreeNode t5 = new TreeNode(1);
		TreeNode t6 = new TreeNode(2);
		TreeNode t7 = new TreeNode(3);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		System.out.println(obj.sumNumbers(t2));
	}
}