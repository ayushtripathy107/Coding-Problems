class Solution(object):
    def strStr(self, haystack, needle):
        n, h = len(needle), len(haystack)
        
        # Iterate through haystack, stopping where needle can no longer fit
        for i in range(h - n + 1):
            if haystack[i : i + n] == needle:
                return i
                
        return -1
