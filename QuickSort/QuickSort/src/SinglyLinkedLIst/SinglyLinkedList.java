/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SinglyLinkedLIst;

/**
 *
 * @author Administrator
 */
public class SinglyLinkedList {
    
    static Node head = null, newHead = null, newTail = null;
    
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
    
    public static Node getTail(Node node)
    {
        while(node != null && node.next != null)
        {
            node = node.next;
        }
        return node;
    }
    
    public static Node partition(Node head, Node end)
    {
        Node pivot = end, prev = null, cur = head, tail = end;
        while(cur != null && cur != pivot)
        {
            if(cur .data < pivot.data)
            {
                if(newHead == null)
                    newHead = cur;
                prev = cur;
                cur = cur.next;
            }
            else
            {
                if(prev != null)
                    prev.next = cur.next;
                Node temp = cur.next;
                cur.next = null;
                tail.next = cur;
                tail = cur;
                cur = temp;
            }
        }
        
        if(newHead == null)
            newHead = pivot;
        newTail = tail;
        return pivot;
    }
    
    public static Node sort(Node head, Node end)
    {
        if(head == null || head == end) return head;
        Node newHeadTemp = null, newTailTemp = null;
        newHead = newTail = null;
        Node pivot = partition(head, end);
        newHeadTemp = newHead;
        newTailTemp = newTail;
        if(newHeadTemp != pivot)
        {
            Node temp = newHeadTemp;
            while(temp.next != pivot)
                temp = temp.next;
            temp.next = null;
            newHeadTemp = sort(newHeadTemp, temp);
            
            temp = getTail(newHeadTemp);
            temp.next = pivot;
        }
        pivot.next = sort(pivot.next, newTailTemp);
        return newHeadTemp;
    }
    
    public static void quickSort()
    {
        head = sort(head, getTail(head));
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
        
        quickSort();
        
        printLinkedList();
    }
}
