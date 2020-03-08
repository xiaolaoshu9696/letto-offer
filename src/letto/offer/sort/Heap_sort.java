package letto.offer.sort;

import java.util.Arrays;

/**
 *
 * 堆排序
 * 把序列构造成大顶堆，
 * 将根节点和最后一个节点交换，然后断开最后一个节点
 * 重复1，2，直到所有节点断开
 */
public class Heap_sort {

    public static void main(String[] args) {
        int[] nums = {4,11,2,5,78,33,33,45,67};
        HeapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void HeapSort(int[] nums){
        int l = nums.length;
        //开始建堆
        for (int i =0; i<l-1; i++){
            buildMaxHeap(nums, l-1-i);
            //交换堆顶和最后一个元素
            swap(nums, 0, l-1-i);
//            System.out.println(Arrays.toString(nums));

        }
    }

    private static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private  static void buildMaxHeap(int[] data, int lastIndex){
        //从lastindex处节点的父节点开始
        for (int i = (lastIndex-1)/2; i>=0;i--){
            //k保存正在判断的节点
            int k = i;
            //如果当前k节点的子节点存在
            while(k*2+1<=lastIndex){
                // k节点的左子节点
                int biggerIndex = 2*k+1;
                // 如果小于它则表示右子节点存在，lastindex就是右子节点
                if (biggerIndex<lastIndex){
                    if (data[biggerIndex]<data[biggerIndex+1]){
                        //biggerIndex总是保存较大结点的索引
                        biggerIndex++;
                    }
                }
                // 如果子节点比父节点大，则交换
                if (data[k]<data[biggerIndex]){
                    swap(data, k, biggerIndex);
                    k = biggerIndex;
                }
                else break;
            }


        }

    }



}
