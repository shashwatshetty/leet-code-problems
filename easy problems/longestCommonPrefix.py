#Took 2 attempts!!
class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        smallest = float('inf')
        for s in strs:
            smallest = min(smallest, len(s))
        if smallest == 0 or len(strs) == 0:
            return ''
        indx = 0
        lcp = ''
        while indx < smallest:
            alph = strs[0][indx]
            flag = 1
            for s in strs:
                if s[indx] == alph:
                    flag *= 1
                else:
                    flag *= 0
            if flag == 1:
                lcp += alph
            else:
                break
            indx += 1
        return lcp