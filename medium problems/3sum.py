class Solution(object):
    # brute force method : TLE
    '''
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
    '''

    # Divide & Conquer method : TLE
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        neg = []
        zeros = []
        pos = []
        sol = []
        # divide the array in positives, negatives and non-negatives
        for num in nums:
            if num < 0:
                neg.append(num)
            elif num > 0:
                pos.append(num)
            else:
                zeros.append(num)

        # if there are non-negatives
        if len(zeros) != 0:
            # add triplets with compliments of each other
            for n in neg:
                if abs(n) in pos and [n, 0, abs(n)] not in sol:
                    sol.append([n, 0, abs(n)])

        # if there are more than 3 non-negatives
        if len(zeros) >= 3:
            sol.append([0, 0, 0])

        # add two negatives and find the sum's compliment in positive list
        for i in range(len(neg) - 1):
            for j in range(i + 1, len(neg)):
                sum = abs(neg[i] + neg[j])
                if sum in pos and [neg[i], neg[j], sum] not in sol:
                    sol.append([neg[i], neg[j], sum])

        # add two positives and find the sum's compliment in negative list
        for i in range(len(pos) - 1):
            for j in range(i + 1, len(pos)):
                sum = -1 * (pos[i] + pos[j])
                if sum in neg and [sum, pos[i], pos[j]] not in sol:
                    sol.append([sum, pos[i], pos[j]])
        return sol

# running program runtime tests
# import time
# import random
# start = time.time()
# #ip = random.sample(range(-200,200), 150)
# print Solution().threeSum(ip)
# print "Total Time: ",(time.time() - start)
# print ip