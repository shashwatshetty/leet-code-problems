package easyproblems;

// Took 1 attempt
// Time Taken To Solve: 13 mins
class HammingDistanceSolution {
    public int hammingDistance(int x, int y) {
        int dist = 0, xBit, yBit;
        while(x != 0 || y != 0){
        	xBit = x % 2;
        	yBit = y % 2;
        	if( xBit != yBit){
        		dist += 1;
        	}
        	x = x / 2;
        	y = y / 2;
        }
        return dist;
    }
}

public class HammingDistance{
	public static void main(String args[]){
		HammingDistanceSolution obj = new HammingDistanceSolution();
		System.out.println(obj.hammingDistance(128, 128));
	}
}