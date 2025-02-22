public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var returnObject = new ListNode(0);
        int carry =0;
        var temp = returnObject;
        int sum = 0;
        while(l1 != null || l2 != null || carry != 0){
            sum = (l1!=null ? l1.val : 0) + (l2!=null ? l2.val : 0) + carry;
            temp.next = new ListNode(sum%10);
            carry = sum/10;
            temp = temp.next;
            l1 = l1!= null ? l1.next:  l1;
            l2 = l2!= null ? l2.next : l2;
        }
        return returnObject.next;
    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
