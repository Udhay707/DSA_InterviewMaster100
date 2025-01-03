from typing import List
class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        self.transpose(matrix)
        self.swap_columns(matrix)
        return matrix


    def transpose(self, matrix: List[List[int]]) -> None:
        for i in range(0, len(matrix)):
            for j in range(i, len(matrix)):
                temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp

    def swap_columns(self, matrix: List[List[int]]) -> None:
        i=0
        j= len(matrix) -1
        while(i<j):
            for k in range(0, len(matrix)):
                temp = matrix[k][i]
                matrix[k][i] = matrix[k][j]
                matrix[k][j] = temp
            i+=1
            j-=1


solution = Solution()
k = solution.rotate([[1,2,3],[4,5,6],[7,8,9]])
print(k)