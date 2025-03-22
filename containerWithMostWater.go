package main

import "fmt"

func main() {
	i := maxArea([]int{1, 8, 6, 2, 5, 4, 8, 3, 7})
	fmt.Print(i)
}

func maxArea(height []int) int {
	maximum := 0
	i, j := 0, len(height)-1

	for i < j {
		maximum = max(maximum, (j-i)*min(height[i], height[j]))
		if height[j] < height[i] {
			j--
		} else {
			i++
		}
	}
	return maximum

}
