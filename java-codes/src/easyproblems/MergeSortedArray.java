package easyproblems;

// Took 1 attempt
// Time Taken To Solve: 37 mins
class MergeSortedArraySolution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	if(n == 0){
    		return;
    	}
        int len = m + n;
        int i = 0, j = 0, k = 0;
        while(k < len){
        	if(i >= m){
        		nums1[i] = nums2[j];
        		j++;
        	}else if(nums1[i] > nums2[j]){
        		int t = nums1[i];
        		nums1[i] = nums2[j];
        		nums2[j] = t;
        		int idx = j;
        		while(idx < (n - 1) && nums2[idx] > nums2[idx + 1]){
        			t = nums2[idx];
        			nums2[idx] = nums2[idx+1];
        			nums2[idx+1] = t;
        			idx++;
        		}
        	}
        	i++;
        	k++;
        }
    }
}

public class MergeSortedArray{
	public static void main(String args[]){
		MergeSortedArraySolution obj = new MergeSortedArraySolution();
		int[] n1 = {1,4,5};
		int[] n2 = {0,0,0};
		obj.merge(n1, 3, n2, 0);
		for(int e : n1){
			System.out.print(e+" ");
		}
	}
}