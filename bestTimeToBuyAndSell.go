package main

import (
	"fmt"
	"math"
)

func maxProfit(prices []int) int {
	maxProfit := 0

	minSoFar := math.MaxInt64

	for i := 0; i < len(prices); i++ {
		if prices[i] < minSoFar {
			minSoFar = prices[i]
		}

		maxProfit = max(maxProfit, prices[i]-minSoFar)
	}

	return maxProfit

}
func main() {
	prices := []int{7, 6, 4, 3, 1}
	fmt.Println(maxProfit(prices))
}
