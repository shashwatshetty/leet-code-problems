package mediumproblems;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

// Took 5 attempts Before Referring Solution
// Took 1 attempt After Referring Solution
// Time Taken To Solve: 50 mins
class ThreeSumSolution {
    /*
        Below approach, sorts the array, and traverses each element,
        to find 2 numbers whose sum is the negative of the element.
        
    */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<List<Integer>>();
        for(int i = 0; i < nums.length - 1; i++){
            int low = i + 1, high = nums.length - 1;
            int sum = -nums[i];
            while(low < high){
                int twoSum = nums[low] + nums[high];
                if(twoSum == sum){
                    List<Integer> triplet = new ArrayList<Integer>();
                    triplet.add(nums[i]);
                    triplet.add(nums[low]);
                    triplet.add(nums[high]);
                    res.add(triplet);
                    low++;
                    high--;
                }else if(twoSum < sum){
                    low++;
                }else{
                    high--;
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<List<Integer>>(res);
        return ans;
    }
}
public class ThreeSum{
    public static void main(String args[]){
        int[] n = {-1, 0, 1, 2, -1, -4};
        ThreeSumSolution obj = new ThreeSumSolution();
        List<List<Integer>> ans = obj.threeSum(n);
        for(List<Integer> l : ans){
            for(int e : l){
                System.out.print(e+" ");
            }
            System.out.println();
        }
    }
}