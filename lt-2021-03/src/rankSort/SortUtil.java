package rankSort;

import com.sun.scenario.effect.Merge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @by ：chiris
 * @when ：Created in 2021-04-10
 */
public class SortUtil<T> {
    private T[] aux;

    /**
     * 希尔排序
     * 时间复杂度 O(NlgN)
     * 空间复杂度O(1)
     * 在排序属性大量重复的场景下，在200万以下的数量级能在毫秒级完成
     * @param list
     * @param comparator
     * @param <T>
     */
    public static <T> void shellSort(List<T> list, Comparator<T> comparator){
        int N = list.size();
        int h = 1;
        while(h < N / 3){
            h = h * 3 + 1;
        }
        while(h >= 1){
            for (int i = h; i < N; i ++){
                for (int j = i; j >= h && more(comparator, list.get(j), list.get(j - h)); j -= h){
                    swap(list, j , j - h);
                }
            }
            h /= 3;
        }
    }
    public void mergeSort(List<T> list, Comparator<T> comparator){
        aux = (T[]) new Object[list.size()];
        mergeSort(list, 0, list.size() - 1, comparator);

    }
    private void mergeSort(List<T> list,int lo,int hi, Comparator<T> comparator){
        if(lo == hi){
            return;
        }
        int mid = lo + (hi - lo)/2;
        mergeSort(list,lo,mid, comparator);
        mergeSort(list,mid + 1,hi, comparator);
        merge(list,lo,mid,hi, comparator);

    }
    public void merge(List<T> list,int lo,int mid, int hi, Comparator<T> comparator){
        for(int k = 0;k <= hi;k++){
            aux[k] = list.get(k);
        }
        int i = lo;
        int j = mid + 1;
        for(int k = lo; k <= hi; k++){
            if (i > mid) {
                list.set(k, aux[j++]);
            }
            else if (j > hi){
                list.set(k, aux[i++]);
            }
            else if(more(comparator, aux[i], aux[j])){
                list.set(k, aux[i++]);
            } else{
                list.set(k, aux[j++]);
            }

        }
    }

    private static  <T> void swap(List<T> list, int i, int j){
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
    private <T>boolean less (Comparator<T> comparator, T o1, T o2){
        int compare = comparator.compare(o1, o2);
        return compare < 0;
    }
    private static <T>boolean more (Comparator<T> comparator, T o1, T o2){
        int compare = comparator.compare(o1, o2);
        return compare > 0;
    }
}
