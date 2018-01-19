import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {
    public static void main(String args[]){
        LSWRSolution obj = new LSWRSolution();
        int res = obj.lengthOfLongestSubstring("abcabcbb");
        System.out.println("The result for abcabcbb is : "+res);
        res = obj.lengthOfLongestSubstring("bbbbb");
        System.out.println("The result for bbbbb is : "+res);
        res = obj.lengthOfLongestSubstring("tmmzuxt");
        System.out.println("The result for tmmzuxt is : "+res);
    }
}

class LSWRSolution {
    /*
    Basic idea is, we store the new characters in a Hash Map, and if it is seen earlier
    we check if the earlier occurrence is included in the substring being considered by the start index
    if yes, then move by one position further, if no, ignore.
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> index = new HashMap<Character, Integer>(); // stores the indexes of new characters
        int start = 0;      // stores the starting index of the longest substring
        int longest = 0;    // stores the length of the longest substring
        for(int i = 0; i < s.length(); i++){
            // first condition checks if the character has occurred before
            // second condition checks if the substring includes the previous occurrence of the character
            if(index.containsKey(s.charAt(i)) && start <= index.get(s.charAt(i))){
                start = index.get(s.charAt(i)) + 1;             // when both conditions are true, exclude the character
            }else{
                longest = Math.max(longest, i - start + 1);     // compare the longest with the updated length of the substring
            }
            index.put(s.charAt(i), i);      // update the hash map
        }
        return longest;
    }
}