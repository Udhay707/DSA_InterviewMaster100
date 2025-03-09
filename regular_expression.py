from typing import List


class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        memo = [[None] * len(p) for _ in range(len(s) + 1)]
        return self.checkMatch(s, p, 0, 0, memo)
    
    def checkMatch(self, s: str, p: str, sIndex: int, pIndex: int, memo: List[List[int]]) -> bool:
        if(sIndex == len(s) and pIndex == len(p)):
            return True
        
        if pIndex >= len(p):
            return False

        if memo[sIndex][pIndex] != None:
            return memo[sIndex][pIndex]
        
        memoMatch = False

        match = sIndex < len(s) and (s[sIndex] == p[pIndex] or p[pIndex] == ".")
        isNextStar = pIndex+1 < len(p) and p[pIndex+1] == "*"
        
        if match:
            if isNextStar:
                memoMatch = self.checkMatch(s, p, sIndex, pIndex+2, memo) or self.checkMatch(s, p, sIndex+1, pIndex, memo)   
            else:
                memoMatch = self.checkMatch(s, p, sIndex+1, pIndex+1, memo)
        else:
            if isNextStar:
                memoMatch = self.checkMatch(s, p, sIndex, pIndex+2, memo)
            else:
                memoMatch = False
        
        memo[sIndex][pIndex] = memoMatch
        return memoMatch


sol = Solution().isMatch("aab", "c*a*b")
print(sol)