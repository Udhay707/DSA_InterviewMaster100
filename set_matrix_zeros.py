from typing import List,Tuple
class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        rowLength: int = len(matrix)
        colLength: int = len(matrix[0])
        positionOfZeros: List[Tuple[int]] = self.get0positions(matrix, rowLength, colLength)
        if len(positionOfZeros) == 0:
            return
        for row, col in positionOfZeros:
            i = 0
            j = 0
            while(i<colLength and j < rowLength):
                matrix[row][i] = 0
                matrix[j][col] = 0
                j+=1
                i+=1
            while(i< colLength):
                matrix[row][i] = 0
                i+=1
            while(j< rowLength):
                matrix[j][col] = 0
                j+=1         
        
    def get0positions(self, matrix: List[List[int]], rowLength: int, colLength: int) -> List[Tuple[int]]:
        positionList = []
        for row in range(0, rowLength):
            for column in range(0, colLength):
                if matrix[row][column] == 0:
                    positionList.append((row, column))
        return positionList            

def printMatrics(matrix: List[List[int]]):
    rowLength = len(matrix)
    colLength = len(matrix[0])
    for i in range(0,rowLength):
        for j in range(0, colLength):
            print(matrix[i][j], end = " ")
        print()    

solution = Solution()
matrix = [[1,1,1],[1,0,1],[1,1,1]]
printMatrics(matrix)
solution.setZeroes(matrix)
print()
printMatrics(matrix)