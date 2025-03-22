package main

import (
	"fmt"
	"strconv"
)

func evalRPN(tokens []string) int {

	stack := make([]int, 0, len(tokens))

	for _, token := range tokens {
		switch token {
		case "+", "-", "*", "/":
			l := len(stack) - 1
			m := calculate(stack[l-1], stack[l], token)
			stack = stack[:l-1]
			stack = append(stack, m)
		default:
			num, _ := strconv.Atoi(token)
			stack = append(stack, num)
		}
	}

	return stack[0]

}

func calculate(num1, num2 int, operator string) int {

	switch operator {
	case "+":
		return num1 + num2
	case "-":
		return num1 - num2
	case "*":
		return num1 * num2
	case "/":
		return num1 / num2
	}

	return 0

}

func main() {
	k := evalRPN([]string{"4", "13", "5", "/", "+"})
	fmt.Println(k)
}
