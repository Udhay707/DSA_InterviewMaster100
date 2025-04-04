package main

import "fmt"

func characterReplacement(s string, k int) int {
	var (
		maxFreq, left, result int
		characterMap          [26]int
	)

	for right := range s {
		characterMap[s[right]-'A']++
		maxFreq = max(characterMap[s[right]-'A'], maxFreq)

		if right-left+1 > maxFreq+k {
			characterMap[s[left]-'A']--
			left++
		}

		result = right - left + 1
		//result track the current window size and is always valid, because window size even after shrink is = maxFreq + k
	}
	return result
}

func main() {
	s := "AABBBBA"
	k := 2
	fmt.Println(characterReplacement(s, k))

}
