# Solution viewed for this problem.
class Solution(object):
    # Kadane's Algorithm implemented.
    # Runtime: O(n)
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 0
        maxSum = 0
        sum = 0
        all_neg = True
        for n in nums:
            sum += n
            if sum < 0:
                sum = 0
            else:
                all_neg = False
            if maxSum < sum:
                maxSum = sum
        if all_neg:                 # if all elements are negative
            return max(nums)        # return the max in the array
        return maxSum