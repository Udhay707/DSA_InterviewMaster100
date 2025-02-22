from typing import List
from collections import deque

class Solution:
    def solve(self, board: List[List[str]]) -> None:
        if not board or not board[0]:
            return
        
        rows, cols = len(board), len(board[0])
        queue = deque()
        
        # Step 1: Add all border "O" cells to the queue
        for r in range(rows):
            for c in range(cols):
                if (r == 0 or r == rows - 1 or c == 0 or c == cols - 1) and board[r][c] == "O":
                    queue.append((r, c))
        
        # Step 2: Perform BFS to mark border-connected "O" cells as "T"
        directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        
        while queue:
            r, c = queue.popleft()
            if board[r][c] == "O":
                board[r][c] = "T"
                for dr, dc in directions:
                    nr, nc = r + dr, c + dc
                    if 0 <= nr < rows and 0 <= nc < cols and board[nr][nc] == "O":
                        queue.append((nr, nc))

        # Step 3: Flip all remaining "O" to "X" and revert "T" back to "O"
        for r in range(rows):
            for c in range(cols):
                if board[r][c] == "O":
                    board[r][c] = "X"
                elif board[r][c] == "T":
                    board[r][c] = "O"

# Test case
sol = Solution()
board = [["X", "X", "X", "X"],
         ["X", "O", "O", "X"],
         ["X", "X", "O", "X"],
         ["X", "O", "X", "X"]]

sol.solve(board)

# Print the result
for row in board:
    print(" ".join(row))