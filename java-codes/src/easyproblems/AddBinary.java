package easyproblems;

// Took 1 attempt
// Time Taken To Solve: 31 mins
class AddBinarySolution {
    public String addBinary(String a, String b) {
        StringBuilder add = new StringBuilder();
        int carry = 0, newBit = 0, b1, b2;
        char[] n1 = a.toCharArray();
        char[] n2 = b.toCharArray();
        int l1 = n1.length - 1;
        int l2 = n2.length - 1;
        while(l1 >= 0 || l2 >= 0){
        	if(l1 < 0){
        		b2 = ((n2[l2] - '0') + carry);
        		newBit = b2 % 2;
        		carry = b2 / 2;
        		l2--;
        	}else if(l2 < 0){
        		b1 = ((n1[l1] - '0') + carry);
        		newBit = b1 % 2;
        		carry = b1 / 2;
        		l1--;
        	}else{
        		b1 = n1[l1] - '0';
        		b2 = n2[l2] - '0';
        		newBit = (b1 + b2 + carry) % 2;
        		carry = (b1 + b2 + carry) / 2;
        		l1--;
        		l2--;
        	}
        	add.insert(0, newBit);
        }
        if(carry == 1){
        	add.insert(0, carry);
        }
        return add.toString();
    }
}

public class AddBinary{
	public static void main(String args[]){
		AddBinarySolution obj = new AddBinarySolution();
		System.out.println(obj.addBinary("101", "10"));
	}
}