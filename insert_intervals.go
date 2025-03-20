package main

import "fmt"

func insert(intervals [][]int, newInterval []int) [][]int {
	newIntervals := [][]int{}
	toMonitor := newInterval[0]

	for i := 0; i < len(intervals); {
		if toMonitor >= intervals[i][0] && toMonitor <= intervals[i][1] {
			newIndex, newValue := findNext(newInterval[1], intervals, i)
			newIntervals = append(newIntervals, []int{intervals[i][0], newValue})
			i = newIndex
		} else {
			newIntervals = append(newIntervals, []int{intervals[i][0], intervals[i][1]})
			newInterval[0] = intervals[i][0]
		}
		i++
	}
	return newIntervals
}

func findNext(toMonitor int, intervals [][]int, index int) (int, int) {
	for index < len(intervals) {
		if toMonitor >= intervals[index][0] && toMonitor <= intervals[index][1] {
			return index, intervals[index][1]
		}
		index++
	}
	return index, toMonitor
}

func main() {
	intervals := [][]int{{1, 3}, {6, 9}}
	newInterval := []int{2, 5}
	k := insert(intervals, newInterval)
	fmt.Println(k) // Expected output: [[1, 5], [6, 9]]
}
