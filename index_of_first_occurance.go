package main

import "fmt"

func strStr(haystack string, needle string) int {
	if len(haystack) == len(needle) && haystack == needle {
		return 0
	}

	for i := 0; i < len(haystack); i++ {
		if needle[0] == haystack[i] && (len(needle) == 1 ||
			i+len(needle) <= len(haystack) &&
				needle == haystack[i:i+len(needle)]) {
			return i
		}
	}
	return -1
}

func main() {
	haystack, needle := "mississippi", "pi"
	fmt.Println(strStr(haystack, needle))
}
