public class ReverseLinkedList {
        private static ListNode returnNode = null;
        public static ListNode reverseList(ListNode head) {
            reverse(head);
            return returnNode;
        }
    
        static ListNode reverse(ListNode head){
            if(head == null || head.next == null){
                returnNode = head;
                return head;
            }
            ListNode node = reverse(head.next);
            node.next = head;
            head.next = null;
            return head;
        }

        public static void main(String[] args) {
            int []arr = {1,2,3,4,5};
            ListNode head = createLinkedList(arr);
            ListNode reverse = reverseList(head);
            while(reverse!=null){
                System.out.print(reverse.val+" ");
                reverse = reverse.next;
            }

        }

        private static ListNode createLinkedList(int[] array){
            ListNode head = new ListNode(array[0]);
            ListNode previous = head;
            for(int i=1; i<array.length ; i++){
                ListNode newNode = new ListNode(array[i]);
                previous.next = newNode;
                previous = newNode;
            }

            return head;
        }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}