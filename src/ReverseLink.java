public class ReverseLink {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode pre = newHead;
        ListNode p = pre.next;
        ListNode q = pre.next;

        for(int i = 1; i < k && q != null; i++) {
            q = q.next;
        }

        while(q != null) {
            pre = reverse(p, q, pre);
            p = pre.next;
            q = p;
            for(int i = 1; i < k && q != null; i++) {
                q = q.next;
            }
        }
        return newHead.next;
    }

    /*翻转以left为头节点，以right为尾节点的链表*/
    private ListNode reverse(ListNode left, ListNode right, ListNode pre) {
        ListNode q = right.next;
        if(left == right) {
            return left;
        }
        reverse(left.next, right, pre).next = left;
        left.next = q;
        pre.next = right;
        return left;         //返回尾节点
    }
}

class ReverseLinkTest {
    public void test() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b; b.next = c; c.next = d; d.next = e;

        ListNode reversedLink = new ReverseLink().reverseKGroup(a, 3);
        while(reversedLink != null) {
            System.out.print(reversedLink.val + " ");
            reversedLink = reversedLink.next;
        }
    }
}