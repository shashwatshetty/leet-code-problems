// Took 4 attempts Before Referring Solution
// Took 2 attempts After Referring Solution
// Time Taken To Solve: 117 mins
class JumpGameSolution {
	/* 
		Below approach is incorrect. Did not clearly understand the problem.
	*/

	/*
	public boolean canJump(int[] nums) {
    	if(nums == null || nums.length == 0){
    		return false;
    	}
        int index = 1;
        int jump, newIndex;
        int len = nums.length;
        if(len <= 2){
        	return true;
        }
        while(index < len){
        	jump = nums[index];
        	newIndex = jump + index;
        	if(newIndex != index && newIndex == len - 1){
        		return true;
        	}else if(newIndex == index){
        		return false;
        	}
        	index = newIndex;
        }
        return false;
    }
    */

	/*
		Below approach starts traversing at index 0 and keeps a count of what is the
		maximum index that can be reached for the current and any of the next elements
		that can be reached from the current index. It uses a greedy approach and only
		considers the index that will give the max jump, and accordingly decides the 
		next index to jump to.
	*/
	public boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        if(goal < 1){
        	return true;
        }
        int current = 0;
        int maxJump;
        int next = 0;
        while(current < goal){
        	int jumpsPossible = nums[current];
        	maxJump = current + jumpsPossible;
        	if(maxJump >= goal){
        		return true;
        	}
        	for(int i = 1; i <= jumpsPossible; i++){
        		int nextIndex = i + current;
        		if(nextIndex + nums[nextIndex] >= maxJump){
        			maxJump = nextIndex + nums[nextIndex];
        			next = i;
        		}
        	}
        	if(next == 0){
        		return false;
        	}
        	current = current + next;
        	next = 0;
        }
        return current >= goal;
    }
}

public class JumpGame{
	public static void main(String args[]){
		JumpGameSolution obj = new JumpGameSolution();
		int[] test = {1,2,2,0,3,3,1,0,1};
		System.out.println(obj.canJump(test));
	}
}