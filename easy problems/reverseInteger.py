class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        intStr = str(x)
        if intStr[0] >= '0' and intStr[0] <= '9':
            xReverse = int(intStr[::-1])
        else:
            xReverse = int(intStr[:0:-1]) * -1
            
        if xReverse <= -2**31 or xReverse >= 2**31:
            return 0
        else:
            return xReverse