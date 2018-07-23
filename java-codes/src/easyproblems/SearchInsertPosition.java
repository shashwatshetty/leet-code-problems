package easyproblems;

// Took 1 attempt
// Time Taken To Solve: 15 mins
class SearchInsertPositionSolution {
    public int searchInsert(int[] nums, int target) {
    	if(nums == null || nums.length == 0){
    		return 0;
    	}
        int low = 0, high = nums.length - 1, mid;
        while(low < high){
        	mid = (low + high)/2;
        	if(nums[mid] == target){
        		return mid;
        	}else if(nums[mid] < target){
        		low = mid + 1;
        	}else{
        		high = mid - 1;
        	}
        }
        if(nums[low] < target){
        	return low + 1;
        }else{
        	return low;
        }
    }
}

public class SearchInsertPosition{
	public static void main(String args[]){
		SearchInsertPositionSolution obj = new SearchInsertPositionSolution();
		int[] nums = {1, 4, 5, 8, 10, 13, 17};
		System.out.println(obj.searchInsert(nums, 71));
	}
}