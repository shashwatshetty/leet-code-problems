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
        '''
        if len(s) == 0:
            return ''
        start = 0
        end = 0
        subStr = s[start:end]
        indx = 0
        longest = end - start
        longestPal = ''
        while indx < len(s):
            if not Solution().isPalindrome(subStr):
                start += 1
                indx -= 1
            else:
                end += 1
            indx += 1
            if longest < end - start:
                longest = end - start
                longestPal = s[start:end]
            subStr = s[start:end]
        '''
        for start in range(len(s)):
            for end in range(len(s),0,-1):
                subStr = s[start:end]
                if Solution().isPalindrome(subStr):
                    return subStr
        return subStr