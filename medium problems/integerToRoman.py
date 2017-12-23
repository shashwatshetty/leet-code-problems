# Took 2 attempts!
class Solution(object):
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        romLet = {1: 'I', 4:'IV', 5: 'V', 9: 'IX', 10: 'X', 40: 'XL', 50: 'L', 90: 'XC', 100: 'C', 400: 'CD', 500: 'D', 900: 'CM', 1000: 'M'}
        mul = 1
        roman = ''
        while num != 0:
            digit = num % 10
            if (digit * mul) in romLet:
                roman = romLet[(digit * mul)] + roman
            elif digit < 4:
                roman = (romLet[mul] * digit) + roman
            else:
                roman = (romLet[(5 * mul)] + romLet[mul] * (digit - 5)) + roman
            num = num / 10
            mul *= 10
        return roman