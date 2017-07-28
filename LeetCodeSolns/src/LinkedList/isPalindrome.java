/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null)
            return true;
        if(head.next==null)
            return true;
        ListNode mid = getMiddleNode(head);
        ListNode otherHalf = mid.next;
        mid.next = null;
        //displayList(head);
        //displayList(otherHalf);
        otherHalf = reverseRecursive(otherHalf, null);

        while(head!=null && otherHalf!=null){
            if(head.val!=otherHalf.val)
                return false;
            head = head.next;
            otherHalf = otherHalf.next;
        }
        return true;
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