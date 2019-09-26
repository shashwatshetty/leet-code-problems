package mediumproblems;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

// Took 5 attempts Before Referring Solution
// Took 1 attempt After Referring Solution
// Time Taken To Solve: 50 mins

// Re-Done in 1 attempt After Referring Solution
// Time Taken: 70 mins
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

    /*
        Basic approach is to sort the array. Take the first element and get combinations of
        the next element and the highest element. If the three numbers add to 0, store them
        else check if sum is greater than 0 then reduce the highest element index by one else
        increase the lower element index by one. To avoid duplicates just increase/decrease
        the indexes if the next element is the same.
     */
    public List<List<Integer>> threeSumREDO(int[] nums) {
        List<List<Integer>> allSums = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return allSums;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1, high = nums.length - 1;
            if (i == 0 || nums[i] != nums[i - 1]) {
                while (low < high) {
                    int sum = nums[i] + nums[low] + nums[high];
                    if (sum == 0) {
                        List<Integer> triplets = new ArrayList<Integer>();
                        triplets.add(nums[i]);
                        triplets.add(nums[low]);
                        triplets.add(nums[high]);
                        allSums.add(triplets);
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        low++;
                        high--;
                    } else if (sum > 0) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
        return allSums;
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