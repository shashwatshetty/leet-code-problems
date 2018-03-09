class Solution(object):
    def minDistance(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        """
        i = len(word1)
        j = len(word2)
        solves = {}
        return self.calculateDist(word1, word2, i, j, solves)

    # memoized version of Levenstein edit distances
    def calculateDist(self, w1, w2, i, j, memo):
        """
        :type w1: str
        :type w2: str
        :type i: int
        :type j: int
        :type memo: dict
        :rtype: int
        """
        if j == 0:
            return i
        elif i == 0:
            return j
        elif (i, j) in memo:
            return memo[(i, j)]
        elif w1[i - 1] == w2[j - 1]:
            dist = min(self.calculateDist(w1, w2, i - 1, j - 1, memo),
                       self.calculateDist(w1, w2, i, j - 1, memo) + 1,
                       self.calculateDist(w1, w2, i - 1, j, memo) + 1)
            memo[(i, j)] = dist
        else:
            dist = min(self.calculateDist(w1, w2, i - 1, j - 1, memo) + 1,
                       self.calculateDist(w1, w2, i, j - 1, memo) + 1,
                       self.calculateDist(w1, w2, i - 1, j, memo) + 1)
            memo[(i, j)] = dist
        return memo[(i, j)]
