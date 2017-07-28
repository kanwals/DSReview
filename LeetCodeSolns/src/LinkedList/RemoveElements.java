/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return head;
        while(head!=null){
            if(head.val == val)
                head = head.next;
            else
                break;
        }
        if(head == null)
            return head;
        ListNode prev = null;
        ListNode current = head;
        ListNode next = head.next;
        while(next!=null){
            if(current.val == val){
                prev.next = current.next;
                current = next;
                next = current.next;
            }else{
                prev = current;
                current = next;
                next = current.next;
            }
        }
        if(next == null && current.val == val){
            prev.next = next;
        }
        return head;
    }
}