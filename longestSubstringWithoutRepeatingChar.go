package main

import "fmt"

func lengthOfLongestSubstring(s string) int {
	tracker := make(map[rune]struct{})
	maxLength := 0
	r := []rune(s)
	for i, j := 0, 0; j < len(r); {
		if _, exist := tracker[r[j]]; exist {
			if r[i] == r[j] {
				i++
				j++
			} else {
				delete(tracker, r[i])
				i++
			}
		} else {
			tracker[r[j]] = struct{}{}
			maxLength = max(maxLength, j-i+1)
			j++
		}

	}
	return maxLength
}

func main() {
	s := "abcabcbb"
	fmt.Print(lengthOfLongestSubstring(s))
}
