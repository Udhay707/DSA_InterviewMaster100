package main

import (
	"fmt"
	"slices"
)

type PosSpeed struct {
	position int
	speed    int
}

func carFleet(target int, position []int, speed []int) int {
	length := len(position)
	posSpeed := make([]PosSpeed, length)

	for i := 0; i < length; i++ {
		posSpeed[i] = PosSpeed{position[i], speed[i]}
	}
	slices.SortFunc(posSpeed, func(a, b PosSpeed) int {
		if b.position > a.position {
			return 1
		}
		if b.position == a.position {
			return 0
		}
		return -1
	})
	stack := make([]float64, 0, length)
	for _, member := range posSpeed {
		stackLength := len(stack)
		timeToReach := float64(target-member.position) / float64(member.speed)
		if stackLength == 0 || stack[stackLength-1] < timeToReach {
			stack = append(stack, timeToReach)
		}
	}
	return len(stack)
}

func main() {
	k := carFleet(12, []int{0, 8, 0, 5, 3}, []int{2, 4, 1, 1, 3})
	fmt.Println(k)
}
