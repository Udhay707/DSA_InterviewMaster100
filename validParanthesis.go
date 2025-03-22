package main

import "fmt"

func isValid(s string) bool {
	if len(s)%2 != 0 {
		return false
	}
	matchMap := map[rune]rune{']': '[', ')': '(', '}': '{'}
	stack := make([]rune, 0)

	r := []rune(s)
	for _, character := range r {
		switch character {
		case '(', '[', '{':
			stack = append(stack, character)
		default:
			if len(stack) == 0 || stack[len(stack)-1] != matchMap[character] {
				return false
			}
			stack = stack[:len(stack)-1]
		}
	}
	if len(stack) > 0 {
		return false
	}
	return true

}

func main() {
	fmt.Println(isValid("()[]{}"))
}
