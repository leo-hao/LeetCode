/**
给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5

 */
 /**
    合并两个有序数组,重新排序
    中位数为:mid = (s[(len-1)/2] +s[len/2])/2.0
  */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //创建一个新的数组合并原来的两个数组
        int[] a=new int[nums1.length+nums2.length];
        int sum=nums1.length+nums2.length;

        double mid;
        for(int i=0;i<nums1.length;i++) {
            a[i]=nums1[i];
        }
        for(int i=0;i<nums2.length;i++) {
            a[nums1.length+i]=nums2[i];
        }
        //排序
        Arrays.sort(a);
    
        mid=(double)((a[(sum-1)/2]+a[sum/2])/2.0);
        return mid;

    }
}