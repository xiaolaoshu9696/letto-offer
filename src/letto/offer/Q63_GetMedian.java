package letto.offer;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */

public class Q63_GetMedian {
    ArrayList<Integer> list = new ArrayList<>();

    public void Insert(Integer num) {
        list.add(num);
        list.sort(Comparator.comparingInt(Integer::intValue));
    }

    public Double GetMedian() {
        int length = list.size();
        if (length%2==1){
            return (double) list.get(length/2);
        }
        else return (double)(list.get(length/2) + list.get((length/2)-1))/2;
    }


}
