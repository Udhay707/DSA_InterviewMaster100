package main

import "fmt"

func main() {
	arr := []int{1, 5, 1}
	nextPermutation(arr)
	fmt.Print(arr)
}

func nextPermutation(nums []int) {
	lastIndex := len(nums) - 1

	if lastIndex == 0 {
		return
	}
	i := lastIndex - 1
	for ; i >= 0; i-- {
		if nums[i] < nums[i+1] {
			break
		}
	}

	if i < 0 {
		reverse(nums, 0, lastIndex)
		return
	}
	j := lastIndex
	for ; j > i && nums[j] <= nums[i]; j-- {
	}

	nums[i], nums[j] = nums[j], nums[i]

	reverse(nums, i+1, lastIndex)

}

func reverse(nums []int, left, right int) {
	for left < right {
		nums[left], nums[right] = nums[right], nums[left]
		left++
		right--
	}
}
