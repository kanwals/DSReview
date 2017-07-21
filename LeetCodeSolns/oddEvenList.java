/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
            return head;
        if(head.next == null)
            return head;
        if(head.next.next == null)
            return head;
        ListNode first = head;
        ListNode second = head.next;
        ListNode even = second;

        while(first.next!=null && second.next!=null){
            first.next = second.next;
            second.next = first.next.next;
            first = first.next;
            second = second.next;
        }
        first.next = even;
        displayList(head);
        return head;
    }
    public void displayList(ListNode head){
        if (head == null) {
            System.out.println("The list is empty. Nothing to Display.");
        } else {
            System.out.println("The contents of the List are: ");
            ListNode n = head;
            while (n.next != null) {
                System.out.print(n.val + "\t");
                n = n.next;
            }
            System.out.println(n.val + "");
        }
    }
}