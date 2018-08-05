package easyproblems;

// Took 2 attempts
// Time Taken To Solve: 24 mins
class SqrtSolution {
    public int mySqrt(int x) {
        int n = 0, prev = 0;
        double sq = n * n;
        while(sq <= x){
        	prev = n;
        	n++;
        	sq = (double)n * n;
        }
        return prev;
    }
}

public class Sqrt{
	public static void main(String args[]){
		SqrtSolution obj = new SqrtSolution();
		System.out.println(obj.mySqrt(2147395600));
	}
}