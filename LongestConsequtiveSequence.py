from typing import List, Set

class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        table : Set[int] = set(nums)
        finder : dict = {}
        maxCount: int = 0
        for i in table:
            if i in finder:
                continue
            current = self.getCount(table, i,finder)
            if(current> maxCount):
                maxCount = current
        return maxCount

    def getCount(self, table: Set[int], currentNumber: int, finder: dict):
        if(currentNumber + 1 in table):
            finder[currentNumber] = 1 + self.getCount(table, currentNumber+1, finder)
            return finder[currentNumber]
        finder[currentNumber] = 1
        return finder[currentNumber]
        
        

sol = Solution()
print(sol.longestConsecutive([1,2,0,1]))