package main

import (
	"fmt"
	"math"
)

func minEatingSpeed(piles []int, h int) int {
	maxNum := piles[0]
	pilesFloat := make([]float64, len(piles))
	for i := 0; i < len(piles); i++ {
		maxNum = max(maxNum, piles[i])
		pilesFloat[i] = float64(piles[i])
	}

	start := 0
	end := maxNum

	for start <= end {
		mid := start + (end-start)/2

		if isEatable(pilesFloat, h, float64(mid)) {
			end = mid - 1
			maxNum = mid
		} else {
			start = mid + 1
		}
	}
	return maxNum
}

func isEatable(piles []float64, h int, speed float64) bool {

	i := 0

	for i < len(piles) && h > 0 {
		hoursConsumed := int(math.Ceil(piles[i] / speed))
		h -= hoursConsumed
		i++
	}

	if i == len(piles) && h >= 0 {
		return true
	}

	return false

}

func main() {
	piles := []int{3, 6, 7, 11}
	h := 8

	fmt.Println(minEatingSpeed(piles, h))
}
