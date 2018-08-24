package mediumproblems;

// Took 2 attempts
// Time Taken To Solve: 126 mins
class MultiplyStringsSolution {
	/*
		Below approach multiplies each digit and adds the result
		to a double variable, however the approach fails for larger
		inputs due to floating point approximations.
	*/
	/*
    public String multiply(String num1, String num2) {
        double mul = 0.0;
        double units = 1;
        for(int i = num1.length() - 1; i >= 0; i--){
        	double digit = units;
        	int j = num2.length() - 1;
        	int d1 = num1.charAt(i) - '0';
        	while(j >= 0){
        		int d2 = num2.charAt(j) - '0';
        		mul += (digit * d1 * d2);
        		digit *= 10;
        		j--;
        	}
        	units *= 10;
        }
        StringBuilder sb = new StringBuilder();
        int d;
        while(mul != 0){
        	d = (int)(mul % 10);
        	sb.insert(0, d);
        	mul = Math.floor(mul / 10);
        }
        return sb.toString();
    }
    */

    public String multiply(String num1, String num2) {
    	if(num1.charAt(0) == '0' || num2.charAt(0) == '0'){
    		return "0";
    	}
        int[][] m = new int[num1.length()][num2.length()];
        int d1, d2;
        for(int i = 0; i < num1.length(); i++){
        	for(int j = 0; j < num2.length(); j++){
        		d1 = num1.charAt(i) - '0';
        		d2 = num2.charAt(j) - '0';
        		m[i][j] = d1 * d2;
        	}
        }
        StringBuilder sb = new StringBuilder();
        int r, c, carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        while(i >= 0){
        	r = i;
        	c = j;
        	int sum = 0;
        	//System.out.println(i + " " + j);
        	while(c < num2.length() && r >= 0){
        		sum += m[r][c];
        		r--;
        		c++;
        	}
        	int d = (sum + carry) % 10;
        	carry = (sum + carry) / 10;
        	sb.insert(0,d+"");
        	if(j > 0){
        		j--;
        	}else{
        		i--;
        	}
        }
        if(carry != 0){
        	sb.insert(0, carry);
        }
        return sb.toString();
    }
}

public class MultiplyStrings{
	public static void main(String args[]){
		MultiplyStringsSolution obj = new MultiplyStringsSolution();
		System.out.println(obj.multiply("123456789", "987654321"));
	}
}