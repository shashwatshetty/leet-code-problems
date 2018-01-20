class Solution(object):
    '''
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
    '''

    def circularArrayLoop(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        length = len(nums)
        if length < 2:
            return False
        while True:
            slow = 0
            fast = 0
            tempSlow = (slow + nums[slow])
            if tempSlow < 0:
                tempSlow = length - tempSlow
            else:
                tempSlow = tempSlow % length
            tempFast = (fast + nums[fast]) % length
            tempFast = (tempFast + nums[tempFast]) % length
            if tempSlow == slow or tempFast == fast:
                return False
            elif tempSlow == tempFast:
                return True
            slow = tempSlow
            fast = tempFast

    def updateIndex(self, index, nums):
        """
        :param index: int
        :param nums: List[int]
        :return: int
        """
        temp = index + nums[index]
        if temp < 0:
            return len(nums) + temp
        else:
            return temp % len(nums)
