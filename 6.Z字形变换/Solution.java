/**
将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N

之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);

示例 1:

输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"

示例 2:

输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:

L     D     R
E   O E   I I
E C   I H   N
T     S     G


 */
 /**
解题思路：

    1.往下走numRows步
    2.往上走numRows-2步
    3.重复1，2直到字符串遍历结束
利用 StringBuilder 的 append（）方法，toString（）
    String 的 charAt（）方法
  */
class Solution {
   public String convert(String s, int numRows) {
    if (numRows < 2)
        return s;

    StringBuilder[] sbs = new StringBuilder[numRows];//创建 numRows 行的新数组
    for (int i = 0; i < numRows; i++)
        sbs[i] = new StringBuilder();

    int index = 0, len = s.length();
    while (index < len) {
        for (int row = 0; row < numRows && index < len; row++) // 往下走
            sbs[row].append(s.charAt(index++));
        for (int row = numRows - 2; row > 0 && index < len; row--) // 往上走
            sbs[row].append(s.charAt(index++));
        }

    for (int row = 1; row < numRows; row++)
        sbs[0].append(sbs[row]);//将所有的数组接到第 0 行上

    return sbs[0].toString();
}
}  