package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func removeNthFromEnd(head *ListNode, n int) *ListNode {

	var dummy *ListNode = &ListNode{0, head}
	pointer2 := head
	for i := 0; i < n; i++ {
		pointer2 = pointer2.Next
	}

	pointer1 := dummy

	for pointer2 != nil {
		pointer1 = pointer1.Next
		pointer2 = pointer2.Next
	}

	pointer1.Next = pointer1.Next.Next
	return dummy.Next
}

func main() {

	var head *ListNode = &ListNode{}
	var temp = head
	for i := 0; i < 1; i++ {
		temp.Next = &ListNode{i + 1, nil}
		temp = temp.Next
	}

	head = removeNthFromEnd(head.Next, 1)

	for head != nil {
		fmt.Print(head.Val)
		head = head.Next
	}

}
