package mediumproblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

// Took 2 attempts
// Time Taken To Solve: 114 mins
class TriangleSolution {
    /*
        Below approach uses a Greedy algorithm as it goes for the
        minimum value while considering a path and goes ahead with
        that, however, it fails when the value changes ahead.
    */
    /*
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }
        int start = 0, end = 0, sum = 0;
        for(List<Integer> l : triangle){
        	int a1 = l.get(start);
        	int a2 = l.get(end);
        	if(a1 > a2){
        		sum += a2;
        		start = end;
        	}else{
        		sum += a1;
        	}
        	end = start + 1;
        }
        return sum;
    }
    */

    /*
        Below approach uses a top down Dynamic Programming method with
        memoization. We set the values for each row and position in a
        2D array and add that with the minimum value for the next row
        and position.
    */
    public int minimumTotal(List<List<Integer>> triangle) {
         if(triangle == null || triangle.size() == 0){
            return 0;
        }
        Integer[][] memo = new Integer[triangle.size()][triangle.size()];
        return getMinPath(0, 0, memo, triangle);
    }

    public int getMinPath(int row, int pos, Integer[][] memo, List<List<Integer>> triangle){
        if(row + 1 > triangle.size() - 1){
            memo[row][pos] = triangle.get(row).get(pos);
            return memo[row][pos];
        }else if(memo[row][pos] != null){
            return memo[row][pos];
        }else{
            int adj1 = getMinPath(row + 1, pos, memo, triangle);
            int adj2 = getMinPath(row + 1, pos + 1, memo, triangle);
            memo[row][pos] = Math.min(adj1, adj2) + triangle.get(row).get(pos);
            return memo[row][pos];
        }
    }
}

public class Triangle{
	public static void main(String args[]){
		TriangleSolution obj = new TriangleSolution();
		List<Integer> r1 = new ArrayList<Integer>();
        List<Integer> r2 = new ArrayList<Integer>();
        List<Integer> r3 = new ArrayList<Integer>();
        List<Integer> r4 = new ArrayList<Integer>();
        List<Integer> r5 = new ArrayList<Integer>();
        List<List<Integer>> t = new ArrayList<List<Integer>>();
        r1.add(1);
        r2.add(2);
        r2.add(3);
        r3.add(4);
        r3.add(5);
        r3.add(6);
        r4.add(7);
        r4.add(8);
        r4.add(9);
        r4.add(10);
        r5.add(11);
        r5.add(12);
        r5.add(13);
        r5.add(14);
        r5.add(15);
        t.add(r1);
        t.add(r2);
        t.add(r3);
        t.add(r4);
        t.add(r5);
        System.out.println(obj.minimumTotal(t));
	}
}