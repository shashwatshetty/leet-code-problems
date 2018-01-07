class Solution(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        seq = '1'
        line = 1
        while line < n:
            new = ''
            i = 1
            current = seq[0]
            count = 1
            while i <= len(seq):
                if (i + 1) > len(seq):
                    new += (str(count) + current)
                    break
                if seq[i] != current:
                    new += (str(count) + current)
                    current = seq[i]
                    count = 1
                else:
                    count += 1
                i += 1
            seq = new
            #print seq
            line += 1
        return seq
