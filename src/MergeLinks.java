import java.util.List;

public class MergeLinks {
    /*合并k个排序链表，返回合并后的排序链表，分析和描述算法复杂度
    *
    *
    * */
    public ListNode mergeKLists(ListNode[] lists) {
        int finished = 0;
        /*统计lists中空链表的个数*/
        for(int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                finished ++;
            }
        }

        ListNode head = new ListNode(-1);
        ListNode tail = head;

        while (finished < lists.length) {
            int maxNodeIndex = getMinNodeIndex(lists);
            ListNode maxNode = lists[maxNodeIndex];
            tail.next = maxNode;
            tail = tail.next;

            lists[maxNodeIndex] = maxNode.next;
            if(lists[maxNodeIndex] == null) {
                finished ++;
                System.out.println("finished: " + finished);
            }

        }

        return head.next;
    }

    public int getMinNodeIndex(ListNode[] lists) {
        int minIndex = 0;
        /*找到第一个非空链表*/
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null) {
                minIndex = i;
                break;
            }
        }

        for(int i = minIndex + 1; i < lists.length; i++) {
            if(lists[i] != null && lists[i].val < lists[minIndex].val) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public void printLink(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val);
            if(listNode.next != null) {
                System.out.print("->");
            }
            listNode = listNode.next;
        }
    }

}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class MergeLinksTest {
    public void test(){
        ListNode listNode1_1 = new ListNode(1);
        ListNode listNode1_2 = new ListNode(4);
        ListNode listNode1_3 = new ListNode(5);

        listNode1_1.next = listNode1_2;
        listNode1_2.next = listNode1_3;
//        listNode1_3.next = null;

        ListNode listNode2_1 = new ListNode(1);
        ListNode listNode2_2 = new ListNode(3);
        ListNode listNode2_3 = new ListNode(4);

        listNode2_1.next = listNode2_2;
        listNode2_2.next = listNode2_3;
//        listNode2_3.next = null;

        ListNode listNode3_1 = new ListNode(2);
        ListNode listNode3_2 = new ListNode(6);

        listNode3_1.next = listNode3_2;
//        listNode3_2.next = null;

        MergeLinks mergeLinks = new MergeLinks();
//        mergeLinks.printLink(listNode1_1);

        ListNode[] lists = new ListNode[]{listNode1_1, listNode2_1, listNode3_1};


        mergeLinks.printLink(mergeLinks.mergeKLists(lists));
    }

}
