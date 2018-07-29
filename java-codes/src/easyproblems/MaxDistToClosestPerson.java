package easyproblems;

// Took 2 attempts
// Time Taken To Solve: 60 mins
class MaxDistToClosestSolution {
    public int maxDistToClosest(int[] seats) {
        int maxDist = 0;
        int index = 0;
        int left = -1, right = 0, dist = 0;
        for(int i = 0; i < seats.length; i++){
        	if(seats[i] == 1 && left < 0){
        		left = i;
        		maxDist = i - right;
        	}else if(seats[i] == 1 && left >= 0){
        		right = i;
        		int idx = (left + right)/2;
        		int leftDist = idx - left;
        		int rightDist = right - idx;
        		dist = leftDist < rightDist ? leftDist : rightDist;
        		left = right;
        	}else if(i == seats.length - 1){
        		dist = i - left;
        	}
        	if(dist > maxDist){
    			maxDist = dist;
        	}
        }
    	return maxDist;
    }
}

public class MaxDistToClosestPerson{
	public static void main(String args[]){
		MaxDistToClosestSolution obj = new MaxDistToClosestSolution();
		int[] s = {1,0,0,0,1};
		System.out.println(obj.maxDistToClosest(s));
	}
}