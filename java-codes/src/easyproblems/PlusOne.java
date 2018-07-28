package easyproblems;

// Took 1 attempt
// Time Taken To Solve: 21 mins
class PlusOneSolution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        for(int i = digits.length - 1; i >= 0; i--){
        	carry = (digits[i] + 1)/10;
        	digits[i] = (digits[i] + 1)%10;
        	if(carry == 0){
        		break;
        	}
        }
        if(carry == 1){
        	int[] newDigits = new int[digits.length + 1];
        	newDigits[0] = carry;
        	for(int i = 0; i < digits.length; i++){
        		newDigits[i + 1] = digits[i];
        	}
        	return newDigits;
        }
        return digits;
    }
}

public class PlusOne{
	public static void main(String args[]){
		PlusOneSolution obj = new PlusOneSolution();
		int[] n = {9, 9, 9};
		int[] ans = obj.plusOne(n);
		for(int e : ans){
			System.out.print(e+" ");
		}
	}
}