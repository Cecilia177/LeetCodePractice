public class LinkCalculation {
    public ListNode calculate(ListNode l1, ListNode l2, char operation) {
        ListNode n1 = reverseLink(l1);
        ListNode n2 = reverseLink(l2);
        ListNode p = n1, q = n2;
        int value = 0; int temp = 0;
        ListNode head = null, tail = null;

        while (p != null && q != null) {
            if (operation == '+') {
                temp = (p.val + q.val + temp) / 10;
                value = (p.val + q.val + temp) % 10;
            } else {
                temp = (temp + p.val) > q.val ? 0 : -1;
                value = (temp + p.val) > q.val ? temp + p.val - q.val : temp + p.val + 10 - p.val;
            }

            ListNode r = new ListNode(value);
            if (head == null) {
                head = r;
                tail = r;
            } else {
                tail.next = r;
                tail = tail.next;
            }
            p = p.next;
            q = q.next;
        }
        return head;

    }

    private ListNode reverseLink(ListNode l) {
        ListNode head = null, tail = null, temp = null;
        while (l != null) {
            temp = l;
            l = l.next;
            temp.next = null;
            if (head == null) {
                head = temp;
                tail = temp;
            } else {
                tail.next = temp;
                tail = tail.next;
            }
        }
        return head;
    }
}
