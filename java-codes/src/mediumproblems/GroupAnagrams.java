package mediumproblems;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// Took 2 attempts Before Referring Solution
// Took 1 attempts After Referring Solution
// Time Taken To Solve: 76 mins
class GroupAnagramsSolution {
	/*
		Below approach converts the input String array to a List and 
		runs a loop till the list in not empty. It checks for anagrams of 
		the String at the starting of the list. Two approaches of checking 
		anagrams are used, however the approach fails the time limit constraint.
	*/
    /*
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> sol = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0){
        	return sol;
        }
        List<String> ip = new ArrayList<String>(Arrays.asList(strs));
        while(!ip.isEmpty()){
        	String curr = ip.remove(0);
        	List<String> anagrams = new ArrayList<String>();
        	anagrams.add(curr);
        	for(int j = 0; j < ip.size(); j++){
        		if(areAnagrams(curr, ip.get(j))){
        			anagrams.add(ip.get(j));
        			ip.remove(j);
        			j--;
        		}
        	}
        	sol.add(anagrams);
        }
        return sol;
    }

    public boolean areAnagrams(String s1, String s2){
    	if(s1.length() != s2.length()){
    		return false;
    	}
    	HashMap<Character, Integer> chars1 = new HashMap<Character, Integer>();
    	HashMap<Character, Integer> chars2 = new HashMap<Character, Integer>();
    	for(int i = 0; i < s1.length(); i++){
    		Integer count1 = chars1.get(s1.charAt(i));
    		Integer count2 = chars2.get(s2.charAt(i));
    		if(count1 != null){
    			chars1.put(s1.charAt(i), count1+1);
    		}else{
    			chars1.put(s1.charAt(i), 1);
    		}
    		if(count2 != null){
    			chars2.put(s2.charAt(i), count2+1);
    		}else{
    			chars2.put(s2.charAt(i), 1);
    		}
    	}
    	for(int i = 0; i < s1.length(); i++){
    		char c = s1.charAt(i);
    		if(chars1.get(c) != chars2.get(c)){
    			return false;
    		}
    	}
    	return true;
    }

    public boolean areAnagrams(String s1, String s2){
    	char[] c1 = s1.toCharArray();
    	char[] c2 = s2.toCharArray();
    	Arrays.sort(c1);
    	Arrays.sort(c2);
    	s1 = new String(c1);
    	s2 = new String(c2);
    	return s1.equals(s2);
    }
    */

    /*
        Below approach sorts each String in the given array and uses the sorted
        String as the key in the HashMap. If any other String matches the key,
        the value is a List of Strings to which it gets added. At the end the List of
        values of the HashMap is returned.
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList<List<String>>();
        }
        HashMap<String, List<String>> anagrams = new HashMap<String, List<String>>();
        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            if(anagrams.get(key) != null){
                anagrams.get(key).add(s);
            }else{
                List<String> group = new ArrayList<String>();
                group.add(s);
                anagrams.put(key, group);
            }
        }
         List<List<String>> sol = new ArrayList<List<String>>(anagrams.values());
         return sol;
    }
}

public class GroupAnagrams{
	public static void main(String args[]){
		GroupAnagramsSolution obj = new GroupAnagramsSolution();
		String[] s = {"hey", "you", "are", "too", "ear", "yeh", "oot"};
		List<List<String>> ans = obj.groupAnagrams(s);
		for(List<String> l : ans){
			for(String m : l){
				System.out.print(m+" ");
			}
			System.out.println();
		}
	}
}