# Took 2 attempts!
class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        parenth = {'(':')', '{':'}','[':']'}
        parenthStack = []
        for p in s:
            if p in parenth:
                parenthStack.append(parenth[p])
            else:
                if len(parenthStack) == 0:
                    return False
                else:
                    bracket = parenthStack.pop()
                    if bracket != p:
                        return False
        if len(parenthStack) != 0:
            return False
        else:
            return True