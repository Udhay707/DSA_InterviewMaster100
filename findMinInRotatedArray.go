package main

import "fmt"

// Record the minimum number in a variable, instead of confusing whether the smallest lies in start or end
func main() {
	nums := []int{3, 4, 5, 1, 2}
	fmt.Println(findMin(nums))
}

func findMin(nums []int) int {

	start := 0
	end := len(nums) - 1
	small := 5000 //as per constraint it is mentioned as max number
	for start <= end {
		mid := start + (end-start)/2
		small = min(small, nums[mid])
		if nums[mid] > nums[end] {
			start = mid + 1
		} else {
			end = mid - 1
		}
	}
	return small
}
