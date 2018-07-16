package easyproblems;
import java.util.Arrays;
import java.util.ArrayList;

// Took 1 attempt
// Time Taken To Solve: 47 mins
class IntersectionTwoArraysSolution {
    public int[] intersection(int[] nums1, int[] nums2) {
    	if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0){
    		return new int[0];
    	}
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int current, previous = Integer.MAX_VALUE;
        ArrayList<Integer> intersect = new ArrayList<Integer>();
        for(int i = 0; i < nums1.length; i++){
        	current = nums1[i];
        	int low = 0, high = nums2.length - 1, mid;
        	while(low <= high){
	        	if(previous != Integer.MAX_VALUE && previous == current){
	        		break;
	        	}
	        	mid = (low + high)/2;
	        	if(nums2[mid] == current){
	        		intersect.add(current);
	        		previous = current;
	        		break;
	        	}else if(current < nums2[mid]){
	        		high = mid - 1;
	        	}else{
	        		low = mid + 1;
	        	}
        	}
        }
        int[] inter = new int[intersect.size()];
        for(int i = 0; i < inter.length; i++){
        	inter[i] = intersect.get(i);
        }
        return inter;
    }
}

public class IntersectionTwoArrays{
	public static void main(String args[]){
		int[] n1 = {2,3,4,5,7,8,9};
		int [] n2 = {0,9,8,7,6,5,4,3,2,1};
		IntersectionTwoArraysSolution obj = new IntersectionTwoArraysSolution();
		int[] ans = obj.intersection(n1, n2);
		for(int e : ans){
			System.out.print(e + " ");
		}
	}
}