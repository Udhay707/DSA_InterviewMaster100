package main

import "fmt"

func permute(nums []int) [][]int {
	var result [][]int = make([][]int, 0, len(nums)*2)
	backtrack(nums, 0, &result)
	return result

}

func backtrack(nums []int, index int, result *[][]int) {
	if index == len(nums) {
		newSlice := make([]int, len(nums))
		copy(newSlice, nums)
		*result = append(*result, newSlice)
		return
	}
	for i := index; i < len(nums); i++ {
		nums[index], nums[i] = nums[i], nums[index]
		backtrack(nums, index+1, result)
		nums[index], nums[i] = nums[i], nums[index]
	}
}

func main() {
	nums := []int{1, 2, 3}
	res := permute(nums)
	fmt.Println(res)
}
