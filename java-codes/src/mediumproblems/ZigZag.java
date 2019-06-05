package mediumproblems;

// Took 1 attempt
// Time Taken To Solve: 96 mins
class ZigZagSolution {
	/*
		Incorrect approach.
	*/
	/*
    public String convert(String s, int numRows) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < numRows; i++) {
        	int idx = i;
        	while(idx < s.length()) {
        		res.append(s.charAt(idx));
        		idx = idx + (2 * (numRows - i - 1));
        		System.out.println(idx);
        	}
        	break;
        }
        return res.toString();
    }
    */

    public String convert(String s, int numRows) {
    	if(numRows <= 1 || s == null || s.length() == 0) {
    		return s;
    	}
        char[][] pattern = new char[numRows][(s.length()/(numRows - 1)) + 1];
        int row = 0, col = 0, incr = 1;
        for(char ch : s.toCharArray()) {
        	pattern[row][col] = ch;
        	row += incr;
        	if(row >= numRows) {
        		incr *= -1;
        		row += (incr - 1);
        		col++;        		
        	} else if(row < 0) {
        		incr *= -1;
        		row += (incr + 1);
        		col++;
        	}
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < pattern.length; i++) {
        	for(int j = 0; j < pattern[0].length; j++) {
        		if((int)pattern[i][j] != 0) {
        			res.append(pattern[i][j]);
        		}
        	}
        }
        return res.toString();
    }
}

public class ZigZag {
	public static void main(String args[]) {
		ZigZagSolution obj = new ZigZagSolution();
		System.out.println(obj.convert("SHASHWATSHETTY", 1));
		System.out.println(obj.convert("SHASHWATSHETTY", 2));
		System.out.println(obj.convert("SHASHWATSHETTY", 3));
		System.out.println(obj.convert("SHASHWATSHETTY", 4));
		System.out.println(obj.convert("SHASHWATSHETTY", 5));
		System.out.println(obj.convert("SHASHWATSHETTY", 6));
	}
}