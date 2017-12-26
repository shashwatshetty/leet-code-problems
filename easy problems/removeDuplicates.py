class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        length = len(nums)
        prev = nums[0]
        duplicates = 0
        for i in range(1, len(nums) - 1):
        	if nums[i] == prev:
        		nums[i] = nums[i + 1]
        		duplicates += 1
        	prev = nums[i]
        return (length - duplicates)