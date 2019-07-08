public class Adding {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode p = l1;
        ListNode q = l2;
        ListNode merged = new ListNode(0);
        ListNode k = merged;
        int remain = 0;
        while(p != null && q != null) {

            ListNode temp = new ListNode((p.val + q.val + remain) % 10);
            System.out.println("temp: " + temp.val);

            remain = (p.val + q.val + remain) / 10;
            System.out.println("remain: " + remain);
            k.next = temp;
            k = temp;
            p = p.next;
            q = q.next;
        }

        while (p != null) {

            ListNode temp = new ListNode((p.val + remain) % 10);
            remain = (p.val + remain) / 10;
            k.next = temp;
            k = temp;
            p = p.next;
        }
        while (q != null) {

            ListNode temp = new ListNode((q.val + remain) % 10);
            remain = (q.val + remain) / 10;
            k.next = temp;
            k = temp;
            q = q.next;
        }
        if(remain != 0) {
            ListNode temp = new ListNode(remain);
            k.next = temp;
        }

        return merged.next;
    }
}

class AddingTest {
    public void test() {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(8);
        ListNode l3 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(6);
//        ListNode l5 = new ListNode(6);
//        ListNode l6 = new ListNode(4);
//        l5.next = l6;
//        l4.next = l5;

        Adding adding = new Adding();
        ListNode l = adding.addTwoNumbers(l1, l4);
        while(l != null) {
            System.out.print(l.val);
            l = l.next;
        }
    }
}
