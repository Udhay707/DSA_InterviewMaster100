from typing import List

class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        left,right,top,bottom=0, len(matrix[0])-1, 0, len(matrix)-1
        row, col= 0,0
        returnArray = []
        while(True):
            while(col <= right):
                returnArray.append(matrix[row][col])
                col+=1
            top+=1
            row+=1
            col-=1
            if(row>bottom):
                return returnArray
            while(row <= bottom):
                returnArray.append(matrix[row][col])
                row+=1
            right-=1
            col-=1
            row-=1
            if(col<left):
                return returnArray
            while(col>= left):
                returnArray.append(matrix[row][col])
                col-=1
            row-=1
            bottom-=1
            col+=1
            if(row<top):
                return returnArray
            while(row >= top):
                returnArray.append(matrix[row][col])
                row -=1
            col+=1
            left+=1   
            row+=1
            if(col>right):
                return returnArray    
        return returnArray


def printMatrics(matrix: List[List[int]]):
    rowLength = len(matrix)
    colLength = len(matrix[0])
    for i in range(0,rowLength):
        for j in range(0, colLength):
            print(matrix[i][j], end = " ")
        print()   

printMatrics([[2,5,8],[4,0,-1]])
answer = Solution().spiralOrder([[2,5,8],[4,0,-1]])
print(answer)

