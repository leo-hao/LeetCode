/**
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"

 */
 /**
    动态规划：最优子结构，边界，状态转移公式，
    boolean[][]dp,其中dp[i][j]表示字符串第i到j是否为回文。
    若dp[i][j]为true ,并且dp[i+1][j-1]为true ,并且保证判断dp[i][j]的时候dp[i+1][j-1]已经判断，所以遍历采用i降序j升序的嵌套遍历的方式
  */
public class Solution {
    public String longestPalindrome(String s) {
        if(s.isEmpty()){
            return s;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int left = 0;
        int right = 0;
        for(int i = n-2; i >= 0; i--){
            dp[i][i] = true;
            for(int j = i+1; j < n; j++){
                //如果i,j位置的字符相同,且dp[i+1][j-1]为true ,则dp[i][j]为true
                dp[i][j] = s.charAt(i) == s.charAt(j)&&(j-i < 3||dp[i+1][j-1]);//小于3是因为aba一定是回文
                //更新最长回文子串的边界
                if(dp[i][j]&&right-left<j-i){
                    left = i;
                    right = j;
                }
            }
        }
        //[left,right+1)
        return s.substring(left,right+1);
    }
}