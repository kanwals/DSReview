package LinkedList;

import java.util.Arrays;

/**
 *
 * @author Gurkanwal
 */
public class LinkedList {

    private Node head = null;

    public void appendToTail(int d) {
        Node end = new Node(d);
        if (head == null) {
            head = end;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = end;
        }
        System.out.println(d + " appended to the List's tail.");
    }

    public void deleteFromTail() {
        if (head == null) {
            System.out.println("Cannot delete from tail because there are no elements in the List. Underflow...");
        } else {
            Node n1 = head;
            Node n2 = head.next;
            if (n2 == null) {
                head = null;
                System.out.println("Last element deleted. Linked List is now empty.");
            } else {
                while (n2.next != null) {
                    n1 = n1.next;
                    n2 = n2.next;
                }
                n1.next = null;
                System.out.println("Last element deleted.");
            }
        }
    }

    public void appendToFront(int d) {
        Node start = new Node(d);
        if (head == null) {
            head = start;
        } else {
            Node n = head;
            start.next = n;
            head = start;
        }
        System.out.println(d + " appended to the List's front.");
    }

    public void deleteFromFront() {
        if (head == null) {
            System.out.println("Cannot delete from front because there are no elements in the List. Underflow...");
        } else {
            Node n1 = head;
            Node n2 = head.next;
            if (n2 == null) {
                head = null;
                System.out.println("First element deleted. Linked List is now empty.");
            } else {
                head = n2;
                System.out.println("First element deleted.");
            }
        }
    }

    public void appendArrayToFront(int[] a) {
        if (a.length == 0) {
            System.out.println("Length of array should be greater than zero.");
        } else {
            if (head == null) {
                head = new Node(a[0]);
                Node n = head;
                for (int i = 1; i < a.length; i++) {
                    Node p = new Node(a[i]);
                    n.next = p;
                    n = n.next;
                }
            } else {
                Node oldHead = head;
                Node newHead = new Node(a[0]);
                Node n = newHead;
                for (int i = 1; i < a.length; i++) {
                    Node p = new Node(a[i]);
                    n.next = p;
                    n = n.next;
                }
                n.next = oldHead;
                head = newHead;
            }
            System.out.println(Arrays.toString(a) + " appended to the List's front.");
        }
    }

    public void appendArrayToTail(int[] a) {
        if (a.length == 0) {
            System.out.println("Length of array should be greater than zero.");
        } else {
            if (head == null) {
                head = new Node(a[0]);
                Node n = head;
                for (int i = 1; i < a.length; i++) {
                    Node p = new Node(a[i]);
                    n.next = p;
                    n = n.next;
                }
            } else {
                Node n = head;
                while (n.next != null) {
                    n = n.next;
                }
                for (int i = 0; i < a.length; i++) {
                    Node p = new Node(a[i]);
                    n.next = p;
                    n = n.next;
                }
            }
            System.out.println(Arrays.toString(a) + " appended to the List's tail.");
        }
    }

    public void deleteFirstOccurrence(int num) {
        if (head == null) {
            System.out.println("List is empty. Cannot delete " + num);
        } else {
            Node n = head;
            if (n.data == num) {
                head = n.next;
                System.out.println("Number " + num + " found and deleted.");
            } else {
                while (n.next != null) {
                    if (n.next.data == num) {
                        n.next = n.next.next;
                        System.out.println("Number " + num + " found and deleted.");
                        break;
                    }
                    n = n.next;
                }
            }
        }
    }

    public void deleteAllOccurrences(int num) {
        if (head == null) {
            System.out.println("List is empty. Cannot delete " + num);
        } else {
            Node n = head;
            if (n.data == num) {
                head = n.next;
                System.out.println("Number " + num + " found and deleted.");
            }
            while (n.next != null) {
                if (n.next.data == num) {
                    n.next = n.next.next;
                    System.out.println("Number " + num + " found and deleted.");
                    if(n.next == null)
                        return;
                }
                n = n.next;
            }
        }
    }

    public void displayList() {
        if (head == null) {
            System.out.println("The list is empty. Nothing to Display.");
        } else {
            System.out.println("The contents of the List are: ");
            Node n = head;
            while (n.next != null) {
                System.out.print(n.data + "\t");
                n = n.next;
            }
            System.out.println(n.data + "");
        }
    }
    
    public void reverseIterative(){
        if(head == null || head.next == null){
            System.out.println("List reversed iteratively.");
            return;
        }
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }        
        head = prev;
        System.out.println("List reversed iteratively.");
    }
    
    public void reverseRecursive(){
        head = reverseUtil(head, null);
    }
    
    private Node reverseUtil(Node current, Node prev){
        if(current.next == null){
            head = current;
            current.next = prev;
            return null;
        }
        Node next = current.next;
        current.next = prev;
        reverseUtil(next, current);
        return head;
    }
    
    public void sort(){
        
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        int[] a = {1, 2, 3, 4, 5, 6};
        ll.appendArrayToFront(a);
        ll.displayList();
        ll.reverseRecursive();
        ll.displayList();
    }
}

class Node {

    Node next = null;
    int data;

    public Node(int d) {
        data = d;
    }
}
