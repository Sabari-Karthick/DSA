package com.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * 
 * 
 * https://leetcode.com/problems/all-oone-data-structure
 * 
 * One approach uses is to help the main hash-map to keep track of the arranged keys by using a doubly linked list
 * 
 * 
 */
public class AllOoneDS { 
	public static void main(String []args) {
   // TODO document why this method is empty
 }
}

class AllOne {

    class Node {
        int count;
        Set<String> keys;
        Node prev, next;

        Node(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }
    }

    private Map<String, Integer> keyMap;
    private Map<Integer, Node> countMap;
    Node head, tail;

    public AllOne() {
        this.keyMap = new HashMap<>();
        this.countMap = new HashMap<>();
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    public void inc(String key) {
        int count = keyMap.getOrDefault(key, 0);
        keyMap.put(key, count + 1);
        if (count > 0)
            removeFromCountMap(key, count);
        addToCountMap(key, count + 1);

    }

    private void removeFromCountMap(String key, int count) {
        Node node = countMap.get(count);
        node.keys.remove(key);
        if (node.keys.isEmpty()) {
            removeNode(node);
            countMap.remove(count);
        }

    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToCountMap(String key, int count) {
        Node node = countMap.get(count);
        if (node == null) {
            node = new Node(count);
            countMap.put(count, node);
            Node prevNode = countMap.get(count - 1);
            if (prevNode != null) {
                // Insert after the existing node for count - 1
                insertNodeAfter(prevNode, node);
            } else {
                // If no previous node exists, it should be inserted after head
                // Check if there is a next node that has a higher count
                Node current = head.next;
                while (current != tail && current.count < count) {
                    current = current.next;
                }
                // Insert before the current node
                insertNodeBefore(current, node);
            }
        }
        node.keys.add(key);
    }

    private void insertNodeBefore(Node currentNode, Node newNode) {
        newNode.prev = currentNode.prev;
        newNode.next = currentNode;
        currentNode.prev.next = newNode;
        currentNode.prev = newNode;
    }

    private void insertNodeAfter(Node prevNode, Node currentNode) {
        currentNode.prev = prevNode;
        currentNode.next = prevNode.next;
        prevNode.next.prev = currentNode;
        prevNode.next = currentNode;
    }

    public void dec(String key) {
        if (!keyMap.containsKey(key))
            return;

        int count = keyMap.get(key);
        if (count == 1) {
            keyMap.remove(key);
        } else {
            keyMap.put(key, count - 1);
        }

        removeFromCountMap(key, count);
        if (count > 1) {
            addToCountMap(key, count - 1);
        }

    }

    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
