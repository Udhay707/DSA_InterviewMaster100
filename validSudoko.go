package main

import "fmt"

func isValidSudoku(board [][]byte) bool {
	size := 9

	for row := 0; row < size; row++ {
		rowMap := make(map[byte]bool)
		colMap := make(map[byte]bool)
		boxMap := make(map[byte]bool)

		for col := 0; col < size; col++ {
			if board[row][col] != '.' {
				if rowMap[board[row][col]] {
					return false
				}
				rowMap[board[row][col]] = true
			}
			if board[col][row] != '.' {
				if colMap[board[col][row]] {
					return false
				}
				colMap[board[col][row]] = true
			}
			boxRow := (row/3)*3 + col/3
			boxCol := (row%3)*3 + col%3
			if board[boxRow][boxCol] != '.' {
				if boxMap[board[boxRow][boxCol]] {
					return false
				}
				boxMap[board[boxRow][boxCol]] = true
			}
		}
	}
	return true
}

func main() {
	board := [][]byte{{'.', '.', '.', '.', '5', '.', '.', '1', '.'}, {'.', '4', '.', '3', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '3', '.', '.', '1'}, {'8', '.', '.', '.', '.', '.', '.', '2', '.'}, {'.', '.', '2', '.', '7', '.', '.', '.', '.'}, {'.', '1', '5', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '2', '.', '.', '.'}, {'.', '2', '.', '9', '.', '.', '.', '.', '.'}, {'.', '.', '4', '.', '.', '.', '.', '.', '.'}}
	k := isValidSudoku(board)
	fmt.Print(k)
}
