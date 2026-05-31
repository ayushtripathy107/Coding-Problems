class Solution(object):
    def asteroidsDestroyed(self, mass, asteroids):
        """
        :type mass: int
        :type asteroids: List[int]
        :rtype: bool
        """
        # Sort asteroids to consume the smallest ones first
        asteroids.sort()
        
        current_mass = mass
        for a in asteroids:
            if current_mass >= a:
                current_mass += a
            else:
                # Planet is destroyed
                return False
                
        return True
