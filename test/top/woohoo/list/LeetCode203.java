package top.woohoo.list;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class LeetCode203 {

    private ListNode removeElementsWithRecursion(ListNode head, int val) {
        // 到达链表尾部
        if (head == null) {
            return null;
        }

        // 递归取值
        head.next = removeElementsWithRecursion(head.next, val);
        // 移除目标
        return head.val == val ? head.next : head;
    }

    public ListNode removeElements(ListNode head, int val) {
        // 确定新的头结点（如果头节点值是目标元素）
        while (head != null && head.val == val) {
            head = head.next;
        }

        // 遍历节点删除其余目标值
        ListNode previousNode = head;
        while (previousNode != null && previousNode.next != null) {
            ListNode currentNode = previousNode.next;
            if (currentNode.val == val) {
                previousNode.next = currentNode.next;
                currentNode.next = null;
            } else {
                previousNode = previousNode.next;
            }
        }

        return head;
    }

    public ListNode generateTestData(int confusionValue) {
        ListNode head = new ListNode(0);
        ListNode currentNode = head;
        for (int index = 1; index < 10; index++) {
            currentNode.next = new ListNode(index);
            currentNode = currentNode.next;
            if (index%3 == 0) {
                currentNode.next = new ListNode(confusionValue);
                currentNode = currentNode.next;
            }
        }
        return head;
    }

    public void show(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.print("NULL\n");
    }

    public static void main(String[] args) {
        LeetCode203 leetCode203 = new LeetCode203();

        final int confusionValue = 9;
        ListNode head = leetCode203.generateTestData(confusionValue);

        leetCode203.show(head);
        leetCode203.show(leetCode203.removeElementsWithRecursion(head, confusionValue));
    }
}