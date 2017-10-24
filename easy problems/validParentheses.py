class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        brackets = {'(':0, ')':0, '[':0, ']':0, '{':0, '}':0}
        openPara = '([{'
        for b in s:
            if b in openPara:
                brackets[b] += 1
            else:
                brackets[b] -= 1
        prod = 1
        for val in brackets.values():
            prod *= val
        return prod == 0