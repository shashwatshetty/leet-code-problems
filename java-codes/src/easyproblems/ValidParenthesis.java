package easyproblems;

import java.util.Stack;
import java.util.HashMap;

// Re-Done in 1 attempt
// Time Taken: 20 mins
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

	public boolean isValidREDO(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		HashMap<Character, Character> brackets = new HashMap<>();
		brackets.put(')', '(');
		brackets.put('}', '{');
		brackets.put(']', '[');
		Stack<Character> parenthStack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char p = s.charAt(i);
			if (brackets.get(p) == null) {
				parenthStack.push(p);
			} else {
				if (parenthStack.isEmpty() || parenthStack.pop() != brackets.get(p)) {
					return false;
				}
			}
		}
		if (!parenthStack.isEmpty()) {
			return false;
		}
		return true;
	}

}

public class ValidParenthesis{
	public static void main(String args[]){
		ValidParenthesisSolution obj = new ValidParenthesisSolution();
		String s = "{[]}";
		System.out.println(obj.isValid(s));
	}
}