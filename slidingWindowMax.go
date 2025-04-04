package main

import "fmt"

func maxSlidingWindow(nums []int, k int) []int {
	result := make([]int, len(nums)-k+1)
	slice := make([]int, 0, k)
	slice = append(slice, 0)

	for i := 1; i < k; i++ {
		for len(slice) > 0 && nums[slice[len(slice)-1]] < nums[i] {
			slice = slice[:len(slice)-1]
		}
		slice = append(slice, i)
	}
	result[0] = nums[slice[0]]
	for left, right := 1, k; right < len(nums); left, right = left+1, right+1 {
		if slice[0] < left {
			slice = slice[1:]
		}

		for len(slice) > 0 && nums[slice[len(slice)-1]] < nums[right] {
			slice = slice[:len(slice)-1]
		}
		slice = append(slice, right)
		result[left] = nums[slice[0]]
	}
	return result
}

func main() {
	nums := []int{1, 3, -1, -3, 5, 3, 6, 7}
	k := 3

	fmt.Println(maxSlidingWindow(nums, k))
}
