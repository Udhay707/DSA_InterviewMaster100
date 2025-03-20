package main

import "fmt"

func main() {
	nums := []int{100, 4, 200, 1, 3, 2}
	fmt.Println(longestConsecutive(nums))

}

func longestConsecutive(nums []int) int {
	res := make(map[int]bool, len(nums))
	for _, num := range nums {
		res[num] = true
	}

	maxCount := 0

	for num := range res {
		if res[num-1] {
			continue
		}
		curNum := num
		curFreq := 1

		for res[curNum+1] {
			curNum++
			curFreq++
		}

		if curFreq > maxCount {
			maxCount = curFreq
		}
	}
	return maxCount

}
