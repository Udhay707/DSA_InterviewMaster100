package main

type Node struct {
	Val    int
	Next   *Node
	Random *Node
}

func copyRandomList(head *Node) *Node {

	copyMap := make(map[*Node]*Node)

	temp := head
	for temp != nil {
		copyMap[temp] = &Node{temp.Val, nil, nil}
		temp = temp.Next

	}

	temp = head

	for temp != nil {
		copyMap[temp].Next = copyMap[temp.Next]
		copyMap[temp].Random = copyMap[temp.Random]
		temp = temp.Next
	}

	return copyMap[head]
}
