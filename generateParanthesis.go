package main

import "fmt"

func main() {
	fmt.Println(generateParenthesis(3))
}

func generateParenthesis(n int) []string {
	result := make([]string, 0)
	dfs(&result, 0, 0, "", n)
	return result
}

func dfs(result *[]string, left, right int, formattedString string, n int) {
	if left == right && left == n {
		*result = append(*result, formattedString)
	}
	if left < n {
		dfs(result, left+1, right, formattedString+"(", n)
	}
	if right < left {
		dfs(result, left, right+1, formattedString+")", n)
	}
}
