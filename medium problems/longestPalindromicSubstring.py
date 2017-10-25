class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: str
        :rtype: bool
        """
        if len(x) <= 1:
            return True
        i = 0
        j = len(x) - 1
        while i <= len(x)/2:
            if x[i] != x[j]:
                return False
            i+=1
            j-=1
        return True
        
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
                if Solution().isPalindrome(subStr):
                    return subStr
                start += 1
            diff -= 1
            