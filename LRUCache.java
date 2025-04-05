import java.util.HashMap;
import java.util.Map;

public class LRUCache{
    private class Node{
        private int key;
        private int value;
        private Node prev;
        private Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next  = null;
        }
    }

    private int capacity;
    private Map<Integer, Node> cache;
    private LRUCache.Node start;
    private LRUCache.Node end;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        start = new LRUCache.Node(0, 0);
        end = new LRUCache.Node(0, 0);
        start.next = end;
        end.prev = start;

    }

    private void appendAtEnd(Node node){
        var currentLast = end.prev;
        currentLast.next = node;
        node.prev = currentLast;
        node.next = end;
        end.prev = node;
    }

    private void removeNode(Node node){
        var prevNode = node.prev;
        var nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        Node currentNode = cache.get(key);
        if(currentNode != end.prev){
            removeNode(currentNode);
            appendAtEnd(currentNode);
        }
        return currentNode.value;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            var node = cache.get(key);
            removeNode(node);
            appendAtEnd(node);
            node.value = value;
            return;
        }
        if(capacity <= cache.size()){
            var removeNode = start.next;
            cache.remove(removeNode.key);
            removeNode(removeNode);
        }
        Node node = new Node(key, value);
        appendAtEnd(node);
        cache.put(key, node);
        
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        System.out.println(lruCache.get(2));
        lruCache.put(2,6);
        System.out.println(lruCache.get(1));
        lruCache.put(1, 5);
        lruCache.put(1, 2);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }
}