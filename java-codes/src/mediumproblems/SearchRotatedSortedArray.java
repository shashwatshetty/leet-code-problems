package mediumproblems;

// Took 2 attempts Before Referring Solution
// Took 2 attempt After Referring Solution
// Time Taken To Solve: 154 mins
class SearchRotatedSortedArraySolution {
	/*
		Below approach first finds the rotation index using a binary search
		algorithm. Aim is to find the index of the largest element so that
		the rotation index will be the next element after that. Always moving
		the left/right limits towards the largest element in the list. Once
		rotation index is known, performing a simple binary search will find
		if the target exists or not.
	*/
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
        	return -1;
        }
        if(nums.length == 1) {
        	return nums[0] == target ? 0 : -1;
        }
        int rotateIndex = 0;
        int mid;
        int l = 0, r = nums.length - 1;
        if(nums[l] > nums[r]) {
        	while(l <= r) {
        		mid = (l + r)/2;
        		if(nums[mid] > nums[mid + 1]) {
        			rotateIndex = mid + 1;
        			break;
        		}else {
        			if(nums[mid] < nums[l]) {
        				r = mid - 1;
        			}else {
        				l = mid + 1;
        			}
        		}
        	}
        }

        if(target >= nums[rotateIndex] && target <= nums[nums.length - 1]) {
        	l = rotateIndex;
        	r = nums.length - 1;
        } else if(target >= nums[0] && rotateIndex != 0 && target <= nums[rotateIndex - 1]) {
        	l = 0;
        	r = rotateIndex - 1;
        } else {
        	return -1;
        }

        while(l <= r) {
        	mid = (l + r)/2;
        	if(nums[mid] == target) {
        		return mid;
        	}else if(target < nums[mid]) {
        		r = mid - 1;
        	}else {
        		l = mid + 1;
        	}
        }
        return -1;
    }
}

public class SearchRotatedSortedArray {
	public static void main(String args[]) {
		SearchRotatedSortedArraySolution obj = new SearchRotatedSortedArraySolution();
		int[] arr = {3, 1};
		System.out.println(obj.search(arr, 3));
	}
}