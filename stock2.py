from typing import List

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        maxProfit = 0
        pointer = 0
        for i in range(0,len(prices)):
            profit = prices[i] - prices[pointer] 
            if profit > 0:
                maxProfit += profit 
                pointer = i
            if prices[i] < prices[pointer]:
                pointer = i
        return maxProfit        

profit = Solution().maxProfit([7,6,4,3,1]) 
print(profit)