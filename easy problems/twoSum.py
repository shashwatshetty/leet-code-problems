#Took 2 attempts!!
class Solution(object):
    # Brute Force Method:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        flag = False
        indexList = []
        for i in range(len(nums) - 1):
            for j in range(i+1,len(nums)):
                if nums[i] + nums[j] == target:
                    indexList.append(i)
                    indexList.append(j)
                    flag = True
                    break
            if flag:
                break
        return indexList
                