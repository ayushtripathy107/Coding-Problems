class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        # split() without arguments automatically handles multiple spaces 
        # and trims trailing/leading whitespaces.
        words = s.split()
        
        # Return the length of the last element in the list
        return len(words[-1])
