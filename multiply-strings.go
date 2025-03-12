package main

import (
	"fmt"
	"strings"
)

func multiply(num1 string, num2 string) string {
	if num1 == "0" || num2 == "0" {
		return "0"
	}

	n1, n2 := len(num1), len(num2)
	result := make([]int, n1+n2)

	for i := n1 - 1; i >= 0; i-- {
		for j := n2 - 1; j >= 0; j-- {
			mul := int(num1[i]-'0') * int(num2[j]-'0')
			sum := mul + result[i+j+1]

			result[i+j+1] = sum % 10
			result[i+j] += sum / 10
		}
	}

	var sb strings.Builder
	start := 0
	for start < len(result) && result[start] == 0 {
		start++
	}

	for ; start < len(result); start++ {
		sb.WriteByte(byte(result[start] + '0'))
	}

	return sb.String()
}

func main() {
	fmt.Print(multiply("333", "222"))
}
