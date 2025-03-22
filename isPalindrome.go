package main

import (
	"fmt"
	"unicode"
)

func main() {
	s := "race a car"
	fmt.Println(isPalindrome(s))
}

func isPalindrome(s string) bool {
	r := []rune(s)
	i := 0
	j := len(r) - 1
	for i <= j {
		if !unicode.IsLetter(r[i]) && !unicode.IsDigit(r[i]) {
			i++
			continue
		}
		if !unicode.IsLetter(r[j]) && !unicode.IsDigit(r[j]) {
			j--
			continue
		}
		if unicode.ToLower(r[i]) != unicode.ToLower(r[j]) {
			return false
		}
		i++
		j--
	}
	fmt.Printf("i %s and j %s", i, j)
	return true
}
