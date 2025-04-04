class ReorderList{
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public void reorderList(ListNode head) {

        var fastPointer = head;
        var slowPointer = head;
        while(fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
       var list2 = reverse(slowPointer.next);
       slowPointer.next = null;


        var list1 = head;

        while(list1 != null && list2 != null){
            var next1 = list1.next;
            var next2 = list2.next;
            list1.next = list2;
            list2.next = next1;
            list2 = next2;
            list1 = next1;
        }
        
    }

    private ListNode reverse(ListNode node){
        ListNode prev = null;

        while(node != null){
            var front = node.next;
            node.next = prev;
            prev = node;
            node = front;
        }
        return prev;

    }

    public static void main(String[] args) {
        ReorderList reorderList = new ReorderList();
        ListNode head = reorderList.new ListNode();
        var pointer = head;
        for(int i=1; i<5; i++, pointer = pointer.next){
            pointer.next  = reorderList.new ListNode(i);
        }

        reorderList.reorderList(head.next);

        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}