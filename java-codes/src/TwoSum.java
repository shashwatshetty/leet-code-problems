import java.util.HashMap;
// Main method for running tests.
public class TwoSum {
    public static void main(String args[]){
        Solution obj = new Solution();
        int[] test1 = {2, 7, 11, 15};
        int[] answer = obj.twoSum(test1, 8);
        for(int ele : answer){
            System.out.println(ele);
        }
    }
}

class Solution {
    /*
    Time Complexity:  O(n)
    Space Complexity: O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> otherValue = new HashMap<Integer, Integer>();
        int i = 0;
        int[] result = new int[2];
        while(i < nums.length){
            if(otherValue.containsKey(nums[i])){
                result[0] = otherValue.get(nums[i]);
                result[1] = i;
                return result;
            }else{
                int sub = target - nums[i];
                otherValue.put(sub, i);
            }
            i++;
        }
        return null;
    }
}
