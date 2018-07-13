package easyproblems;

import java.util.HashMap;
// Main method for running tests.
public class TwoSum {
    public static void main(String args[]){
        TwoSumSolution obj = new TwoSumSolution();
        int[] test1 = {2, 7, 11, 15};
        int[] answer = obj.twoSum(test1, 8);
        for(int ele : answer){
            System.out.println(ele);
        }
    }
}

class TwoSumSolution {
    /*
    Basic idea is, to store the compliment of the number and the target as a key in the
    Hash Map and see if that compliment exists in the array later. The value for the compliments
    will be the index of the other half of the summation in the array.
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> otherValue = new HashMap<Integer, Integer>();     // sstores the other half of the summation
        int i = 0;
        int[] result = new int[2];  // result array
        while(i < nums.length){
            // if the number exists in the map, means the compliment with the target also exists
            if(otherValue.containsKey(nums[i])){
                result[0] = otherValue.get(nums[i]);
                result[1] = i;
                return result;
            }else{
                int sub = target - nums[i];     // store the compliment as key
                otherValue.put(sub, i);         // with the index as its value
            }
            i++;
        }
        return null;
    }
}
