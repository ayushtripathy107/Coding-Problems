from collections import Counter

class Solution(object):
    def canConstruct(self, ransomNote, magazine):
        # Count the frequency of characters in both strings
        note_counts = Counter(ransomNote)
        mag_counts = Counter(magazine)
        
        # Check if magazine has enough of each character needed for the note
        for char, count in note_counts.items():
            if mag_counts[char] < count:
                return False
                
        return True
