/**
    给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 

 */
 /**
 思路:  
    维护了一个滑动窗口，窗口内的都是没有重复的字符，需要尽可能的扩大窗口的大小。由于窗口在不停向右滑动，所以只关心每个字符最后出现的位置，并建立映射。窗口的右边界就是当前遍历到的字符的位置，为了求出窗口的大小，我们需要一个变量leftRepeatPos来指向滑动窗口的左边界，这样，如果当前遍历到的字符从未出现过，那么直接扩大右边界，如果之前出现过，那么就分两种情况，在或不在滑动窗口内，如果不在滑动窗口内，那么就没事，当前字符可以加进来，如果在的话，就需要先在滑动窗口内去掉这个已经出现过的字符了，去掉的方法并不需要将左边leftRepeatPos一位一位向右遍历查找，由与HashMap已经保存了该重复字符最后出现的位置，所以直接移动leftRepeatPos指针就可以了。我们维护一个结果maxLen，每次用出现过的窗口大小来更新结果maxLen，就可以得到最终结.
  */
class Solution {
    public int lengthOfLongestSubstring(String s) {
		//初始化map
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0; i<s.length();++i){
 			    map.put(s.charAt(i), -1);
        }
        //最长无重复子串
        int maxLen = 0;
        //无重复子串左起点
        int leftRepeatPos = -1;
        for(int i=0; i<s.length();++i){
          //新的无重复子串左起点为 旧的左起点和字符上次出现位置 两者间较大的
           leftRepeatPos = Math.max(leftRepeatPos, map.get(s.charAt(i)));
           //为字符位置赋新值
           map.put(s.charAt(i), i);
           //比较出最长无重复子串
           maxLen = Math.max(maxLen, i - leftRepeatPos);
        }
       return maxLen;
    }
}