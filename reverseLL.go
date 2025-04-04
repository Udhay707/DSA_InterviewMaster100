package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func reverseList(head *ListNode) *ListNode {
	var prev *ListNode
	current := head

	for current != nil {
		next := current.Next
		current.Next = prev
		prev = current
		current = next
	}

	return prev
}

func main() {
	array := []int{1, 2, 3, 4, 5}
	head := &ListNode{}
	temp := head
	for _, val := range array {
		temp.Next = &ListNode{val, nil}
		temp = temp.Next
	}
	k := reverseList(head.Next)
	for k != nil {
		fmt.Print(k.Val)
		k = k.Next
	}
}
