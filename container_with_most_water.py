from typing import List
class Solution:
    def maxArea(self, height: List[int]) -> int:
        maxArea = 0
        pointer1 = 0
        pointer2 = len(height)-1
        while(pointer1 < pointer2):
            area = min(height[pointer1], height[pointer2]) * (pointer2 - pointer1)
            if area > maxArea:
                maxArea = area
            if height[pointer1] < height[pointer2]:
                pointer1+=1
            else:
                pointer2-=1    

        return maxArea


solution = Solution().maxArea([8,7,2,1])
print(solution)     