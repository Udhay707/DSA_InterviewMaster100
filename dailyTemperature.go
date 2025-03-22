package main

import "fmt"

func dailyTemperatures(temperatures []int) []int {

	stack := make([]int, 0)
	result := make([]int, len(temperatures))
	for idx, value := range temperatures {
		for len(stack) > 0 && temperatures[stack[len(stack)-1]] < value {
			lastStackIndex := stack[len(stack)-1]
			result[lastStackIndex] = idx - lastStackIndex
			stack = stack[:len(stack)-1]
		}
		stack = append(stack, idx)
	}
	return result
}

func main() {
	fmt.Println(dailyTemperatures([]int{73, 74, 75, 71, 69, 72, 76, 73}))
}
