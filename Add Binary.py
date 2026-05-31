class Solution(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        # Convert binary strings to integers, add them, 
        # then convert back to binary string and strip the '0b' prefix
        return bin(int(a, 2) + int(b, 2))[2:]
