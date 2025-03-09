package main

import "fmt"

func isMatch(s string, p string) bool {
	memo := make([][]*bool, len(s)+1)
	for i := 0; i <= len(s); i++ {
		memo[i] = make([]*bool, len(p))
	}
	return checkForMatch([]rune(s), []rune(p), 0, 0, memo)
}

func checkForMatch(s []rune, p []rune, sIndex int, pIndex int, memo [][]*bool) bool {
	if sIndex == len(s) && pIndex == len(p) {
		return true
	}

	if pIndex >= len(p) {
		return false
	}

	if memo[sIndex][pIndex] != nil {
		return *memo[sIndex][pIndex]
	}

	isSame := sIndex < len(s) && (s[sIndex] == p[pIndex] || p[pIndex] == '.')
	isNextStar := pIndex+1 < len(p) && p[pIndex+1] == '*'
	var isMatch = false
	if isSame && isNextStar {
		isMatch = checkForMatch(s, p, sIndex, pIndex+2, memo) || checkForMatch(s, p, sIndex+1, pIndex, memo)

	} else if isSame && !isNextStar {
		isMatch = checkForMatch(s, p, sIndex+1, pIndex+1, memo)

	} else if !isSame && isNextStar {
		isMatch = checkForMatch(s, p, sIndex, pIndex+2, memo)
	} else {
		isMatch = false
	}
	memo[sIndex][pIndex] = &isMatch
	return *memo[sIndex][pIndex]
}

func main() {
	s := "ab"
	p := ".*"
	fmt.Println(isMatch(s, p))
}
