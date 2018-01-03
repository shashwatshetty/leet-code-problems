#Took 4 attempts!!
class Solution(object):
    # Cruder method, could be a bit more cleaner.
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        decimals = {"0": 0, "1": 1, "2": 2, "3": 3, "4": 4, "5": 5, "6": 6, "7": 7, "8": 8, "9": 9}
        string = str.strip()
        if len(string) == 0:
            return 0
        elif string[0] == '-':
            sign = True
            start = 1
        elif string[0] == '+':
            sign = False
            start = 1
        elif string[0] in decimals:
            sign = False
            start = 0
        else:
            return 0
        i = start
        end = start
        # extract the first occurence of a number
        while i < len(string):
            if string[i] not in decimals:
                break
            else:
                end += 1
            i += 1
        number = string[start:end]
        intRes = 0
        mul = 1
        # convert the number to int
        for digit in number[::-1]:
            intRes += (decimals[digit] * mul)
            mul *= 10
        if sign:
            intRes *= -1
        if intRes < -2147483648:
            return -2147483648
        elif intRes > 2147483647:
            return 2147483647
        return intRes