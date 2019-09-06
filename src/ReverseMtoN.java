public class ReverseMtoN {
    public void reverse(ListNode ln, int m, int n) {
        /*假设m < n且m,n一直有效*/
        int i = 0; ListNode p = ln, pre = new ListNode(999);
        pre.next = p;
        while (i < m && p != null) {
            p = p.next;
            pre = pre.next;

            i++;
        }
        System.out.println("m: " + p.val);
        System.out.println("pre: " + pre.val);
        while (i < n) {
            if (p.next != null) {
                ListNode temp = p.next;
                p.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;
            }
            i++;

        }
        ListNode result = m == 0 ? pre.next : ln;
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

class ReverseMtoNTest {
    public void test() {
        ListNode head = new ListNode(0);
        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(2);
        ListNode t3 = new ListNode(3);
        ListNode t4 = new ListNode(4);
        ListNode t5 = new ListNode(5);
        head.next = t1; t1.next = t2; t2.next = t3; t3.next = t4; t4.next =t5;
        new ReverseMtoN().reverse(head, 0,3);
    }

}