/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        if(l2==null)
            return l1;
        if(l1==null)
            return l2;
        if(l1.val<=l2.val){
            result = l1;
            result.next = mergeTwoLists(l1.next, l2);
        }else{
            result = l2;
            result.next = mergeTwoLists(l1, l2.next);
        }
        return result;
    }
    public ListNode appendAtFront(ListNode head, ListNode node){
        node.next=head;
        return node;
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
    public ListNode mergeSort(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode mid = getMiddleNode(head);
        ListNode otherHalf = mid.next;
        mid.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(otherHalf);
        return mergeTwoLists(left,right);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        ListNode singleElementsClubbed = null;
        for(int i=1;i<lists.length;i++){
            if(lists[i]!=null){
                if(lists[i].next == null){
                    ListNode element = new ListNode(lists[i].val);
                    singleElementsClubbed = appendAtFront(singleElementsClubbed, element);
                }else{
                    lists[0] = mergeTwoLists(lists[0],lists[i]);
                    lists[i] = null;
                }
            }
        }
        lists[0] = mergeTwoLists(lists[0],mergeSort(singleElementsClubbed));
        return lists[0];
    }
}