package main

import "fmt"

func checkInclusion(s1 string, s2 string) bool {
	var s1FreqMap [26]int32
	var s2FreqMap [26]int32

	if len(s1) > len(s2) {
		return false
	}

	s1Rune := []rune(s1)
	s2Rune := []rune(s2)

	for i := 0; i < len(s1Rune); i++ {
		s1FreqMap[s1Rune[i]-'a']++
		s2FreqMap[s2Rune[i]-'a']++
	}

	if s1FreqMap == s2FreqMap {
		return true
	}

	for i, j := 0, len(s1); j < len(s2); i, j = i+1, j+1 {

		s2FreqMap[s2Rune[i]-'a']--
		s2FreqMap[s2Rune[j]-'a']++
		if s1FreqMap == s2FreqMap {
			return true
		}
	}

	return false

}

func main() {
	s1 := "ab"
	s2 := "eidbaooo"

	fmt.Print(checkInclusion(s1, s2))
}
