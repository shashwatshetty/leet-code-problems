class Solution(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        seq = '1'
        count = 1
        while count < n:
            done = []
            newSeq = ''
            for c in seq:
                if c not in done:
                    newSeq += (str(seq.count(c)) + c)
                    done.append(c)
            seq = newSeq
            count += 1
        return seq