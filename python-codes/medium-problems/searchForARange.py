# Took 1 attempt! (Referred a solution)
class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        minIndex = float('inf')
        maxIndex = -float('inf')
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = (low + high)/2
            if nums[mid] == target:
                minIndex = min(minIndex, mid)
                high = mid - 1
            elif nums[mid] < target:
                low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = (low + high) / 2
            if nums[mid] == target:
                maxIndex = max(maxIndex, mid)
                low = mid + 1
            elif nums[mid] < target:
                low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
        if minIndex == float('inf'):
            minIndex = -1
        if maxIndex == -float('inf'):
            maxIndex = -1
        return [minIndex, maxIndex]


