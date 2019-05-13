/**
题目：https://leetcode-cn.com/problems/palindrome-number/
思路：所有负数不可能是回文，所有末尾是 0 的数字不可能是回文（除了 0）
    将后半部分反转直至大于前半部分，两者相比较
    1.相等或 后半部分/10后相等
    2.不等
 */
 class Solution {
    public boolean isPalindrome(int x) {
        if(x<0 || (x%10==0 && x!=0))
            return false;
        int p = 0;
        while(x>p){
            p = p*10 + x%10;
            x/=10;
        }
        if(x==p||p/10==x)
            return true;
        return false;
    }
}