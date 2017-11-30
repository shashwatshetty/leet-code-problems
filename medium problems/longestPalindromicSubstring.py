class Solution(object):        
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        print len(s)
        if len(s) == 0:
            return s
        diff = len(s)
        while diff > 0:
            start = 0
            while start + diff <= len(s):
                end = start + diff
                subStr = s[start:end]
                if subStr == subStr[::-1]:
                    return subStr
                start += 1
            diff -= 1