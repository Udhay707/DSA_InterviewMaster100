package main

func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
	mergedList := &ListNode{}
	temp := mergedList

	for ; list1 != nil && list2 != nil; temp = temp.Next {
		if list1.Val < list2.Val {
			temp.Next = &ListNode{list1.Val, nil}
			list1 = list1.Next
		} else {
			temp.Next = &ListNode{list2.Val, nil}
			list2 = list2.Next
		}
	}

	if list1 != nil {
		temp.Next = list1
	} else if list2 != nil {
		temp.Next = list2
	}
	return mergedList.Next

}
