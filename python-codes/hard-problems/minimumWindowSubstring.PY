class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        alphabets = {}
        window = ""
        for a in t:
            alphabets[a] = -1
        for i in range(len(s)):
            if s[i] in alphabets:
                alphabets[s[i]] = i
        minIndx = min(alphabets.values())
        maxIndx = max(alphabets.values())
        if -1 not in alphabets.values():
            window = s[minIndx:maxIndx + 1]
        return window