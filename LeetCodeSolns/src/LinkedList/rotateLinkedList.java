
// Definition for singly-linked list.
 public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class Solution {
    public ListNode findNthFromLast(ListNode head, int n){
        ListNode slow = head, fast = head;
        for(;n>0;n--){
            fast = fast.next;
        }
        if(fast == null)
            return fast;
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public int getCount(ListNode head){
        int i=0;
        while(head!=null){
            head = head.next;
            ++i;
        }
        return i;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k==0)
            return head;
        if(head.next == null)
            return head;
        if(getCount(head)<k){
            k=k%getCount(head);
        }
        if(k!=0){
            ListNode nodeK = findNthFromLast(head, k);
            if(nodeK == null)
                return head;
            ListNode newHead = nodeK.next;
            nodeK.next = null;
            ListNode toBeAppended = newHead;
            while(toBeAppended.next!=null){
                toBeAppended = toBeAppended.next;
            }
            toBeAppended.next = head;
            return newHead;
        }else{
            return head;
        }
    }
}