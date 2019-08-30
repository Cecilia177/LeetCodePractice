public class SendPresents {
    private int remain;
    public int LastRemaining_Solution(int n, int m) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        for(int i = 0; i < n; i++) {
            ListNode l = new ListNode(i);
            if(i == 0) {
                head = l;
                tail = l;
            } else {
                tail.next = l;
                tail = tail.next;
            }
        }
        tail.next = head;
        ListNode p = head; ListNode pre = tail;
        int remain = n;
        while(remain > 1) {
            int index = m % remain == 0 ? remain : m % remain;
            while(index > 1) {
                pre = p;
                p = p.next;
                index--;
            }
            pre.next = p.next;
            p.next = null;
            System.out.println("remove: " + p.val);
            p = pre.next;
            remain --;
        }
        return p.val;
    }
}
