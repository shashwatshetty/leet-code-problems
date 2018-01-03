# Took 2 attempts!
class Solution(object):
    # brute force method
    '''
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        length = len(nums)
        if length == 0:
            return 0
        i = 1
        prev = nums[0]
        while i <= length - 1:
            if nums[i] == prev:
                for j in range(i, length):
                    nums[j - 1] = nums[j]
                length -= 1
            else:
                prev = nums[i]
                i += 1
        return length
    '''

    # simpler method
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        length = len(nums)
        if length == 0:
            return 0
        pos = 1
        i = 1
        while i < length:
            if nums[i] != nums[i - 1]:
                nums[pos] = nums[i]
                pos += 1
            i += 1
        return pos
