class Solution(object):
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        decimals = {"0": 0, "1": 1, "2": 2, "3": 3, "4": 4, "5": 5, "6": 6, "7": 7, "8": 8, "9": 9}
        sign = False
        number = str
        if str[0] == '-':
            sign = True
            number = str[1:]
        mul = 1
        intRes = 0
        for digit in number[::-1]:

            intRes += (decimals[digit] * mul)
            mul *= 10
        if sign:
            intRes *= -1
        return intRes