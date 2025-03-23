package main

func searchMatrix(matrix [][]int, target int) bool {
	row, found := findRow(matrix, target)
	if !found {
		return found
	}

	left := 0
	right := len(matrix[0]) - 1

	for left <= right {
		mid := left + (right-left)/2

		if matrix[row][mid] == target {
			return true
		}

		if matrix[row][mid] < target {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return false
}

func findRow(matrix [][]int, target int) (int, bool) {
	startCol := 0
	endCol := len(matrix[0]) - 1

	left := 0
	right := len(matrix) - 1

	for left <= right {
		mid := left + (right-left)/2
		if target >= matrix[mid][startCol] && target <= matrix[mid][endCol] {
			return mid, true
		}

		if target > matrix[mid][endCol] {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return -1, false
}
