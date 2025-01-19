import java.util.HashMap;
import java.util.Map;


public class CopyLinkedListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Map<Node, Node> actualCreated = new HashMap<>();
        Node temp = head;
        Node newNode = new Node(0);
        Node newTempNode = newNode;
        while(temp != null){
            newTempNode.next = new Node(temp.val);
            actualCreated.put(temp, newTempNode.next);
            temp = temp.next;
            newTempNode = newTempNode.next;
        }
        newTempNode = newNode.next;
        temp = head;
        while(temp != null){
            newTempNode.random = actualCreated.get(temp.random);
            newTempNode = newTempNode.next;
            temp = temp.next;
        }
        return  newNode.next;
    }

    public static void main(String[] args) {
        var node2 = new Node(2);
        node2.next = null;
        node2.random = node2;
        var node1 = new Node(1);
        node1.next = node2;
        node1.random = node2;
        CopyLinkedListWithRandomPointer copyLinkedListWithRandomPointer = new CopyLinkedListWithRandomPointer();
        var returnNode = copyLinkedListWithRandomPointer.copyRandomList(node1);
        System.out.println(returnNode);
    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
