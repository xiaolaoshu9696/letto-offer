package letto.offer.leetcode;

import java.util.HashMap;

public class LRUCache {
    //采用哈希表和双端队列在O（1）的时间内完成操作
    class Node {
        public Node last;
        public Node next;
        public int val;

        public Node(int val) {
            this.val = val;
        }
    }
    class NodeDoubleLinkedList{
        Node head;
        Node tail;

        public NodeDoubleLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void addNode(Node node){
            if (node == null){
                return;
            }
            if (this.head == null) {
                this.head = node;
                this.tail = node;
            }else{
                this.tail.next = node;
                node.last = this.tail;
                this.tail = node;
            }
        }
        public void moveNodeToTail(Node node){
            if (this.tail==node) return;
            if (this.head==node){
                this.head = node.next;
                this.head.last = null;
            }
            else{
                node.last.next = node.next;
                node.next.last = node.last;
            }
            node.last = this.tail;
            node.next = null;
            this.tail.next = node;
            this.tail = node;
        }

        public Node removeHead(){
            if (this.head==null) return null;
            Node res = this.head;
            if (this.head==this.tail){
                this.head = null;
                this.tail = null;
            }else{
                this.head = res.next;
                res.next = null;
                this.head.last = null;
            }
            return res;
        }

    }
    private HashMap<Integer,Node> keyNodeMap;
    private HashMap<Node, Integer> nodeKeyMap;
    private NodeDoubleLinkedList nodeList;
    private int capacity;

    public LRUCache(int capacity) {
        this.keyNodeMap = new HashMap<>();
        this.nodeKeyMap = new HashMap<>();
        this.nodeList = new NodeDoubleLinkedList();
        this.capacity = capacity;

    }

    public int get(int key) {
        if (this.keyNodeMap.containsKey(key)){
            Node res = this.keyNodeMap.get(key);
            this.nodeList.moveNodeToTail(res);
            return res.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (this.keyNodeMap.containsKey(key)){
            Node node = this.keyNodeMap.get(key);
            node.val = value;
            this.nodeList.moveNodeToTail(node);
        }
        else{
            Node newNode = new Node(value);
            this.keyNodeMap.put(key,newNode);
            this.nodeKeyMap.put(newNode, key);
            this.nodeList.addNode(newNode);
            if (this.keyNodeMap.size()==this.capacity+1){
                Node removenode = this.nodeList.removeHead();
                int removekey = this.nodeKeyMap.get(removenode);
                this.nodeKeyMap.remove(removenode);
                this.keyNodeMap.remove(removekey);
            }
        }

    }

    public static void main(String[] args) {
          LRUCache obj = new LRUCache(1);
          obj.put(2,1);
          obj.get(2);
    }
}
