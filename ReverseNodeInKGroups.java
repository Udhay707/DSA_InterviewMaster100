public class ReverseNodeInKGroups {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = head;
        ListNode returnPointer = null; //for pointing the return node
        ListNode prev = null;

        while(end != null){
            end = getLastNode(k, end);
            if(end == null)
                break;
            if(returnPointer == null)
                returnPointer = end;
            ListNode next = end.next; //for noting the next pointer
            reverse(start, next, null); //detach and reverse the linked list
            if(prev != null){
                prev.next = end; //attaching the reversed list with prev pointer
            }
            prev = start; //for noting the next pointer
            start = next; // for iteration
            end = next; // for iteration
        }
        if(prev.next == null){
            prev.next = start;
        }
        return returnPointer;

    }

    private ListNode getLastNode(int k, ListNode end){
        for(int i=0; i<k-1 && end != null; i++){
            end = end.next;
        }
        return end;
    }

    private void reverse(ListNode start, ListNode end, ListNode prev){
        if(start == end){
            return;
        }
        reverse(start.next, end, start);
        start.next = prev;
    }

    public static void main(String[] args) {
        ReverseNodeInKGroups reverseNodeInKGroups = new ReverseNodeInKGroups();
        var head = reverseNodeInKGroups.createLinkedList(new int[]{1,2,3,4,5});
        reverseNodeInKGroups.printLinkedList(head);
        head = reverseNodeInKGroups.reverseKGroup(head, 3);
        reverseNodeInKGroups.printLinkedList(head);

        
    }

    private ListNode createLinkedList(int[] array){
        ListNode head = new ListNode(array[0]);
        ListNode previous = head;
        for(int i=1; i<array.length ; i++){
            ListNode newNode = new ListNode(array[i]);
            previous.next = newNode;
            previous = newNode;
        }

        return head;
    }

    private void printLinkedList(ListNode head){
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
