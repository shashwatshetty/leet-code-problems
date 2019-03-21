package easyproblems;

import java.util.HashMap;
import java.util.Arrays;

// Took 1 attempt
// Time Taken To Solve: 14 mins
class KDiffPairsArraySolution {
    public int findPairs(int[] nums, int k) {
    	if(nums == null || nums.length == 0) {
    		return 0;
    	}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();        
		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 1; i++) {
			if(map.get(nums[i]) != null) {
				continue;
			}
			for(int j = i + 1; j < nums.length; j++) {
				if(nums[j] - nums[i] == k) {
					map.put(nums[i], nums[j]);
				}
			}
		}
		return map.size();
    }
}

public class KDiffPairsArray {
	public static void main(String args[]) {
		KDiffPairsArraySolution obj = new KDiffPairsArraySolution();
		int[] arr = {1, 2, 3, 4, 5};
		System.out.println(obj.findPairs(arr, 5));
	}
}
