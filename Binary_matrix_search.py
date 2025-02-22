from typing import List

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        start = 0
        end = len(matrix[0])-1
        #can be better optimized by fixing the row using binary search, using the same logic on row
        for i in range(0, len(matrix)):
            if(matrix[i][start] == target or matrix[i][end] == target):
                return True
            if(matrix[i][start] < target and matrix[i][end] > target):
                break
        if(i== len(matrix)):
            return False
        while(start <= end):
            mid = start + (end-start)//2
            if(matrix[i][mid] == target):
                return True
            if(matrix[i][mid] < target):
                start = mid+1
            else:
                end = mid-1
        return False
    
solution = Solution()
isFound = solution.searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]], 5)
print(isFound)