package main

import "fmt"

func romanToInt(s string) int {
	var romanToIntArr [91]int
	romanToIntArr['I'], romanToIntArr['V'], romanToIntArr['X'] = 1, 5, 10
	romanToIntArr['L'], romanToIntArr['C'], romanToIntArr['D'], romanToIntArr['M'] = 50, 100, 500, 1000

	sum := 0
	length := len(s)

	for i := 0; i < length-1; i++ {
		if romanToIntArr[s[i]] < romanToIntArr[s[i+1]] {
			sum -= romanToIntArr[s[i]]
		} else {
			sum += romanToIntArr[s[i]]
		}
	}

	sum += romanToIntArr[s[length-1]]

	return sum

}

func main() {
	s := romanToInt("MCMXCIV")
	fmt.Println(s)
}
