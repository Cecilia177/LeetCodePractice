import java.util.Random;

public class CopyList {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null) {
            return null;
        }
        RandomListNode newList = new RandomListNode(pHead.label);
        RandomListNode p = pHead.next;
        RandomListNode q = newList;
        while(p != null) {
            RandomListNode node = new RandomListNode(p.label);
            q.next = node;
            q = node;
            p = p.next;
        }
        p = pHead; q = newList;
        while(p != null) {
            RandomListNode start1 = pHead;
            RandomListNode start2 = newList;
            while(start1 != p.random && start1 != null) {
                start1 = start1.next;
                start2 = start2.next;
            }

            q.random = start2;
            p = p.next;
            q = q.next;
        }
        return newList;
    }
}

class CopyListTest {
    public void test() {
        RandomListNode n1 = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(2);
        RandomListNode n3 = new RandomListNode(3);
        n1.next = n2; n2.next = n3; n1.random = n3; n2.random = n2; n3.random = n1;
        RandomListNode newList = new CopyList().Clone(n1);
        RandomListNode p  = newList;
        while(p != null) {
            System.out.println(p.label + " " + p.random.label);
            p = p.next;
        }
    }
}


class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}