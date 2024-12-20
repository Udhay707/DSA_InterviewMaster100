
class Solution:
    memoizeMap = {}

    def climbStairs(self, n: int) -> int:
        k = self.recursive_climb(n, 0)
        self.memoizeMap = {} #for leetcode to reuse the same instance of the class with other numbers
        return k

    def recursive_climb(self, steps, currentStep) -> int:
        if(currentStep == steps):
            return 1
        if currentStep > steps:
            return 0
        
        if currentStep in self.memoizeMap:
            return self.memoizeMap[currentStep]
        
        one = self.recursive_climb(steps, currentStep+1)
        two = self.recursive_climb(steps, currentStep + 2)
        self.memoizeMap[currentStep] = one + two
        return self.memoizeMap[currentStep]

print(Solution().climbStairs(3))
