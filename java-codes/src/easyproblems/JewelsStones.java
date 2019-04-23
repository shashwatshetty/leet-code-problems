package easyproblems;

import java.util.HashSet;

// Took 1 attempt
// Time Taken To Solve: 13 mins
class JewelsStonesSolution {
    public int numJewelsInStones(String J, String S) {
    	if(S == null || S.length() == 0 || J == null || J.length() == 0) {
    		return 0;
    	}
        HashSet<Character> jewels = new HashSet<Character>();
        for(char c : J.toCharArray()) {
        	jewels.add(c);
        }
        int count = 0;
        for(char c : S.toCharArray()) {
        	if(jewels.contains(c)) {
        		count++;
        	}
        }
        return count;
    }
}

public class JewelsStones {
	public static void main(String args[]) {
		JewelsStonesSolution obj = new JewelsStonesSolution();
		System.out.println(obj.numJewelsInStones("", ""));
	}
}