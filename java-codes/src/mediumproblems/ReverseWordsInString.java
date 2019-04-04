package mediumproblems;

// Took 2 attempts
// Time Taken To Solve: 32 mins
class ReverseWordsInStringSolution {
    public String reverseWords(String s) {
    	if(s == null || s.length() == 0) {
    		return "";
    	}
    	s = s.trim();
    	String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--) {
        	if(words[i].length() != 0) {
        		sb.append(words[i]);
        		if(i != 0) {
        			sb.append(" ");
        		}
        	}
        }
        return sb.toString();
    }
}

public class ReverseWordsInString {
	public static void main(String args[]) {
		ReverseWordsInStringSolution obj = new ReverseWordsInStringSolution();
		String rev = obj.reverseWords("   hello world   ");
		System.out.println(rev);
		System.out.println(rev.length());
	}
}