package day03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


//使用比较器创建小根堆
class LessIntComp implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }
}
//使用比较器创建大根堆
class GreaterIntComp implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}
public class TestDemo<E> {
    /**
     * 求最小的K个数，通过比较器创建大根堆
     */
    public static int[] smallestK(int[] array, int k) {
        if(k <= 0) {
            return new int[k];
        }
        GreaterIntComp greaterCmp = new GreaterIntComp();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(greaterCmp);
//先将前K个元素，创建大根堆
        for(int i = 0; i < k; i++) {
            maxHeap.offer(array[i]);
        }
//从第K+1个元素开始，每次和堆顶元素比较
        for (int i = k; i < array.length; i++) {
            int top = maxHeap.peek();
            if(array[i] < top) {
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }
//取出前K个
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            int val = maxHeap.poll();
            ret[i] = val;
        }
        return ret;
    }
    public static void main(String[] args) {
        int[] array = {4,1,9,2,8,0,7,3,6,5};
        int[] ret = smallestK(array,3);
        System.out.println(Arrays.toString(ret));
    }
}
