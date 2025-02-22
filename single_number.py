from typing import List
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        result = 0
        for num in nums:
            result ^= num

        return result    
    
"""
XOR basics
    Number ^ Number  = 0
    Number ^ 0 = Number
"""  

print(Solution().singleNumber([2,2,1]))