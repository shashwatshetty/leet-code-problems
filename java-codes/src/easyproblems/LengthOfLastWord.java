//package easyproblems;

// Took 2 attmepts
// Time Taken To Solve: 20 mins
class LengthOfLastWordSolution {
	// logic uses traverse the string
	/*public int lengthOfLastWord(String s){
    	if(s == null){
    		return 0;
    	}
    	s = s.trim();
        int len = s.length() - 1;
        int count = 0;
        while(len >= 0){
        	if(s.charAt(len) == ' '){
        		return count;
        	}
        	count++;
        	len--;
        }
        return count;
    }*/
    
    // logic uses String methods
    public int lengthOfLastWord(String s){
    	if(s == null){
    		return 0;
    	}
    	s = s.trim();
    	String[] words = s.split(" ");
    	int n = words.length - 1;
    	if(n < 0){
    		return 0;
    	}else{
    		return words[n].length();
    	}
    }
}

public class LengthOfLastWord{
	public static void main(String args[]){
		String n = "    hello    ";
		LengthOfLastWordSolution obj = new LengthOfLastWordSolution();
		System.out.println(obj.lengthOfLastWord(n));
	}
}