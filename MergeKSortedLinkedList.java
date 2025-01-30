public class MergeKSortedLinkedList {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return splitAndMerge(lists, 0, lists.length-1);
        
    }

    private ListNode splitAndMerge(ListNode[] lists, int start, int end){
        if(start == end)
            return lists[start];
        int mid = start + (end-start) / 2;
        ListNode left = splitAndMerge(lists, start, mid);
        ListNode right = splitAndMerge(lists, mid+1, end);
        return mergeLists(left, right);

    }

    private ListNode mergeLists(ListNode left, ListNode right){
        ListNode head = new ListNode();
        ListNode temp = head;
        while(left != null && right != null){
            if(left.val < right.val){
                temp.next= new ListNode(left.val);
                left = left.next;
            } else{
                temp.next = new ListNode(right.val);
                right = right.next;
            }
            temp = temp.next;
        }
        while(left != null){
            temp.next = new ListNode(left.val);
            left = left.next;
            temp = temp.next;
        }
        while(right != null){
            temp.next = new ListNode(right.val);
            right = right.next;
            temp = temp.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        int[][] arrays = {{1,4,5},{1,3,4},{2,6}};
        MergeKSortedLinkedList mergeKSortedLinkedList = new MergeKSortedLinkedList();
        ListNode[] listNodes = mergeKSortedLinkedList.createListNodesFromArrays(arrays);
        for(ListNode listNode : listNodes){
            mergeKSortedLinkedList.printListNodes(listNode);
        } 
        var listNode = mergeKSortedLinkedList.mergeKLists(listNodes);
        mergeKSortedLinkedList.printListNodes(listNode);
    }

    private void printListNodes(ListNode listNode){
        while(listNode != null){
            System.out.print(listNode.val+" ");
            listNode = listNode.next;
        }
        System.out.println("");
    }

    private ListNode[] createListNodesFromArrays(int[] ... arrays){
        ListNode []listNodes = new ListNode[arrays.length];
        for(int len=0; len<arrays.length; len++){
            listNodes[len] = new ListNode();
            ListNode temp = listNodes[len];
            for(int i=0; i<arrays[len].length; i++){
                temp.next = new ListNode(arrays[len][i]);
                temp = temp.next;
            }
            listNodes[len] = listNodes[len].next;
        }
        return listNodes;
    }
    
}



 