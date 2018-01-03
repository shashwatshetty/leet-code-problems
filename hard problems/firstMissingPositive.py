#Took 3 attempts!!
class Solution(object):
    # method not handling duplicates
    '''
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums.sort()
        pos = 1
        for i in nums:
            if i > 0:
                if i != pos:
                    return pos
                pos += 1
        return pos
    '''

    # simplest solution!!!!!
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        posNum = 1
        while True:
            if posNum not in nums:
                return posNum
            else:
                posNum += 1