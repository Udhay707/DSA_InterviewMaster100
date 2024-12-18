from typing import List
class Solution:
    """
You are given an integer array prices where prices[i] is the price of the ith item in a shop.

There is a special discount for items in the shop. If you buy the ith item, then you will receive a discount equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i]. Otherwise, you will not receive any discount at all.

Return an integer array answer where answer[i] is the final price you will pay for the ith item of the shop, considering the special discount.
    """
    def finalPrices(self, prices: List[int]) -> List[int]:
        if len(prices) == 1:
            return prices
        array = prices
        stack = []
        for i in range(len(prices)-1 , -1, -1 ):
            last_item = 0
            while(len(stack) != 0 ):
                item = stack.pop()
                if item <= prices[i]:
                    stack.append(item)
                    last_item = item
                    break
            stack.append(array[i])    
            array[i] = prices[i] - last_item
        return array    


prices = [8,4,6,2,3]
k = Solution().finalPrices(prices)
print(k)