package mediumproblems;

// Took 1 attempt
// Time Taken To Solve: 18 mins
class HIndexSolution {
    public int hIndex(int[] citations) {
    	if(citations == null || citations.length == 0){
    		return 0;
    	}
	    int maxH = 0, hIdx = 0;
	    for(int h = citations.length - 1; h >= 0; h--){
			int count = 0;
			hIdx = h + 1;
	    	for(int i = 0; i < citations.length; i++){
	    		if(citations[i] >= hIdx){
	    			count++;
	    		}
	    	}
	    	if(count >= hIdx && hIdx > maxH){
	    		maxH = hIdx;
	    	}
	    }
	    return maxH;
    }
}

public class HIndex{
	public static void main(String args[]){
		int[] n = {10, 8, 5, 4, 3};
		HIndexSolution obj = new HIndexSolution();
		System.out.println(obj.hIndex(n));
	}
}