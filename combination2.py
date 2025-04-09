from typing import List
class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        self.answer = []
        self.rec(candidates, target, [], 0)
        return self.answer
    
    def rec(self, candidates, target, currentList, index):
        if target == 0:
            self.answer.append(currentList[:])
            return
        if target < 0:
            return
        for i in range(index, len(candidates)):
            self.rec(candidates, target, currentList, index+1)
            currentList.append(candidates[i])
            self.rec(candidates, target-candidates[i], currentList, index+1)
            currentList.pop()

sol = Solution().combinationSum2([10,1,2,7,6,1,5], 8)
print(sol)