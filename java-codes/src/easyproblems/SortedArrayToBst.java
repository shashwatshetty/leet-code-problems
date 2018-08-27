package easyproblems;

// Took 2 attempts
// Time Taken To Solve: 60 mins
class SortedArrayToBstSolution {
	/*
		Below approach fails since it only builds the tree
		considering the middle element of the sorted array
		as the root, but it doesn't build a Height Balanced Tree
		at every level.
	*/
	/*
    public TreeNode sortedArrayToBST(int[] nums) {
    	if(nums == null || nums.length == 0){
    		return null;
    	}
    	int mid = nums.length/2;
    	TreeNode root = new TreeNode(nums[mid]);
    	for(int i = 0; i < nums.length; i++){
    		if(i != mid){
    			TreeNode x = root;
    			insert(x, nums[i]);
    		}
    	}
    	return root;        
    }

    public void insert(TreeNode r, int e){
    	TreeNode l = new TreeNode(e);
    	TreeNode prev = null;
    	while(r != null){
    		prev = r;
    		if(r.val > e){
    			r = r.left;
    		}else{
    			r = r.right;
    		}
    	}
    	if(prev.val > e){
    		prev.left = l;
    	}else{
    		prev.right = l;
    	}
    }
    */

    public TreeNode sortedArrayToBST(int[] nums) {
    	if(nums == null || nums.length == 0){
    		return null;
    	}
    	return makeHeightBalancedTree(0, nums.length, nums);
    }

    public TreeNode makeHeightBalancedTree(int start, int end, int[] nums){
    	if(start > end || start > nums.length - 1){
            return null;
        }else if(start == end){
    		return new TreeNode(nums[start]);
    	}else{
    		int mid = (start + end)/2;
    		TreeNode n = new TreeNode(nums[mid]);
    		n.left = makeHeightBalancedTree(start, mid - 1, nums);
    		n.right = makeHeightBalancedTree(mid + 1, end, nums);
    		return n;
    	}
    }
}

public class SortedArrayToBst{
	public static void main(String args[]){
		SortedArrayToBstSolution obj = new SortedArrayToBstSolution();
		int[] n = {0,1,2,3,4,5};
		TreeNode ans = obj.sortedArrayToBST(n);
		System.out.println("Root Is: "+ans.val);
        System.out.println("Left Is: "+ans.left.val);
        System.out.println("Right Is: "+ans.right.val);
		printTree(ans);
	}

	public static void printTree(TreeNode n){
		if(n == null){
			return;
		}else{
            System.out.print(n.val);
			printTree(n.left);
			printTree(n.right);
		}
	}
}