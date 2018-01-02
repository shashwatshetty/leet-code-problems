#Took 1 attempt!
#Part of the contest on 23-Dec-2017
class Solution(object):
    def dominantIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        largest = max(nums)
        index = nums.index(largest)
        for num in nums:
            if not (2 * num <= largest) and num != largest:
                return -1
        return index