package mediumproblems;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

// Took 1 attempt
// Time Taken To Solve: 65 mins
class LetterComboPhoneSolution {
    public List<String> letterCombinations(String digits) {
    	if(digits == null || digits.length() == 0){
    		return new ArrayList<String>();
    	}
        HashMap<Character, String> numToAlpha = new HashMap<Character, String>();
        numToAlpha.put('1', "");
        numToAlpha.put('2', "abc");
        numToAlpha.put('3', "def");
        numToAlpha.put('4', "ghi");
        numToAlpha.put('5', "jkl");
        numToAlpha.put('6', "mno");
        numToAlpha.put('7', "pqrs");
        numToAlpha.put('8', "tuv");
        numToAlpha.put('9', "wxyz");
        List<String> alpha = new ArrayList<String>();
        alpha.add("");
        for(int i = 0; i < digits.length(); i++){
        	String s = numToAlpha.get(digits.charAt(i));
        	List<String> temp = new ArrayList<String>();
        	for(int j = 0; j < s.length(); j++){
        		String toAdd = s.substring(j, j+1);
        		for(String r : alpha){
        			temp.add(r.concat(toAdd));
        		}
        	}
        	if(!temp.isEmpty()){
        		alpha = temp;
        	}
        }
        return alpha;
    }
}

public class LetterComboPhone{
	public static void main(String args[]){
		LetterComboPhoneSolution obj = new LetterComboPhoneSolution();
		List<String> ans = obj.letterCombinations("74274928");
		for(String c : ans){
			System.out.println(c);
		}
	}
}