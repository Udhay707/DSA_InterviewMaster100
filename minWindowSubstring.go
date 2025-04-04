package main

import "fmt"

func minWindow(s string, t string) string {
	tFreq := make(map[byte]int, 128)

	for index := range t {
		tFreq[t[index]]++
	}

	formed := 0
	needed := len(tFreq)

	minIndex := -1
	left := 0
	minLength := -1

	windowFreq := make(map[byte]int, 128)

	for right := 0; right < len(s); right++ {
		windowFreq[s[right]]++

		if val, exist := tFreq[s[right]]; exist && val == windowFreq[s[right]] {
			formed++
		}

		for formed == needed && left <= right {
			if minIndex == -1 || minLength > right-left+1 {
				minLength = right - left + 1
				minIndex = left
			}
			windowFreq[s[left]]--
			if val, exists := tFreq[s[left]]; exists && val > windowFreq[s[left]] {
				formed--
			}
			left++
		}
	}

	if minLength == -1 {
		return ""
	}
	return s[minIndex : minIndex+minLength]

}

func main() {
	s := "a"
	t := "aa"

	fmt.Println(minWindow(s, t))
}
