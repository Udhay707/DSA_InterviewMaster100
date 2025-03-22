package main

import (
	"fmt"
	"sort"
)

func threeSum(nums []int) [][]int {
	sort.Ints(nums) // Sort the array
	triplets := make([][]int, 0)
	length := len(nums)

	for i := 0; i < length-2; i++ { // Iterate up to the third-last element
		// Skip duplicates for the first element
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}
		if nums[i] > 0 {
			break
		}
		needed := 0 - nums[i]
		low := i + 1
		high := length - 1

		for low < high {
			sum := nums[low] + nums[high]
			if sum == needed {
				triplets = append(triplets, []int{nums[i], nums[low], nums[high]})
				getNewLowAndHigh(&low, &high, nums)
			} else if sum < needed {
				low++
			} else {
				high--
			}
		}
	}

	return triplets
}

func getNewLowAndHigh(low *int, high *int, nums []int) {
	for *low < *high && nums[*low] == nums[*low+1] {
		*low++
	}
	//for avoiding duplicates in high
	for *low < *high && nums[*high] == nums[*high-1] {
		*high--
	}

	*low++
	*high--
}

func main() {
	fmt.Println(threeSum([]int{-1, 0, 1, 2, -1, -4}))
}
