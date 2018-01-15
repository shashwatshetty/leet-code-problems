#Took 1 attempt!
class Solution(object):
    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        other = {}
        i = 0
        indexList = []
        while i < len(numbers):
            sum = target - numbers[i]
            if numbers[i] in other:
                indexList.append(other[numbers[i]])
                indexList.append(i + 1)
                return indexList
            else:
                other[sum] = i + 1
            i = i + 1
        return indexList