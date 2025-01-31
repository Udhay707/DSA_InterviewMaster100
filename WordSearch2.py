from typing import List
class Trie:
    def __init__(self):
        self.children = {}
        self.is_word = False

class Solution:
    def __init__(self):
        self.trie = Trie()
        self.result = set()

    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        self.buildTrie(words)
        rows, cols = len(board), len(board[0])
        
        # Start DFS from each cell
        for i in range(rows):
            for j in range(cols):
                self.dfs(board, i, j, self.trie, "")
        
        return list(self.result)
    
    def dfs(self, board: List[List[str]], row: int, col: int, node: Trie, word: str):
        letter = board[row][col]
        if letter not in node.children:
            return

        node = node.children[letter]
        word += letter
        
        if node.is_word:
            self.result.add(word)
            node.is_word = False
        
        board[row][col] = "#"

        # Explore all 4 directions
        for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
            newRow, newCol = row + dx, col + dy
            if 0 <= newRow < len(board) and 0 <= newCol < len(board[0]) and board[newRow][newCol] != "#":
                self.dfs(board, newRow, newCol, node, word)
        
        board[row][col] = letter  # Restore original letter

    def buildTrie(self, words: List[str]):
        for word in words:
            self.addToTrie(word)

    def addToTrie(self, word: str):
        node = self.trie
        for letter in word:
            if letter not in node.children:
                node.children[letter] = Trie()
            node = node.children[letter]
        node.is_word = True

sol = Solution()
board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]
words = ["oath","pea","eat","rain","hklf", "hf"]
foundWords = sol.findWords(board, words)
print(foundWords)