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
         List<Rank> ranks = generateRanks(400000);
         Comparator<Rank> comparator = new Comparator<Rank>(){
             @Override
             public int compare(Rank o1, Rank o2) {
                 return o1.getStar().compareTo(o2.getStar());
             }
         };
         long start = System.currentTimeMillis();
         SortUtil.shellSort(ranks, comparator);
         System.out.println("sort completed, cost "+ (System.currentTimeMillis() - start));


         System.out.println("set rank...");
         setRanks(ranks);
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
         long start = System.currentTimeMillis();
         System.out.println("generating " + size + " ranks");
        List<Rank> res = new ArrayList<>(size);
        for (int i = 0; i < size; i++){
            res.add(new Rank(new Random().nextInt(10)));
        }
         System.out.println("generate ranks completed cost: " + (System.currentTimeMillis() - start) + "ms");
        return res;
     }
}



