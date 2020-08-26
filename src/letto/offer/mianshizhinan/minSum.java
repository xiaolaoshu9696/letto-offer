package letto.offer.mianshizhinan;

import java.util.Scanner;

/**
 * 数组小和的定义如下：
 * 例如，数组s = [1, 3, 5, 2, 4, 6]，在s[0]的左边小于或等于s[0]的数的和为0；在s[1]的左边小于或等于s[1]的数的和为1；在s[2]的左边小于或等于s[2]的数的和为1+3=4；在s[3]的左边小于或等于s[3]的数的和为1；
 * 在s[4]的左边小于或等于s[4]的数的和为1+3+2=6；在s[5]的左边小于或等于s[5]的数的和为1+3+5+2+4=15。所以s的小和为0+1+4+1+6+15=27
 * 给定一个数组s，实现函数返回s的小和
 * [要求]
 * 时间复杂度为O(nlogn)O(nlogn)，空间复杂度为O(n)O(n)
 */
public class minSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println((int)MinSum(arr));
    }

    private static double MinSum(int[] arr){
        return MergeSort(arr,0,arr.length-1);
    }

    private static int MergeSort(int[] arr, int start, int end){
        if (start == end) return 0;

        int mid = (start+end)/2;
        return  MergeSort(arr, start, mid)  + MergeSort(arr, mid+1, end) + Merge(arr,start,mid,end);

    }

    private static int Merge(int[] arr, int start, int mid, int end){
        int minsum = 0;
        int[] temp = new int[arr.length];
        int p1 = start, p2 = mid+1, k = start;
        while (p1 <= mid && p2 <= end){
            if (arr[p1]<=arr[p2]){
                temp[k] = arr[p1];
                minsum +=arr[p1]*(end-p2+1);
                k++;
                p1++;

            }
            else{
                temp[k++] = arr[p2++];
            }
        }
        while (p1<=mid){
            temp[k++] = arr[p1++];
        }
        while (p2<=end){
            temp[k++] = arr[p2++];
        }
        for (int i = start; i<=end; i++){
            arr[i] = temp[i];
        }
        return minsum;
    }
}
