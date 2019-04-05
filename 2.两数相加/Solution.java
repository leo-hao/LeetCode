 /**
 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
  */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 /**
 思路：通过链表的尾插法逆序插入数字，插入的顺序与输出的顺序相同
    r->next = s;
    r = s;
  */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;//进位
        ListNode L = new ListNode(-1);//头结点定义为负数
        ListNode r = L;//定义尾结点
        while(l1!=null||l2!=null){
            int sum=0;//两个数每一位相加的和
            if(l1!=null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum/10;
            ListNode node = new ListNode(sum%10);//新节点
            r.next = node; 
            r = node;
        }
        if(carry>0){
            ListNode node = new ListNode(carry);
            r.next = node;
            r = node;
        }
        return L.next;
    }
}