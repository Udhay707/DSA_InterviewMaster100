from typing import List
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        sol = []
        self.getsubsets(nums, 0, sol, [])
        return sol
    
    def getsubsets(self, nums, index, sol, curList):
        if index == len(nums):
            sol.append(curList)
            return
        self.getsubsets(nums, index+1, sol, curList[:])
        curList.append(nums[index])
        self.getsubsets(nums, index+1, sol, curList)


nums = [1,2,3]
print(Solution().subsets(nums))