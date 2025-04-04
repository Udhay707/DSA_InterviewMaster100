package main

import (
	"fmt"
	"math"
)

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	m := len(nums1)
	n := len(nums2)
	total := m + n
	half := (total + 1) / 2

	// Ensure nums1 is the smaller array
	if m > n {
		nums1, nums2 = nums2, nums1
		m, n = n, m
	}

	left := 0
	right := m
	var median float64

	for left <= right {
		mid1 := left + (right-left)/2
		mid2 := half - mid1

		// Get boundary values using your getLowAndHigh function
		low1, high1 := getLowAndHigh(mid1-1, nums1) // Note: adjusted indices
		low2, high2 := getLowAndHigh(mid2-1, nums2) // Note: adjusted indices

		if low1 <= high2 && low2 <= high1 {
			if total%2 == 1 {
				median = float64(max(low1, low2))
			} else {
				median = (float64(max(low1, low2)) + float64(min(high1, high2))) / 2
			}
			break // Important: exit when found
		} else if low1 > high2 {
			right = mid1 - 1
		} else {
			left = mid1 + 1
		}
	}

	return median
}

func getLowAndHigh(pos int, array []int) (int, int) {
	switch {
	case pos >= 0 && pos+1 < len(array):
		return array[pos], array[pos+1]
	case pos >= 0 && pos+1 >= len(array):
		return array[pos], math.MaxInt64
	case pos < 0 && pos+1 < len(array):
		return math.MinInt64, array[pos+1]
	default:
		return math.MinInt64, math.MaxInt64
	}
}

func main() {
	num1 := []int{1, 2}
	num2 := []int{3, 4}
	fmt.Println(findMedianSortedArrays(num1, num2))
}
