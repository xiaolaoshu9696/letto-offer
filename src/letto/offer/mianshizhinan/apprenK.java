package letto.offer.mianshizhinan;
import java.util.*;

class mapitem{
    String key;
    int val;
    public mapitem(String key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class apprenK {
    static Map<String, Integer> map = new HashMap<>();

    //构建最小堆，比堆顶大入堆，堆顶出堆。
    //重写比较器使其是最小的先被poll出。
    static PriorityQueue<mapitem> minHeap = new PriorityQueue<mapitem>(new Comparator<mapitem>() {
        @Override
        public int compare(mapitem o1, mapitem o2) {
            if (o1.val!=o2.val){
                return o1.val-o2.val;
            }
            return o2.key.compareTo(o1.key);
        }
    });

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int k = scanner.nextInt();
        String[] a = new String[N];
        for (int i = 0; i < N; i++) {
            String s = scanner.next();
            map.put(s,map.getOrDefault(s,0)+1);
        }


        for (Map.Entry<String,Integer> entry: map.entrySet()){
            minHeap.add(new mapitem(entry.getKey(),entry.getValue()));
            if (minHeap.size()>k){
                minHeap.poll();
            }
        }
        mapitem[] item = new mapitem[k];
        for (int i=0; i<k; i++){
            mapitem m = minHeap.poll();
            item[k-i-1] = m;
        }
        for (int i=0; i<k; i++){
            System.out.println(item[i].key + " " +item[i].val);
        }


    }




}
