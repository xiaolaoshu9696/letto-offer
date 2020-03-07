package letto.offer;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

/**
 *
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */

//思路 初始取前k个数构造最大堆，然后依次遍历，如果比堆顶小则入堆，删除堆顶
public class Q29_GetLeastNumbers_Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int length = input.length;
        if (k>length||k==0){
            return result;
        }
        //重写比较器使其是最大的先被poll出。
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i<length; i++){
            if (maxHeap.size()!=k){
                maxHeap.offer(input[i]);
            }
            else if (maxHeap.peek()>input[i]){
                Integer temp = maxHeap.poll();
                temp = null;
                maxHeap.offer(input[i]);
            }
        }

        result.addAll(maxHeap);
        return result;

    }

}
