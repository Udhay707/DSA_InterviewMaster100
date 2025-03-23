package main

import "fmt"

type KeyTime struct {
	Value string
	Time  int
}

type TimeMap struct {
	store map[string][]KeyTime
}

func Constructor2() TimeMap {
	return TimeMap{store: make(map[string][]KeyTime)}
}

func (this *TimeMap) Set(key string, value string, timestamp int) {
	if _, exists := this.store[key]; !exists {
		this.store[key] = make([]KeyTime, 0)
	}
	this.store[key] = append(this.store[key], KeyTime{value, timestamp})
}

func (this *TimeMap) Get(key string, timestamp int) string {
	timeMapSlice, exists := this.store[key]
	if !exists {
		return ""
	}
	end := len(timeMapSlice) - 1

	if end >= 0 && timestamp > timeMapSlice[end].Time {
		return timeMapSlice[end].Value
	}

	start := 0
	close := KeyTime{}

	for start <= end {
		mid := start + (end-start)/2

		if timeMapSlice[mid].Time <= timestamp {
			close = timeMapSlice[mid]
			start = mid + 1
		} else {
			end = mid - 1
		}
	}
	if close == (KeyTime{}) {
		return ""
	}

	return close.Value
}
func main() {
	fmt.Print("udhay")
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Set(key,value,timestamp);
 * param_2 := obj.Get(key,timestamp);
 */
