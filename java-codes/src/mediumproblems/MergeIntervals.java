package mediumproblems;

import java.util.List;
import java.util.ArrayList;

// Took 4 attempts
// Time Taken To Solve: 60 mins
class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}

class MergeIntervalsSolution {
    public List<Interval> merge(List<Interval> intervals) {
    	if(intervals == null || intervals.size() == 0){
    		return intervals;
    	}
        int n = intervals.size();
        int i = 0;
        while(i < n){
        	for(int j = 0; j < n; j++){
        		Interval i1 = intervals.get(i);
        		Interval i2 = intervals.get(j);
        		if(!i1.equals(i2) && i1.start <= i2.start && i1.end >= i2.start){
        			int st = i1.start <= i2.start ? i1.start : i2.start;
        			int en = i1.end >= i2.end ? i1.end : i2.end;
        			Interval merged = new Interval(st, en);
        			intervals.add(i, merged);
        			intervals.remove(i1);
        			intervals.remove(i2);
        			n--;
        			i = intervals.indexOf(merged) - 1;
        			break;
        		}
        	}
        	i++;
        }
       	return intervals;
    }
}

public class MergeIntervals{
	public static void main(String args[]){
		MergeIntervalsSolution obj = new MergeIntervalsSolution();
		Interval i1 = new Interval(2, 3);
		Interval i2 = new Interval(4, 5);
		Interval i3 = new Interval(6, 7);
		Interval i4 = new Interval(1, 50);
		Interval i5 = new Interval(1, 4);
		List<Interval> test1 = new ArrayList<Interval>();
		List<Interval> test2 = new ArrayList<Interval>();
		test1.add(i1);
		test1.add(i2);
		test1.add(i3);
		test1.add(i4);
		test2.add(i5);
		test2.add(i1);
		List<Interval> ans = obj.merge(test1);
		for(Interval i : ans){
			System.out.println("Start: "+i.start+" End: "+i.end);
		}
	}
}