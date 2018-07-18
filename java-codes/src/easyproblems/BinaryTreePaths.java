package easyproblems;

import java.util.List;
import java.util.ArrayList;

// Took 1 attempt
// Time Taken To Solve: 31 mins

class BinaryTreePathsSolution {
    public List<String> binaryTreePaths(TreeNode root) {
    	List<String> allPaths = new ArrayList<String>();
        if(root == null){
        	return allPaths;
        }
        String p = root.val + "";
        getPaths(root, p, allPaths);
        return allPaths;
    }

    public void getPaths(TreeNode node, String path, List<String> paths){
    	if(node.left == null && node.right == null){
    		paths.add(path);
    	}else if(node.left == null){
    		path += "->" + node.right.val;
    		getPaths(node.right, path, paths);
    	}else if(node.right == null){
    		path += "->" + node.left.val;
    		getPaths(node.left, path, paths);
    	}else{
    		String leftPath = path + "->" + node.left.val;
    		String rightPath = path + "->" + node.right.val;
    		getPaths(node.left, leftPath, paths);
    		getPaths(node.right, rightPath, paths);
    	}
    }
}

public class BinaryTreePaths{
	public static void main(String args[]){
		BinaryTreePathsSolution obj = new BinaryTreePathsSolution();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(5);
		n1.left = n2;
		n1.right = n3;
		n2.right = n4;
		List<String> ans = obj.binaryTreePaths(n1);
		for(String pth : ans){
			System.out.println(pth);
		}
	}
}