package easyproblems;

// Took 4 attempts Before Referring Solution
// Took 1 attempt After Referring Solution
// Time Taken To Solve: 68 mins
class ValidPalindromeSolution {
	/*
		Below approach uses two indexes, one starting from the head of the string 
		and the other at the end of the string. It increments/decrements the indexes
		whenever a non alphanumeric character is seen. Then it compares the characters
		if they don't match we return false, else true is returned. This approach fails
		cases when the string contains only special characters.
	*/
	/*
    public boolean isPalindrome(String s) {
    	s = s.toLowerCase();
        int low = 0, high = s.length() - 1;
        while(low < high){
        	while(!(s.charAt(low) >= 'a' && s.charAt(low) <= 'z') && 
        		!(s.charAt(low) >= '0' && s.charAt(low) <= '9')){
        		low++;
        	}
        	while(!(s.charAt(high) >= 'a' || s.charAt(high) <= 'z') &&
        	 !(s.charAt(high) >= '0' && s.charAt(high) <= '9')){
        		high--;
        	}
        	if(s.charAt(low) != s.charAt(high)){
        		return false;
        	}
        	low++;
        	high--;
        }
        return true;
    }
    */

    /*
        Below approach converts string to lower case and trims it. Then it builds a
        StringBuilder which appends all digits or letters into the StringBuilder from the
        original String. Then it traverses the StringBuilder to check if its a palindrome.
        The approach fails for cases where the string is of one length containing special
        characters.
    */
    /*
    public boolean isPalindrome(String s) {
    	s = s.toLowerCase();
    	s = s.trim();
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < s.length(); i++){
    		char c = s.charAt(i);
    		if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')){
    			sb.append(c);
    		}
    	}
    	if(sb.length() == 0 && !s.equals("")){
    		return false;
    	}
    	String plain = sb.toString();
    	for(int i = 0, j = plain.length() - 1; i < j; i++, j--){
    		if(plain.charAt(i) != plain.charAt(j)){
    			return false;
    		}
    	}
    	return true;
    }
    */

    /*
        Below approach converts all the characters in the String to lower case
        and takes two pointers one at the start index and one at the end.
    */
    public boolean isPalindrome(String s) {
        if(s.length() == 0){
            return true;
        }
        s = s.toLowerCase();
        int i = 0, j = s.length() -1;
        while(i < j){
            char start = s.charAt(i);
            char end = s.charAt(j);
            if(!Character.isLetterOrDigit(start)){
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(end)){
                j--;
                continue;
            }
            if(start != end){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}

public class ValidPalindrome{
	public static void main(String args[]){
		ValidPalindromeSolution obj = new ValidPalindromeSolution();
		String s = "A man, a plan, a canal: Panama";
		System.out.println(obj.isPalindrome("."));
        System.out.println(obj.isPalindrome(s));
        System.out.println(obj.isPalindrome("race a car"));
        System.out.println(obj.isPalindrome("Madam I'm Adam"));
	}
}