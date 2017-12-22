class Solution(object):
    # brute force method
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        sol = []
        length = len(nums)
        for i in range(length):
            for j in range(length):
                for k in range(length):
                    if (i != k) and (j != k) and (i != j):
                        sum = nums[i] + nums[j] + nums[k]
                        if sum == 0:
                            triplet = [nums[i], nums[j], nums[k]]
                            triplet.sort()
                            if not sol.__contains__(triplet):
                                sol.append(triplet)
        return sol

# running program runtime tests
'''
import time
import random
start = time.time()
ip = random.sample(range(-200,200), 150)
print Solution().threeSum(ip)
print "Total Time: ",(time.time() - start)
print ip
'''