#Took 2 attempts. Certain test cases to be handled.
class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums.sort()
        pos = 1
        i = 0
        while i < len(nums) - 1:
            if nums[i] > 0:
                if nums[i] != pos:
                    return pos
                if nums[i] != nums[i + 1]:
                    pos += 1
            i += 1
        if i == len(nums) - 1:
            return pos + 1
        return pos