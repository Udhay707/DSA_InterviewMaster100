package main

import "fmt"

func searchInRotatedSortedArray(nums []int, target int) int { //func name changed
	pivotIndex := findPivot(nums)

	first := binarySearch(nums, 0, pivotIndex-1, target)
	if first != -1 {
		return first
	}
	second := binarySearch(nums, pivotIndex, len(nums)-1, target)

	return max(first, second)

}

// to find pivot always use a variable
func findPivot(nums []int) int {
	start := 0
	end := len(nums) - 1
	minimum := 0
	for start <= end {
		mid := start + (end-start)/2
		if nums[minimum] > nums[mid] {
			minimum = mid
		}
		if nums[mid] > nums[end] {
			start = mid
		} else {
			end = mid - 1
		}
	}
	return minimum

}

func binarySearch(nums []int, start int, end int, target int) int {
	if start > end {
		return -1
	}
	mid := start + (end-start)/2

	if nums[mid] == target {
		return mid
	}

	if nums[mid] > target {
		return binarySearch(nums, start, mid-1, target)
	} else {
		return binarySearch(nums, mid+1, end, target)
	}
}

func main() {
	fmt.Println(searchInRotatedSortedArray([]int{5, 1, 3}, 1))
}
