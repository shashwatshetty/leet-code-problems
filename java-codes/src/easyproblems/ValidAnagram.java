package easyproblems;

import java.util.HashMap;

// Took 2 attempts
// Time Taken To Solve: 27 mins
class ValidAnagramSolution {
	public boolean isAnagram(String s, String t) {
    	if(s == null || t == null || s.length() != t.length()){
    		return false;
    	}
        HashMap<Character, Integer> sChars = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tChars = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
        	char sc = s.charAt(i);
        	char tc = t.charAt(i);
        	if(sChars.get(sc) != null){
        		int i1 = sChars.get(sc);
        		sChars.put(sc, i1 + 1);
        	}else{
        		sChars.put(sc, 1);
        	}
        	if(tChars.get(tc) != null){
        		int i2 = tChars.get(tc);
        		tChars.put(tc, i2 + 1);
        	}else{
        		tChars.put(tc, 1);
        	}
        }
        for(char c : s.toCharArray()){
        	if(!sChars.get(c).equals(tChars.get(c))){
        		return false;
        	}
        }
        return true;
    }

}

public class ValidAnagram{
	public static void main(String args[]){
		ValidAnagramSolution obj = new ValidAnagramSolution();
		String s1 = "iamlordvoldemort";
		String s2 = "tommarvoloriddle";
		System.out.println(obj.isAnagram(s1, s2));
	}
}


