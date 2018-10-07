package easyproblems;

import java.util.Stack;
import java.util.HashMap;

// Re-attempted Question
class ValidParenthesisSolution {
    public boolean isValid(String s) {
    	if(s == null || s.length() == 0){
    		return true;
    	}
        HashMap<Character, Character> braces = new HashMap<Character, Character>();
        braces.put('(', ')');
        braces.put('[', ']');
        braces.put('{', '}');

        Stack<Character> parenthStack = new Stack<Character>();

        for(int i =0; i < s.length(); i++){
        	char c = s.charAt(i);
        	if(braces.get(c) != null){
        		parenthStack.push(braces.get(c));
        	}else{
        		if(parenthStack.empty()){
        			return false;
        		}else{
        			char popped = parenthStack.pop();
        			if(popped != c){
        				return false;
        			}
        		}
        	}
        }
        if(parenthStack.empty()) {
			return true;
		}
		return false;
    }
}

public class ValidParenthesis{
	public static void main(String args[]){
		ValidParenthesisSolution obj = new ValidParenthesisSolution();
		String s = "{[]}";
		System.out.println(obj.isValid(s));
	}
}