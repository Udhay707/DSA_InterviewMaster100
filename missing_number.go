package main

import (
	"fmt"
)

/*
*
@name missingNumber
@description Add all the number in the array
subtract the sum with the index
subtract index again -> because array only contains n-1 elements (without missing number)
The sum will be in negative, as the sum of index will be larger than the array itself
*
*/
func missingNumber(nums []int) int {

	var sum int = 0

	for index := range nums {
		sum += nums[index]
		sum -= index
	}
	sum -= len(nums)
	return sum * -1
}

func main() {
	array := make([]int, 3)
	result := missingNumber(array)
	fmt.Print(result)
}
