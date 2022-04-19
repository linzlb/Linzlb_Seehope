package com.linzlb.juan.labuladong.coreroutine;

import com.linzlb.juan.labuladong.entry.ListNode;

/**
 * 反转链表
 * @author jiangwan.lin@tuya.com
 * @since 2022-04-18 6:17 下午 / V1.0
 */
public class ReverseList {


    /**
     * 迭代器处理
     * 过一遍这个 Linked List，边过边把这个 node 的 next 指针指向前面那个 node，直到过完全部。
     * 所以我们还需要一个变量来记录当前 node 的前一个 node，不妨设为 prev.
     * 同时呢，一旦我们把指针翻转过去，后面的那个 node 就丢了有木有！所以还需要有个额外的变量事先记录下后面的 node，设为 nxt，这样才不至于走丢～
     * @param head
     */
    private static ListNode iterator(ListNode head){
        //初始化指针
        ListNode prev = null;
        ListNode curr = head;
        //Step1.
        //翻转箭头：把 1 的 next 指针指向 NULL；这样子，同时我们也明确了，prev 的初始化应该是 NULL.
        //然后把这仨变量都移动到下一个位置
        //Step2.
        //翻转箭头：把 2 的 next 指针指向 1
        //Step3.
        //翻转箭头：把 3 的 next 指针指向 2，
        //...
        //so while 循环包含了 「翻转箭头」+「三人行」
        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev; // 翻转箭头
            prev = curr; //三人行，即往右挪动，自己变成上一个
            curr = prev; //三人行，下一个变成自己
        }
        return prev;
    }

    /**
     * 递归三大步骤： Base case + 拆解 + 组合
     * 总共有 n 个节点，那么总的时间就是 O(n).
     * 看递归树也很明显了，每一层也就用了点小变量，是 O(1)，所以总的空间共是 O(n).
     * @param head
     * @return
     */
    private static ListNode recursion(ListNode head){
        //1base case:
        //当只有一个 node，或者没有 node 了呗，也就是
        if (head == null || head.next ==null){
            return head;
        }
        //2拆解：
        //递归的拆解就是把大问题，分解成小一点点的问题，直到 base case 可以返回，进行第三步的组合。
        //3组合：
        //组合的意思是，假设我们能够拿到小问题的解，那么用小问题的解去构造大问题的解。
        //也就是 node1.next = node2，
        //然后把 2 指向 1：node2.next = node1
        //合起来就是：node1.next.next = node1
        ListNode newHead = recursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        recursion(node1);

    }
}
