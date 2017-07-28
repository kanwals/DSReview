/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//Can be implemented using HashMaps in a better way, however, I don't know their implementation too well right now. Will change to Hashmaps when I get to it.
public class Solution {
    public long getCount(ListNode head){
        long i=0;
        while(head!=null){
            head = head.next;
            ++i;
        }
        return i;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode A = headA;
        ListNode B = headB;

        long cntA = getCount(A);
        long cntB = getCount(B);

        long d = 0;
        if(cntA>=cntB){
            d = cntA-cntB;
            for(;d>0;d--){
                A = A.next;
            }
        }else{
            d = cntB-cntA;
            for(;d>0;d--){
                B = B.next;
            }
        }
        while(A!=null && B!=null){
            if(A==B)
                return A;
            A = A.next;
            B = B.next;
        }
        return null;
    }
}