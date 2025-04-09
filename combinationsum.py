from typing import List
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.answer = []
        self.getcombination(candidates, target, [], 0)
        return self.answer
    
    def getcombination(self, candidates, target, currentList, index):
        if target == 0:
            self.answer.append(currentList[:])
            return
        if target < 0:
            return
        for i in range(index, len(candidates)):
            currentList.append(candidates[i])
            self.getcombination( candidates, target -  candidates[i], currentList, i)
            currentList.pop()
    

candidates = [2,3,6,7]
target = 7
print(Solution().combinationSum(candidates, target))