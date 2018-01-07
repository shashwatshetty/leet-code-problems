class Solution(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        seq = '1'
        line = 1
        while line < n:
            if len(seq) == 1:
                new = '11'
            new = ''
            i = 1
            current = seq[0]
            count = 1
            while i < len(seq):
                if seq[i] != current:
                    new += (str(count) + current)
                    current = seq[i]
                    count = 1
                else:
                    count += 1
            seq = new
            print seq
            l += 1
        return seq