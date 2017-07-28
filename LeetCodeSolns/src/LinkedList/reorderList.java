/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode getMiddleNode(ListNode head){
        if(head == null)
            return head;
        if(head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public ListNode reverseRecursive(ListNode current, ListNode prev){
        if(current.next == null){
            ListNode head = current;
            current.next = prev;
            return head;
        }

        ListNode next = current.next;
        current.next = prev;

        return reverseRecursive(next, current);
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
    public ListNode reorderList(ListNode head) {
        if(head == null)
            return head;
        if(head.next == null){
            return head;
        }
        if(head.next.next == null){
            return head;
        }
        ListNode start1 = head;
        ListNode mid = getMiddleNode(head);
        ListNode start2 = reverseRecursive(mid.next, null);
        mid.next = null;

        ListNode temp1;
        ListNode temp2;
        // displayList(start1);
        // displayList(start2);
        while(start1!=null && start2!=null){
            temp1 = start1.next;
            temp2 = start2.next;

            start1.next = start2;
            start2.next = temp1;

            start1 = temp1;
            start2 = temp2;
        }
        return head;

    }
}