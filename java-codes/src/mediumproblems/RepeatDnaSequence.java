package mediumproblems;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

// Took 1 attempt
// Time Taken To Solve: 24 mins
class RepeatDnaSequenceSolution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> seq = new ArrayList<String>();
        if(s == null || s.length() < 10){
        	return seq;
        }
    	HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i <= s.length() - 10; i++){
        	String sub = s.substring(i, i + 10);
        	Integer c = map.get(sub);
        	if(c != null){
        		map.put(sub, c + 1);
        	}else{
        		map.put(sub, 1);
        	}
        }
        for(String k : map.keySet()){
        	if(map.get(k) > 1){
        		seq.add(k);
        	}
        }
        return seq;
    }
}

public class RepeatDnaSequence{
	public static void main(String args[]){
		RepeatDnaSequenceSolution obj = new RepeatDnaSequenceSolution();
		List<String> ans = obj.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
		for(String s : ans){
			System.out.print(s+" ");
		}

	}
}