package main

import "fmt"

func main() {
	heights := []int{2, 4}
	fmt.Println(largestRectangleArea(heights))
}

func largestRectangleArea(heights []int) int {
	var length = len(heights)
	stack := make([][2]int, 0, length)
	stack = append(stack, [2]int{0, heights[0]})
	maxArea := 0

	for i := 1; i <= length; i++ {
		var height int = getHeight(i, length, heights)
		lastIndex := i
		for len(stack) > 0 && stack[len(stack)-1][1] > height {
			stackLength := len(stack) - 1
			lastIndex = stack[stackLength][0]
			lastHeight := stack[stackLength][1]
			stack = stack[:stackLength]
			maxArea = max(maxArea, lastHeight*(i-lastIndex))
		}
		stack = append(stack, [2]int{lastIndex, height})
	}
	return maxArea
}

func getHeight(i int, length int, heights []int) int {
	if i == length {
		return 0
	} else {
		return heights[i]
	}
}
