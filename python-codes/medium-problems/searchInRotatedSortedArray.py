#Took 2 attempts
class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if len(nums) < 1:
            return -1
        low = 0
        high = len(nums) - 1
        while (high - low) > 1:
            mid = (low + high)/2
            if nums[low] > nums[high]:
                low = mid
            else:
                high = mid
        pivot = low if (nums[high] > nums[low]) else high
        print pivot
        leftEnd = len(nums) - 1
        rightEnd = pivot - 1
        if target <= nums[leftEnd]:
            low = pivot
            high = leftEnd
        else:
            low = 0
            high = rightEnd
        print low,high
        while low <= high:
            mid = (low + high)/2
            if target == nums[mid]:
                return mid
            elif target < nums[mid]:
                high = mid - 1
            elif target > nums[mid]:
                low = mid + 1
        return -1