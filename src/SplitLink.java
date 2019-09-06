public class SplitLink {
    public void split(ListNode ln) {
        ListNode oddHead = null, oddTail = null;
        ListNode evenHead = null, evenTail = null;
        ListNode p = ln, pre = ln;
        while (p != null) {
            if (p.val % 2 == 0) {
                if (evenHead == null) {
                    evenHead = p;
                    evenTail = p;

                } else {
                    evenTail.next = p;
                    evenTail = p;
                }

            } else {
                if (oddHead == null) {
                    oddHead = p;
                    oddTail = p;
                } else {
                    oddTail.next = p;
                    oddTail = p;
                }
            }
            if (pre == p) {
                p = p.next;
                pre.next = null;
                pre = p;
            } else {
                pre.next = p.next;
                p.next = null;
                p = pre.next;
            }
        }
        while (oddHead != null) {
            System.out.print(oddHead.val + " ");
            oddHead = oddHead.next;
        }
        System.out.println();
        while (evenHead != null) {
            System.out.print(evenHead.val + " ");
            evenHead = evenHead.next;
        }
    }
}

class SplitLinkTest {
    public void test() {
        ListNode head = new ListNode(0);
        ListNode t1 = new ListNode(2);
        ListNode t2 = new ListNode(8);
        ListNode t3 = new ListNode(4);
        head.next = t1; t1.next = t2; t2.next = t3;
        new SplitLink().split(head);
    }
}