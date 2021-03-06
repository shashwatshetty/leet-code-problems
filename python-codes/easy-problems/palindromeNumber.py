#Took 1 attempt!!
class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        
        #logic without reversing
        '''
        i = 0
        j = len(str(x)) - 1
        while i <= len(str(x))/2:
            if str(x)[i] != str(x)[j]:
                return False
            i+=1
            j-=1
        return True
        '''
        
        #logic with reversing
        rev = str(x)[::-1]
        return str(x) == rev