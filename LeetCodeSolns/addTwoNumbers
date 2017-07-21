/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseRecursive(l1, null);
        l2 = reverseRecursive(l2, null);
        displayList(l1);
        displayList(l2);
        boolean carry = false;
        ListNode l3 = null;
        while(l1 != null && l2 != null){
            int val = 0;
            if(carry == true){
                val = l1.val + l2.val + 1;
            }else{
                val = l1.val + l2.val;
            }
            if(val>9){
                carry = true;
                val = val - 10;
            }else{
                carry = false;
            }
            ListNode node = new ListNode(val);
            l3 = appendAtFront(l3, node);
            l1=l1.next;
            l2=l2.next;
            displayList(l3);
        }
        while(l1!= null) {
            int val = 0;
            if(carry == true){
                val = l1.val + 1;
            }else{
                val = l1.val;
            }
            if(val>9){
                carry = true;
                val = val - 10;
            }else{
                carry = false;
            }
            ListNode node = new ListNode(val);
            l3 = appendAtFront(l3, node);
            l1=l1.next;
        }
        while(l2!=null){
            int val = 0;
            if(carry == true){
                val = l2.val + 1;
            }else{
                val = l2.val;
            }
            if(val>9){
                carry = true;
                val = val - 10;
            }else{
                carry = false;
            }
            ListNode node = new ListNode(val);
            l3 = appendAtFront(l3, node);
            l2=l2.next;
        }
        if(carry == true){
            ListNode node = new ListNode(1);
            l3 = appendAtFront(l3, node);
        }
        return l3;
    }

    public ListNode appendAtFront(ListNode head, ListNode node){
        node.next = head;
        return node;
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
}