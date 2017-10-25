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
        flag = True
        keys = brackets.keys()
        for k in keys:
            if k in '()':
               flag = flag and (brackets['('] == brackets [')'])
            elif k in '[]':
                flag = flag and (brackets['['] == brackets [']'])
            elif k in '{}':
                flag = flag and (brackets['{'] == brackets ['}'])
            print "Flag: ",flag," For k: ",k
        return flag