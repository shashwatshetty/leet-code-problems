#Took 6 attempts!!
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if len(s) == 0:
            return 0
        start = 0
        end = 0
        subStr = s[start:end]
        indx = 0
        longest = end - start
        while indx < len(s):
            if s[indx] in subStr:
                start += 1
                indx -= 1
            else:
                end += 1
            indx += 1
            if longest < end - start:
                longest = end - start
            subStr = s[start:end]
        return longest