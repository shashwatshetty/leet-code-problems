class Solution(object):


    # Method fails for arrays with similar valued elements
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


    # Method doesn't check for more than one element needs to be in the path of the loop.

    def circularArrayLoop(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        length = len(nums)
        if length < 2:
            return False
        indx = 0
        while True:
            next = Solution().updateIndex(indx, nums)
            if indx == next:
                return False
            if nums[next] == 0:
                return True
            nums[indx] = 0
            indx = next


    def updateIndex(self, index, nums):
        """
        :param index: int
        :param nums: List[int]
        :return: int
        """
        temp = index + nums[index]
        if temp < 0:
            return len(nums) - (-temp % len(nums))
        else:
            return temp % len(nums)

    def isPositive(self,num):
        """

        :param num:
        :return:
        """