package mediumproblems;

// Referred The Solution
// Time Taken To Solve: 100 mins
class RemoveDuplicatesArrayIISolution {
    public int removeDuplicates(int[] nums) {
    	if(nums == null){
    		return 0;
    	}
    	return removeKDuplicates(nums, 2, nums.length);
    }

    public int removeKDuplicates(int[] nums, int k, int len) {
    	if(len <= k){
    		return len;
    	}
    	int count = 1, i = 1, j =1;
    	while(i < len){
    		if(nums[i] != nums[i - 1]){
    			count = 1;
    			nums[j] = nums[i];
    			j++;
    		}else{
    			if(count < k){
    				count++;
    				nums[j] = nums[i];
    				j++;
    			}
    		}
    		i++;
    	}
    	return j;
    }
}

public class RemoveDuplicatesArrayII{
	public static void main(String args[]){
		RemoveDuplicatesArrayIISolution obj = new RemoveDuplicatesArrayIISolution();
		int[] n = {1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,3,3,3,3,3,3,3,3,3};
		int l = obj.removeDuplicates(n);
		System.out.println(l);
		for(int i = 0; i < l; i++){
			System.out.print(n[i]);
		}
	}
}