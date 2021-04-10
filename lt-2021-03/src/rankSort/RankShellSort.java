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
         List<Rank> ranks = generateRanks(100000);
         Comparator<Rank> comparator = new Comparator<Rank>(){
             @Override
             public int compare(Rank o1, Rank o2) {
                 return o1.getStar().compareTo(o2.getStar());
             }
         };
         SortUtil.shellSort(ranks, comparator);
         for (int i = 0; i < 100; i++) {
             System.out.println(ranks.get(i));
         }

     }

     private static  List<Rank> generateRanks(int size){
         long start = System.currentTimeMillis();
         System.out.println("generating " + size + " ranks");
        List<Rank> res = new ArrayList<>(size);
        for (int i = 0; i < size; i++){
            res.add(new Rank(new Random().nextInt(5)));
        }
         System.out.println("generate ranks completed cost: " + (System.currentTimeMillis() - start) + "ms");
        return res;
     }
}



