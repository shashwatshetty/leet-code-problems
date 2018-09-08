package mediumproblems;

import java.util.List;
import java.util.ArrayList;

// Took 1 attempt Before Referring Solution
// Took 1 attempt After Referring Solution
// Time Taken To Solve: 140 mins
class PermutationSequenceSolution {
	/*
		Below approach is a brute force method that lists out all the permutations 
		which are stored in a List. Then accordingly, we list the kth permutation from
		the list. It uses a recursive backtracking algorithm to calculate the different
		permutation sequences.
	*/
	/*
    public String getPermutation(int n, int k) {
        StringBuilder seq = new StringBuilder();
        List<String> all = new ArrayList<String>();
        getAllSequences(all, seq, n, 0);
        if(k > all.size()){
        	return "";
        }
        return all.get(k - 1);
    }

    public void getAllSequences(List<String> all, StringBuilder seq, int n, int len){
    	if(len == n){
    		String s = seq.toString();
    		all.add(s);
    	}else{
    		for(int i = 1; i <= n; i++){
    			boolean hasChar = false;
    			for(int j = 0; j < seq.length(); j++){
    				if(seq.charAt(j) == (char)(i + '0')){
    					hasChar = true;
    					break;
    				}
    			}
    			if(!hasChar){
    				seq.append(i);
    				getAllSequences(all, seq, n, len + 1);
    				seq.deleteCharAt(seq.length() - 1);
    			}
    		}
    	}
    }
    */

	/*
		Below approach uses Mathematics to solve the permutation problem.
		First we store the numbers from 1 to n in a list. The number to be chosen
		to start the permutation sequence is of the form K/(n - I)!,
		where, K = k - 1 and I = numbers already in the sequence.
		This gives the index of the number in the list. We append it, remove it
		from the list and update k as, k = k - (index * (n - I)!),
		where index is the previous number index in the list.
	*/
    public String getPermutation(int n, int k) {
    	List<Integer> nums = new ArrayList<Integer>();
    	for(int i = 1; i <= n; i++){
    		nums.add(i);
    	}
    	StringBuilder seq = new StringBuilder();
    	int count = 1, fac, idx;
    	k--;
    	while(count <= n){
    		fac = factorial(n - count);
    		idx = k/fac;
    		if(idx >= nums.size()){
    			return "";
    		}
    		seq.append(String.valueOf(nums.get(idx)));
    		nums.remove(idx);
    		k -= (idx * fac);
    		count++;
    	}
    	return seq.toString();
    }

    public int factorial(int a){
    	int f = 1;
    	while(a > 1){
    		f *= a;
    		a--;
    	}
    	return f;
    }
}

public class PermutationSequence{
	public static void main(String args[]){
		PermutationSequenceSolution obj = new PermutationSequenceSolution();
		System.out.println(obj.getPermutation(4, 14));
	}
}