package main

import (
	"fmt"
	"math"
)

func myAtoi(s string) int {
	flag := 1
	start := 0
	sum := 0

	for _, v := range s {
		if v == ' ' && start == 0 {
			continue
		}
		if start == 0 && v == '+' {
			start = 1
			continue
		}
		if start == 0 && v == '-' {
			flag = -1
			start = 1
			continue
		}
		if (v < '0' || v > '9') && start == 0 {
			return 0
		}
		if (v < '0' || v > '9') && start == 1 {
			return flag * sum
		}
		start = 1
		sum = sum*10 + int(v-'0')
		if flag == -1 && -sum < math.MinInt32 {
			return math.MinInt32
		}
		if flag == 1 && sum > math.MaxInt32 {
			return math.MaxInt32
		}

	}

	return flag * sum
}

func main() {
	fmt.Println(myAtoi("-0012a42"))
}
