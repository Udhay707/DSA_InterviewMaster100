package main

import "fmt"

func main() {
	fmt.Print(trap([]int{4, 2, 0, 3, 2, 5}))
	fmt.Println(trapO1Space([]int{4, 2, 0, 3, 2, 5}))
}

func trap(height []int) int {
	l := len(height)

	maxLeft := make([]int, l)
	maxRight := make([]int, l)
	prevLeft := 0
	prevRight := 0

	for i, j := 0, l-1; i < len(height) && j >= 0; i, j = i+1, j-1 {
		maxLeft[i] = prevLeft
		prevLeft = max(prevLeft, height[i])
		maxRight[j] = prevRight
		prevRight = max(prevRight, height[j])
	}

	trap := 0

	for i := 0; i < l; i++ {
		k := min(maxLeft[i], maxRight[i]) - height[i]
		trap += max(0, k)
	}
	return trap

}

func trapO1Space(height []int) int {
	maxLeft := 0
	maxRight := 0
	volume := 0

	for i, j := 0, len(height)-1; i < j; {
		maxLeft = max(maxLeft, height[i])
		maxRight = max(maxRight, height[j])
		if height[i] < height[j] {
			volume += maxLeft - height[i]
			i++
		} else {
			volume += maxRight - height[j]
			j--
		}
	}

	return volume
}
