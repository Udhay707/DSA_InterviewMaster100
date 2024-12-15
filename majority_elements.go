package main

import (
	"fmt"
)

func main() {
	numbers := [7]int{2, 2, 1, 1, 1, 2, 2}
	fmt.Print(majorityElements(numbers[:]))
}

func majorityElements(nums []int) int {
	countMap := make(map[int]int)

	for _, value := range nums {
		countMap[value] = countMap[value] + 1
	}
	var largeKey int = 0
	var maxOccurance int = 0
	for key, value := range countMap {
		if value > maxOccurance {
			maxOccurance = value
			largeKey = key
		}
	}
	return largeKey
}
