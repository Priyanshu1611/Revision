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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {
            // If pA reaches end, jump to headB
            pA = (pA == null) ? headB : pA.next;

            // If pB reaches end, jump to headA
            pB = (pB == null) ? headA : pB.next;
        }

        // Either both null (no intersection), or intersection node
        return pA;
    }
}