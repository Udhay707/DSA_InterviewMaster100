package main

import (
	"fmt"
	"strconv"
	"strings"
)

func countAndSay(n int) string {
	if n == 1 {
		return "1"
	}
	var toCount = []rune(countAndSay(n - 1))
	var prev rune = toCount[0]
	var frequency int = 1
	var ans strings.Builder
	i := 1
	for i < len(toCount) {
		if prev == toCount[i] {
			frequency++
		} else {
			ans.WriteString(strconv.Itoa(frequency))
			ans.WriteRune(prev)
			frequency = 1
			prev = toCount[i]
		}
		i++
	}
	ans.WriteString(strconv.Itoa(frequency))
	ans.WriteRune(prev)
	return ans.String()

}

func main() {
	k := countAndSay(4)
	fmt.Println(k)
}
