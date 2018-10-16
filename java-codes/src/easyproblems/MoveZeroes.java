package easyproblems;

// Took 1 attempt
// Time Taken To Solve: 34 mins
class MoveZeroesSolution {
    public void moveZeroes(int[] nums) {
    	if(nums == null || nums.length == 0) {
    		return;
    	}
        int i = 0, j = 0;
        while(i < nums.length) {
        	if(nums[i] != 0) {
        		int t = nums[i];
        		nums[i] = 0;
        		nums[j] = t;
        		j++;
        	}
        	i++;
        }
    }
}

public class MoveZeroes{
	public static void main(String args[]) {
		MoveZeroesSolution obj = new MoveZeroesSolution();
		int[] n = {1,0,0,0,0,0,0,0,9,0,0,0,13};
		obj.moveZeroes(n);
		for(int i : n) {
			System.out.print(i + " ");
		}
	}
}