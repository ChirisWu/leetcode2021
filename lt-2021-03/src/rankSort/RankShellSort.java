package rankSort;

import sun.util.resources.cldr.mg.LocaleNames_mg;

import javax.xml.stream.events.EndDocument;
import java.util.*;

/**
 * @by ：chiris
 * @when ：Created in 2021-04-10
 */
public class RankShellSort {





     public static void main(String[] args){

//         testShellSort(500);
//         testMergeSort(500);
//
//         testShellSort(1000);
//         testMergeSort(1000);
//
//         testShellSort(10000);
//         testMergeSort(10000);
//
//         testShellSort(500000);
//         testMergeSort(500000);k
         List<Rank> ranks = generateRanks(20);
         Comparator<Rank> comparator = (o1, o2) -> o1.getStar().compareTo(o2.getStar());
         SortUtil<Rank> sortUtil = new SortUtil<>();
         sortUtil.mergeSort(ranks, comparator );
         for (Rank rank : ranks) {
             System.out.println(rank);
         }

     }
     static void testShellSort(int sz){
         List<Rank> ranks = generateRanks(sz);
         Comparator<Rank> comparator = (o1, o2) -> o1.getStar().compareTo(o2.getStar());
         long start = System.currentTimeMillis();
         SortUtil.shellSort(ranks, comparator);
         System.out.println("shell sort completed,"+ ranks.size() + "cost "+ (System.currentTimeMillis() - start));
         long start2 = System.currentTimeMillis();
         SortUtil.shellSort(ranks, comparator);
         System.out.println("shell sort completed,"+ ranks.size() + "cost "+ (System.currentTimeMillis() - start2));

     }
     static void testMergeSort(int sz){
         List<Rank> ranks = generateRanks(sz);
         Comparator<Rank> comparator = (o1, o2) -> o1.getStar().compareTo(o2.getStar());
         SortUtil<Rank> sort = new SortUtil<>();
         long start = System.currentTimeMillis();
         sort.mergeSort(ranks, comparator);
         System.out.println("merge sort completed,"+ ranks.size() + "cost "+ (System.currentTimeMillis() - start));
         long start2 = System.currentTimeMillis();
         sort.mergeSort(ranks, comparator);
         System.out.println("merge sort completed,"+ ranks.size() + "cost "+ (System.currentTimeMillis() - start2));

     }

     private static void setRanks(List<Rank> ranks){
         long start = System.currentTimeMillis();
         int seed = 0;
         ranks.get(0).setRank(1);
         for (int i = 1; i < ranks.size(); i++){
             if (ranks.get(i - 1).getStar() == ranks.get(i).getStar()){
                 seed ++;
             }
             ranks.get(i).setRank(i + 1 - seed);
         }
         System.out.println("set rank completed cost " + (System.currentTimeMillis() - start));
     }

     private static  List<Rank> generateRanks(int size){
        List<Rank> res = new ArrayList<>(size);
        for (int i = 0; i < size; i++){
            res.add(new Rank(new Random().nextInt(100)));
        }
        return res;
     }
}



