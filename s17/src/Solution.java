public class Solution {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

//    public void deleteNode(ListNode node) {
//        while (node.next.next != null) {
//            node.val = node.next.val;
//            node = node.next;
//        }
//
//        node.val = node.next.val;
//        node.next = null;
//    }


}
