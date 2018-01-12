class Solution(object):
    def circularArrayLoop(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        length = len(nums)
        if length <= 1:
            return False
        i = 0
        indx = 0
        quotient = 0
        while quotient < 3:
            newI = (i + nums[indx]) % length
            quotient = (i + nums[indx]) / length
            if newI == i:
                return False
            indx = newI
            i += newI
            #print i
        return True
