/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SinglyLinkedList;

/**
 *
 * @author Administrator
 */
public class SinglyLinkedList {
    static Node head = null;
    
    public static void createLinkedList(int value)
    {
        Node newNode = new Node();
        newNode.data = value;
        newNode.next = head;
        head = newNode;
    }
    
    public static void printLinkedList()
    {
        Node node = head;
        while(node != null)
        {
            System.out.print(node.data + "   ");
            node = node.next;
        }
        
        System.out.println("");
    }
    
    private static Node merge(Node left, Node right)
    {
        Node result = null;
        if(left == null) return right;
        if(right == null) return left;
        if(left.data <= right.data)
        {
            result = left;
            result.next = merge(left.next, right);
        }
        else
        {
            result = right;
            result.next = merge(left, right.next);
        }
        
        return result;
    }
    
    public static Node mergeSort(Node head)
    {
        if(head == null || head.next == null)
            return head;
        Node middle = getMiddleNode(head);
        Node nextToMiddle = middle.next;
        middle.next = null;
        Node left = mergeSort(head);
        Node right = mergeSort(nextToMiddle);
        
        Node sortedNode = merge(left, right);
        return sortedNode;
    }
    
    private static Node getMiddleNode(Node head)
    {
        if(head == null) return head;
        Node fast = head.next;
        Node slow = head;
        while(fast != null)
        {
            fast = fast.next;
            if(fast != null)
            {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }
    
    public static void main(String[] args)
    {
        createLinkedList(5);
        createLinkedList(20);
        createLinkedList(4);
        createLinkedList(3);
        createLinkedList(30);
        createLinkedList(4);
        createLinkedList(25);
        
        printLinkedList();
        
        head = mergeSort(head);
        
        printLinkedList();
    }
}
