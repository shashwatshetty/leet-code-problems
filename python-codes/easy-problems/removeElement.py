#Took 1 Attempt!!
class Solution(object):
    #Time Complexity: O(n)
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        index = 0
        i = 0
        while i < len(nums):
            if nums[i] != val:
                nums[index] = nums[i]
                index += 1
            i += 1
        return index
