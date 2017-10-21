class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        s = s[::-1]
        romLet = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C':100,'D':500, 'M': 1000}
        val = romLet[s[0]]
        for i in range(1,len(s)):
            if romLet[s[i]] < romLet[s[i-1]]:
                val -= romLet[s[i]]
            else:
                val += romLet[s[i]]
        return val