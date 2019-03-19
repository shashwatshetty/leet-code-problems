package easyproblems;

// Referred The Solution
// Time Taken To Solve: 100 mins
class StringCompressionSolution {
	/*
		Below approach is incorrect. unable to clear basic test cases.
	*/
		
    /*
    public int compress(char[] chars) {
        int i = 0, k = 0, j = 1;
        if(chars == null) {
        	return 0;
        }
        while(j <= chars.length) {
        	if(j == chars.length || chars[i] != chars[j]) {
        		if((j - i) > 1) {
        			chars[k] = chars[];
        			String count = "" + (j - i);
        			for(char c : count.toCharArray()) {
        				k++;
        				chars[k + 1] = c;
        			}
        			i = j;
        		}else {
        			i++;
        		}
    			k++;
        	}
        	j++;
        }
        return k;
    }
	*/

    /*
    	Below approach keeps track of the last character that it has seen and continues to count the
    	number of characters similar to the last character. If a different character is seen, it replaces
    	the character at the position pos with the last seen character and then appends the count in
    	front of it.
     */
    public int compress(char[] chars) {
        if(chars == null || chars.length == 0) {
            return 0;
        }
        int count = 0, pos = 0;
        char last = chars[0];
        for(int i = 0; i <= chars.length; i++) {
            if(i == chars.length || chars[i] != last) {
                chars[pos++] = last;
                if(count > 1) {
                    for(char c : String.valueOf(count).toCharArray()) {
                        chars[pos++] = c;
                    }
                }
                if(i < chars.length){
                    last = chars[i];
                }
                count = 0;
            }
            count++;
        }
        if(count > 1) {
            for(char c : String.valueOf(count).toCharArray()) {
                chars[pos++] = c;
            }
        }
        return pos;
    }
}

public class StringCompression {
	public static void main(String args[]) {
		StringCompressionSolution obj = new StringCompressionSolution();
		String ip = "aaaaaaaaaabcdeeeeeeeeeee";
		char[] chars = ip.toCharArray();
		int len = obj.compress(chars);
		for(int i = 0; i < len; i++) {
			System.out.print(chars[i] + " ");
		}
	}
}